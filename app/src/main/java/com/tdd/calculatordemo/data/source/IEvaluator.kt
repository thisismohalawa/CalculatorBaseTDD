package com.tdd.calculatordemo.data.source

import com.tdd.calculatordemo.domain.ResultWrapper


// calculate
interface IEvaluator {
    suspend fun evaluateExpression(exp: String): ResultWrapper<Exception, String>
}
