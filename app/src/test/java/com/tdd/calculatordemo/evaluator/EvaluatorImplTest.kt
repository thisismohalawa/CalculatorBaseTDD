package com.tdd.calculatordemo.evaluator

import com.tdd.calculatordemo.domain.ResultWrapper
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class EvaluatorImplTest {

    val evaluator = EvaluatorImpl

    val VALID_EXP_ONE = "2+2"
    val VALID_EXP_TWO = "6*8/6"
    val VALID_EXP_THREE = "6+8/2-7"

    val VALID_ANS_ONE = "4.0"
    val VALID_ANS_TWO = "8.0"
    val VALID_ANS_THREE = "3.0"


    @Test
    fun `Test Valid Expression`() = runBlocking {

        val resultOne = evaluator.evaluateExpression(VALID_EXP_ONE)
        if (resultOne is ResultWrapper.Success) {
            assertEquals(resultOne.value, VALID_ANS_ONE)
        } else {
            assertTrue(false)
        }

        val resultTwo = evaluator.evaluateExpression(VALID_EXP_TWO)
        if (resultTwo is ResultWrapper.Success) {
            assertEquals(resultTwo.value, VALID_ANS_TWO)
        } else {
            assertTrue(false)
        }


        val resultThree = evaluator.evaluateExpression(VALID_EXP_THREE)
        if (resultThree is ResultWrapper.Success) {
            assertEquals(resultThree.value, VALID_ANS_THREE)
        } else {
            assertTrue(false)
        }

    }
}