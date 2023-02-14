package com.tdd.calculatordemo.calcuatorlogic.fake

import com.tdd.calculatordemo.ui.ICalculatorUI

class CalculatorViewFakeImpl : ICalculatorUI.View {

    /*---Testing the behaviour not the implementation----*/
    /*---As Verification statement----*/
    var setDisplayCalled: Boolean = false
    var getDisplayCalled: Boolean = false
    var showErrorCalled: Boolean = false
    var experssion: String = ""

    override var display: String
        get() {
            getDisplayCalled = true
            return experssion
        }
        set(value) {
            setDisplayCalled = true
            experssion = value
        }

    override fun showError(value: String) {
        showErrorCalled = true
    }
}