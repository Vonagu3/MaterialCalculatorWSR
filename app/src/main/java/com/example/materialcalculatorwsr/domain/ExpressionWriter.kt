package com.example.materialcalculatorwsr.domain

import kotlin.math.exp

class ExpressionWriter {

    private var expression = ""

    fun processAction(action: CalculatorAction): String {
        when(action) {
            CalculatorAction.Calculate -> {
                val parser = ExpressionParser(expression)
                val evaluator = ExpressionEvaluator(parser.parse())
                expression = evaluator.evaluate().toString()
            }
            CalculatorAction.Clear -> {
                expression = ""
            }
            CalculatorAction.Decimal -> {
                if (canEnterDecimal()) {
                    expression += "."
                }
            }
            CalculatorAction.Delete -> {
                expression = expression.dropLast(1)
            }
            is CalculatorAction.Number -> {
                expression += action.number
            }
            is CalculatorAction.Op -> {
                if(canEnterOperation(action.operation)) {
                    expression += action.operation.symbol
                }
            }
            CalculatorAction.Parentheses -> {
                processParentheses()
            }
        }
        return expression
    }

    private fun canEnterDecimal(): Boolean {
        if (expression.isEmpty() || expression.last() in "$operationsSymbols.()") {
            return false
        }
        return !expression.takeLastWhile {
            it in "0123456789."
        }.contains(".")
    }

    private fun canEnterOperation(operation: Operation): Boolean {
        if (operation in listOf(Operation.ADD, Operation.SUBTRACT)) {
            return expression.isEmpty() || expression.last() in "$operationsSymbols()0123456789"
        }
        return expression.isNotEmpty() || expression.last() in "0123456789)"
    }

    private fun processParentheses() {
        val openingCount = expression.count { it == '(' }
        val closingCount = expression.count { it == ')' }
        expression += when {
            expression.isEmpty() || expression.last() in "$operationsSymbols(" -> "("
            expression.last() in "0123456789)" && openingCount == closingCount -> return
            else -> ")"
        }
    }
}