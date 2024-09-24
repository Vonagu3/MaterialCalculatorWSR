package com.example.materialcalculatorwsr.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.materialcalculatorwsr.domain.CalculatorAction

@Composable
fun CalculatorScreen(
    viewModel: CalculatorViewModel = viewModel()
) {

    Column {
        Text(text = viewModel.expression)
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = {
            viewModel.onAction(CalculatorAction.Number(5))
        }){
            Text(text = "Нажми 5")
        }
    }
}