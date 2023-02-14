package com.tdd.calculatordemo.data.source

interface IValidator {
    suspend fun validateExpression(exp: String): Boolean
}