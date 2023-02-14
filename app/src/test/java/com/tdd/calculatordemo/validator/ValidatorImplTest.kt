package com.tdd.calculatordemo.validator

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ValidatorImplTest {

    val validator = ValidatorImpl

    val VALID_EXP_ONE = "2+2"
    val VALID_EXP_TWO = "6+8/6"
    val VALID_EXP_THREE = "6+8/2-7"

    val INVALID_EXP_ONE = "2+"
    val INVALID_EXP_TWO = "6++"
    val INVALID_EXP_THREE = "--2"
    val INVALID_EXP_FOUR = "2.."

    @Test
    fun `Test Valid Expressions`() = runBlocking {
        val resultOne = validator.validateExpression(VALID_EXP_ONE)
        assertTrue(resultOne)

        val resultTwo = validator.validateExpression(VALID_EXP_TWO)
        assertTrue(resultTwo)

        val resultThree = validator.validateExpression(VALID_EXP_THREE)
        assertTrue(resultThree)
    }

    @Test
    fun `Test InValid Expressions`() = runBlocking {
        val resultOne = validator.validateExpression(INVALID_EXP_ONE)
        assertFalse(resultOne)

        val resultTwo = validator.validateExpression(INVALID_EXP_TWO)
        assertFalse(resultTwo)

        val resultThree = validator.validateExpression(INVALID_EXP_THREE)
        assertFalse(resultThree)

        val resultFour = validator.validateExpression(INVALID_EXP_FOUR)
        assertFalse(resultFour)
    }
}