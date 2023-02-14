package com.tdd.calculatordemo.calcuatorlogic.fake

import com.tdd.calculatordemo.domain.ResultWrapper
import com.tdd.calculatordemo.ui.source.ICalculator

class CalculatorFakeImpl : ICalculator {
    var succeed = false

    override suspend fun evaluateExpression(
        exp: String,
        callback: (ResultWrapper<Exception, String>) -> Unit
    ) {
        if (succeed) callback.invoke(ResultWrapper.build { "4" })
        else callback.invoke(ResultWrapper.build { throw Exception() })
    }
}