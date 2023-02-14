package com.tdd.calculatordemo.evaluator

import com.tdd.calculatordemo.data.source.IEvaluator
import com.tdd.calculatordemo.domain.ResultWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object EvaluatorImpl : IEvaluator {

    override suspend fun evaluateExpression(exp: String): ResultWrapper<Exception, String> =
        withContext(Dispatchers.IO) {
            /*
            * Jump to different thread.
            *
            *
            * */
            TODO("Not Implemented")
        }

}