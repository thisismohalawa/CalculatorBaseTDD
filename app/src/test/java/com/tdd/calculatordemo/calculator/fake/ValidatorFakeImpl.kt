package com.tdd.calculatordemo.calculator.fake

import com.tdd.calculatordemo.data.source.IValidator

class ValidatorFakeImpl : IValidator {
    internal var succeed: Boolean = true
    internal var called: Boolean = false

    override suspend fun validateExpression(exp: String): Boolean {
        called = true
        return succeed
    }
}