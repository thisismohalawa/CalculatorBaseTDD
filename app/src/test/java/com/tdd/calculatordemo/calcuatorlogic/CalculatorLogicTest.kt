package com.tdd.calculatordemo.calcuatorlogic

import com.tdd.calculatordemo.calcuatorlogic.fake.CalculatorFakeImpl
import com.tdd.calculatordemo.calcuatorlogic.fake.CalculatorViewFakeImpl
import com.tdd.calculatordemo.ui.CalculatorLogic
import com.tdd.calculatordemo.ui.ViewEvent
import kotlinx.coroutines.Dispatchers
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test


/**
 * Basic process for test driven development:
 * 1. Create test data and test doubles necessary for tests.
 * 2. Create a copy of the real object we wish to test.
 * 3. Call function (Units) on this real object using the test data and test doubles
 * 4. Check the resulting behaviour and state.
 *
 *
 *
 * Traditional TDD:
 * 1. Not suppose to write the implementation until we have a failing test.
 *
 *
 */

class CalculatorLogicTest {

    /*
    * Testing the behaviour not the implementation.
    * ===
    * Base class parameters:
    *
    * val view: ICalculatorUI.View, // as view
    * val calc: ICalculator, // as facade
    *
    *  */
    private lateinit var viewFake: CalculatorViewFakeImpl
    private lateinit var calcFake: CalculatorFakeImpl
    private val dispatcher = Dispatchers.Unconfined

    // Base Logic,
    // real object we wish to test.
    lateinit var calculatorLogin: CalculatorLogic

    /*
    * User Stories, On Evaluate.
    *
    * 1. Get current display state from the view.
    * 2. Give the state to calc for evaluation.
    * 3. Verify callback invoked on the view.
    *
    * */
    @Test
    fun `On Evaluate event success`() {
        viewFake = CalculatorViewFakeImpl()
        calcFake = CalculatorFakeImpl()
        calcFake.succeed = true

        calculatorLogin = CalculatorLogic(
            viewFake,
            calcFake,
            dispatcher
        )

        calculatorLogin.handleViewEvent(ViewEvent.Evaluate)

        assertTrue(viewFake.getDisplayCalled)
        assertTrue(viewFake.setDisplayCalled)

    }
}