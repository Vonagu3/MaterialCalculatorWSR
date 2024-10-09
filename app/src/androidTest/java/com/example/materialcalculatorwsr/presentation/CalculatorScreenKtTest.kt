package com.example.materialcalculatorwsr.presentation

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.materialcalculatorwsr.MainActivity
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class CalculatorScreenKtTest {

    @get:Rule
    val composeRule = createAndroidComposeRule(MainActivity::class.java)

    @Test
    fun testEnterExpression_correctResultDisplayed() {
        composeRule.onNodeWithText("1").performClick()
        composeRule.onNodeWithText("+").performClick()
        composeRule.onNodeWithText("2").performClick()
        composeRule.onNodeWithText("x").performClick()
        composeRule.onNodeWithText("3").performClick()
        composeRule.onNodeWithText("-").performClick()
        composeRule.onNodeWithText("5").performClick()
        composeRule.onNodeWithText("=").performClick()

        composeRule.onNodeWithText("2.0").assertIsDisplayed()
    }
}