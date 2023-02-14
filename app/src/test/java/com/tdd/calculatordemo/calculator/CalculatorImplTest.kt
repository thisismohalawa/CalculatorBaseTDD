package com.tdd.calculatordemo.calculator

import com.tdd.calculatordemo.calculator.fake.CalculatorLogicFakeImpl
import com.tdd.calculatordemo.calculator.fake.EvaluatorFakeImpl
import com.tdd.calculatordemo.calculator.fake.ValidatorFakeImpl
import com.tdd.calculatordemo.data.CalculatorImpl
import com.tdd.calculatordemo.domain.ResultWrapper
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal const val VALID_EXP = "2+2"
internal const val INVALID_EXP = "2+++"
internal const val VALID_ANS = "4"

class CalculatorImplTest {

    // fake data
    private val validFakeImpl = ValidatorFakeImpl()
    private val evaluatorFakeImpl = EvaluatorFakeImpl()
    private val logicFakeImpl = CalculatorLogicFakeImpl()

    // base class
    private lateinit var calc: CalculatorImpl

    /*
    * 1. Give expression to validator:true = valid.
    * 2. Give expression to evaluator:string = successful.
    * 3. return the result to callback.
    *
    * */
    @Test
    fun `On Evaluate Valid Expression`() = runBlocking {
        calc = CalculatorImpl(validFakeImpl, evaluatorFakeImpl)

        logicFakeImpl.result = null
        calc.evaluateExpression(VALID_EXP, logicFakeImpl::handleResult)

        val result = logicFakeImpl.result

        if (result is ResultWrapper.Success) {
            assertEquals(result.value, VALID_ANS)
        } else {
            assertTrue(false)
        }

    }

    /*
    * 1. Give expression to validator:false = invalid.
    * 2. return the result to callback.
    *
    * */
    @Test
    fun `On Evaluate Invalid Expression`() = runBlocking {
        calc = CalculatorImpl(validFakeImpl, evaluatorFakeImpl)
        logicFakeImpl.result = null
        validFakeImpl.succeed = false

        calc.evaluateExpression(INVALID_EXP, logicFakeImpl::handleResult)

        val result = logicFakeImpl.result

        if (result is ResultWrapper.Error) {
            assertTrue(true)
        } else {
            assertTrue(false)
        }

    }
}
