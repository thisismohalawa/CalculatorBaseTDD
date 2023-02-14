package com.tdd.calculatordemo.ui

import com.tdd.calculatordemo.domain.ResultWrapper

const val GENERIC_ERROR_MESS = "Invalid."

/*
* communicator with frontend.
*
*
* */
interface ICalculatorUI {

    interface View {
        var display: String // get & set the display.
        fun showError(value: String)
    }

    interface Logic {
        // presentation logic
        fun handleViewEvent(event: ViewEvent)
        fun handleResult(result: ResultWrapper<Exception, String>)
    }
}

sealed class ViewEvent {
    data class Input(val input: String) : ViewEvent()
    object Evaluate : ViewEvent()
    object Delete : ViewEvent()
    object DeleteAll : ViewEvent()
}