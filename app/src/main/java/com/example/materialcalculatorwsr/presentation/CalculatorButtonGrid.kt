package com.example.materialcalculatorwsr.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.materialcalculatorwsr.domain.CalculatorAction

@Composable
fun CalculatorButtonGrid(
    uiActions: List<CalculatorUiAction>,
    onAction: (CalculatorAction) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        userScrollEnabled = false,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier,
        content = {
            items(uiActions) { uiAction ->
                CalculatorButton(
                    action = uiAction,
                    modifier = Modifier.aspectRatio(1f),
                    onClick = { onAction(uiAction.action) }
                )
            }
        }
    )
}

@Preview
@Composable
private fun CalculatorButtonGridPreview() {
    CalculatorButtonGrid(
        uiActions = calculatorActions,
        onAction =  {}
    )
}