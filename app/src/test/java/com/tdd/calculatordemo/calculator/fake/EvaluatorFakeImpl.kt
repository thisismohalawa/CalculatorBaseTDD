package com.tdd.calculatordemo.calculator.fake

import com.tdd.calculatordemo.calculator.VALID_ANS
import com.tdd.calculatordemo.data.source.IEvaluator
import com.tdd.calculatordemo.domain.ResultWrapper

class EvaluatorFakeImpl : IEvaluator {
    internal var succeed: Boolean = true
    internal var called: Boolean = false

    override suspend fun evaluateExpression(exp: String): ResultWrapper<Exception, String> {
        called = true
        return if (succeed) ResultWrapper.build { VALID_ANS }
        else ResultWrapper.build { throw Exception() }
    }
}