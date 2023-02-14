package com.tdd.calculatordemo.data.datamodel


data class Operator(val operatorValue: String) {
    val evaluateFirst: Boolean = checkPriority(operatorValue)

    private fun checkPriority(operatorValue: String): Boolean {
        return when (operatorValue) {
            "*" -> true
            "/" -> true
            "-" -> false
            "+" -> false
            else -> throw java.lang.IllegalArgumentException("Illegal Operator.")
        }
    }

}
