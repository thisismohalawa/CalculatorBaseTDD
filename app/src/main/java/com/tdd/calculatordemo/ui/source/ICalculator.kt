package com.tdd.calculatordemo.ui.source

import com.tdd.calculatordemo.domain.ResultWrapper

/*
* repository pattern:
* backend or sub-system which is hidden behind an abstraction.
*
*
* */
interface ICalculator {
    suspend fun evaluateExpression(
        exp: String,
        callback: (ResultWrapper<Exception, String>) -> Unit
    )
}