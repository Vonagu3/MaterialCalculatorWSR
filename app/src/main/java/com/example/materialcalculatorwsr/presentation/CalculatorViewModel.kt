package com.example.materialcalculatorwsr.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.materialcalculatorwsr.domain.CalculatorAction
import com.example.materialcalculatorwsr.domain.ExpressionWriter

class CalculatorViewModel(
    private val writer: ExpressionWriter = ExpressionWriter()
): ViewModel() {

    var expression by mutableStateOf("")
        private set

    fun onAction(action: CalculatorAction) {
        expression = writer.processAction(action)

    }
}