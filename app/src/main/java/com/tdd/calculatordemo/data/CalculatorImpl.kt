package com.tdd.calculatordemo.data

import com.tdd.calculatordemo.data.source.IEvaluator
import com.tdd.calculatordemo.data.source.IValidator
import com.tdd.calculatordemo.domain.ResultWrapper
import com.tdd.calculatordemo.ui.source.ICalculator

class CalculatorImpl(
    val validator: IValidator,
    val evaluator: IEvaluator
) : ICalculator {

    override suspend fun evaluateExpression(
        exp: String,
        callback: (ResultWrapper<Exception, String>) -> Unit
    ) {
        if (validator.validateExpression(exp))
            callback.invoke(
                evaluator.evaluateExpression(exp)
            )
        else
            callback.invoke(ResultWrapper.build { throw Exception() })
    }
}