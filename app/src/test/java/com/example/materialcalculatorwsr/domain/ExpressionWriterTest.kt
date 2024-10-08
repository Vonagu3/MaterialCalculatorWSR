package com.example.materialcalculatorwsr.domain

import com.google.common.truth.Truth
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class ExpressionWriterTest {

    private lateinit var writer: ExpressionWriter
//    private var writer: ExpressionWriter = ExpressionWriter()

    @Before
    fun setUp() {
        writer = ExpressionWriter()
    }

    @Test
    fun `Initial parentheses parsed`() {

        writer.processAction(CalculatorAction.Parentheses)
        writer.processAction(CalculatorAction.Number(5))
        writer.processAction(CalculatorAction.Op(Operation.ADD))
        writer.processAction(CalculatorAction.Number(4))
        writer.processAction(CalculatorAction.Parentheses)

        Truth.assertThat(writer.expression).isEqualTo("(5+4)")
    }

    @Test
    fun `Closing parentheses at the start not parsed`() {
        writer.processAction(CalculatorAction.Parentheses)
        writer.processAction(CalculatorAction.Parentheses)

        Truth.assertThat(writer.expression).isEqualTo("((")
    }

    @Test
    fun `Parentheses around a number are parsed`() {
        writer.processAction(CalculatorAction.Parentheses)
        writer.processAction(CalculatorAction.Number(6))
        writer.processAction(CalculatorAction.Parentheses)

        Truth.assertThat(writer.expression).isEqualTo("(6)")
    }
}