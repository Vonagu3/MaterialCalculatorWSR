package com.example.materialcalculatorwsr.domain

enum class Operation(val symbol: Char) {
    ADD('+'),
    SUBTRACT('-'),
    MULTIPLY('x'),
    DIVIDE('÷'),
    PERCENT('%')
}
// 2+3-(2+4)=
val operationsSymbols = Operation.entries.map { it.symbol }.joinToString("") // +-x...

fun operationFromSymbol(symbol: Char): Operation {
    return Operation.entries.find { it.symbol == symbol }
        ?: throw IllegalArgumentException("Invalid symbol")
}