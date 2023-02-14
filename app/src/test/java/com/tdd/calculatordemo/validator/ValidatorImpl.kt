package com.tdd.calculatordemo.validator

import com.tdd.calculatordemo.data.source.IValidator

object ValidatorImpl : IValidator {

    override suspend fun validateExpression(exp: String): Boolean {
        if (invalidStart(exp)) return false
        if (invalidEnd(exp)) return false

        if (hasConcurrentOperators(exp)) return false
        if (hasConcurrentDecimals(exp)) return false
        if (hasTooManyDecimalsPerOperand(exp)) return false

        return true
    }

    private fun invalidStart(exp: String): Boolean {
        return false
    }

    private fun invalidEnd(exp: String): Boolean {
        return false
    }

    private fun hasConcurrentOperators(exp: String): Boolean {
        return false
    }


    private fun hasConcurrentDecimals(exp: String): Boolean {
        return false
    }

    private fun hasTooManyDecimalsPerOperand(exp: String): Boolean {
        return false
    }
}