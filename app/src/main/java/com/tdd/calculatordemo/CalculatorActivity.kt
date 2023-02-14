package com.tdd.calculatordemo

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tdd.calculatordemo.ui.ICalculatorUI
import com.tdd.calculatordemo.ui.ViewEvent
import kotlinx.android.synthetic.main.activity_calculator.*


/*
* Uncle Bob -> " keep your framework at arm length "
* Use few library as possible, more resistance to change over time.
*
* Dep:
*
* //Junit5
* testImplementation "org.junit.jupiter:junit-jupiter-api:5.8.2"
* testImplementation 'org.junit.jupiter:junit-jupiter-engine:5.8.2'
*
*
* Other:
* import kotlinx.android.synthetic.main.activity_calculator.*
* import org.junit.jupiter.api.Assertions.assertTrue
* import org.junit.jupiter.api.Test
*
*
* Shortcuts:
* Ctrl+Shift+N : look up in files.
* Ctrl+N : look up in classes.
*
* */
class CalculatorActivity : AppCompatActivity(),
    View.OnClickListener,
    View.OnLongClickListener,
    ICalculatorUI.View {

    lateinit var logic: ICalculatorUI.Logic

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)



        bindUserInterface()

    }

    companion object {
        const val DISPLAY_STATE = "STATE"
    }

    private fun bindUserInterface() {
        btnEvaluate.setOnClickListener(this)
        btnDelete.setOnClickListener(this)
        btnDelete.setOnLongClickListener(this)

        btnOne.setOnClickListener(this)
        btnTwo.setOnClickListener(this)

        btnAdd.setOnClickListener(this)
        btnSub.setOnClickListener(this)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString(DISPLAY_STATE, lbl_display.text.toString())
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        lbl_display.text = savedInstanceState.getString(DISPLAY_STATE, "")
        super.onRestoreInstanceState(savedInstanceState)
    }

    /* ------------Interface Functions-------------- */

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnEvaluate ->
                logic.handleViewEvent(ViewEvent.Evaluate)
            R.id.btnDelete ->
                logic.handleViewEvent(ViewEvent.Delete)
            else -> {
                if (v is Button) {
                    logic.handleViewEvent(
                        ViewEvent.Input(
                            v.text.toString()
                        )
                    )
                }
            }
        }
    }

    override fun onLongClick(v: View?): Boolean {
        when (v?.id) {
            R.id.btnDelete ->
                logic.handleViewEvent(ViewEvent.DeleteAll)
        }
        // IMPORTANT, Prevent onDelete function to be called out.
        return true
    }

    override var display: String
        get() = lbl_display.text.toString()
        set(value) {
            lbl_display.text = value
        }

    override fun showError(value: String) {
        Toast.makeText(this, value, Toast.LENGTH_SHORT).show()
    }
}