package com.example.materialcalculatorwsr.presentation

import androidx.compose.runtime.Composable
import com.example.materialcalculatorwsr.domain.CalculatorAction

/**
 * Модель действия кнопки
 *
 * @property text текст внутри кнопки
 * @property highlightLevel уровень выделения
 * @property action действие по нажатию
 * @property content содержимое
 */
data class CalculatorUiAction(
    val text: String?,
    val highlightLevel: HighlightLevel,
    val action: CalculatorAction,
    val content: @Composable () -> Unit = {}
)

sealed interface HighlightLevel {
    object Neutral: HighlightLevel
    object SemiHighlighted: HighlightLevel
    object Highlighted: HighlightLevel
    object StronglyHighlighted: HighlightLevel
}
