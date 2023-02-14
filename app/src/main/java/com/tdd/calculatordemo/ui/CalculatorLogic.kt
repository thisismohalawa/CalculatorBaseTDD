package com.tdd.calculatordemo.ui

import com.tdd.calculatordemo.domain.ResultWrapper
import com.tdd.calculatordemo.ui.source.ICalculator
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class CalculatorLogic(
    private val view: ICalculatorUI.View, // view
    private val calc: ICalculator, // facade
    private val dispatcher: CoroutineDispatcher
) : ICalculatorUI.Logic, CoroutineScope {

    private val jobTracker: Job = Job()
    override val coroutineContext: CoroutineContext
        get() = dispatcher + jobTracker


    override fun handleViewEvent(event: ViewEvent) {
        when (event) {
            is ViewEvent.Evaluate -> evaluateExpression()
            is ViewEvent.Delete -> deleteChar()
            is ViewEvent.DeleteAll -> view.display = ""
            is ViewEvent.Input -> view.display = view.display + event.input
        }
    }

    private fun evaluateExpression() = launch {
        calc.evaluateExpression(view.display, ::handleResult)
    }

    private fun deleteChar() {
        val currentExpr = view.display
        if (currentExpr.isNotEmpty()) view.display = currentExpr.dropLast(1)
    }

    override fun handleResult(result: ResultWrapper<Exception, String>) {
        when (result) {
            is ResultWrapper.Success -> view.display = result.value
            is ResultWrapper.Error -> view.showError(GENERIC_ERROR_MESS)
        }
    }
}