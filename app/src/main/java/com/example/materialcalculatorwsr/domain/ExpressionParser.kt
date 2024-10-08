package com.example.materialcalculatorwsr.domain

//TDD - Test Driven Development
class ExpressionParser(
    private val calculation: String
) {
    fun parse(): List<ExpressionPart> {
        val result = mutableListOf<ExpressionPart>()

        var i = 0
        while (i < calculation.length) {
            val curChar = calculation[i]
            when {
                curChar in operationsSymbols -> {
                    result.add(ExpressionPart.Op(operationFromSymbol(curChar)))
                }

                curChar.isDigit() -> {
                     i = parseNumber(i, result)
                    continue
                }
                curChar in "()" -> {
                    parseParenteses(curChar, result)
                }
            }
            i++
        }
        return result
    }

    private fun parseParenteses(curChar: Char, result: MutableList<ExpressionPart>) {
        result.add(
            ExpressionPart.Parentheses(
                type = when(curChar) {
                    '(' -> ParenthesesType.Opening
                    ')' -> ParenthesesType.Closing
                    else -> throw IllegalArgumentException("Invalid parentheses type")
                }
            )
        )
    }

    private fun parseNumber(startingIndex: Int, result: MutableList<ExpressionPart>): Int {
        var i = startingIndex
        val numberAsString = buildString {
            while (i < calculation.length && calculation[i] in "0123456789.") {
                append(calculation[i])
                i++
            }
        }
        result.add(ExpressionPart.Number(numberAsString.toDouble()))
        return i
    }

}