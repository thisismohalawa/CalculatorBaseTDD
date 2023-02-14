package com.tdd.calculatordemo.calculator.fake

import com.tdd.calculatordemo.domain.ResultWrapper
import com.tdd.calculatordemo.ui.ICalculatorUI
import com.tdd.calculatordemo.ui.ViewEvent

class CalculatorLogicFakeImpl : ICalculatorUI.Logic {

    var handleResultCalled = false
    var result: ResultWrapper<Exception, String>? = null

    override fun handleViewEvent(event: ViewEvent) {
        TODO("not implemented.")
    }

    override fun handleResult(result: ResultWrapper<Exception, String>) {
        this.result = result
        handleResultCalled = true
    }
}
