package com.example.calcilator

import android.content.res.Configuration.ORIENTATION_LANDSCAPE
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.udojava.evalex.Expression

class MainActivity : AppCompatActivity() {

    var tvOutput: TextView? = null
    var tvInput: TextView? = null
    var Input: String = "Input"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnZero = findViewById<Button>(R.id.btn_Zero)
        val btnOne = findViewById<Button>(R.id.btn_One)
        val btnTwo = findViewById<Button>(R.id.btn_Two)
        val btnThree = findViewById<Button>(R.id.btn_Three)
        val btnFour = findViewById<Button>(R.id.btn_Four)
        val btnFive = findViewById<Button>(R.id.btn_Five)
        val btnSix = findViewById<Button>(R.id.btn_Six)
        val btnSeven = findViewById<Button>(R.id.btn_Seven)
        val btnEight = findViewById<Button>(R.id.btn_Eight)
        val btnNine = findViewById<Button>(R.id.btn_Nine)

        val btnDot = findViewById<Button>(R.id.btn_Dot)
        val btnDevide = findViewById<Button>(R.id.btn_Devide)
        val btnMultiplus = findViewById<Button>(R.id.btn_Multiplus)
        val btnMinus = findViewById<Button>(R.id.btn_Minus)
        val btnPlus = findViewById<Button>(R.id.btn_Plus)
        val btnPercent = findViewById<Button>(R.id.btn_Percent)
        val btnAC = findViewById<Button>(R.id.btn_AC)
        val btnDelete = findViewById<ImageButton>(R.id.btn_Delete)
        val btnEquals = findViewById<Button>(R.id.btn_Equals)

        if (resources.configuration.orientation == ORIENTATION_LANDSCAPE) {
            val btnRightBracket = findViewById<Button>(R.id.btn_RightBracket)
            val btnLeftBracket = findViewById<Button>(R.id.btn_LeftBraket)
            val btnArrowUp = findViewById<Button>(R.id.btn_ArrowUp)
            val btnE = findViewById<Button>(R.id.btn_E)
            val btnPI = findViewById<Button>(R.id.btn_PI)

            val btnSin = findViewById<Button>(R.id.btn_Sin)
            val btnCos = findViewById<Button>(R.id.btn_Cos)
            val btnTg = findViewById<Button>(R.id.btn_Tg)
            val btnLog = findViewById<Button>(R.id.btn_Log)
            val btnFact = findViewById<Button>(R.id.btn_Fact)
            val btnSqrt = findViewById<Button>(R.id.btn_Sqrt)

            btnRightBracket.setOnClickListener { addSymbolToInputTextView("(") }
            btnLeftBracket.setOnClickListener { addSymbolToInputTextView(")") }
            btnArrowUp.setOnClickListener { addSymbolToInputTextView("^") }
            btnE.setOnClickListener { addSymbolToInputTextView("e") }
            btnPI.setOnClickListener { addSymbolToInputTextView("PI") }

            btnSin.setOnClickListener { addSymbolToInputTextView("sin(") }
            btnCos.setOnClickListener { addSymbolToInputTextView("cos(") }
            btnTg.setOnClickListener { addSymbolToInputTextView("tan(") }
            btnLog.setOnClickListener { addSymbolToInputTextView("log(") }
            btnFact.setOnClickListener { addSymbolToInputTextView("FACT(") }
            btnSqrt.setOnClickListener { addSymbolToInputTextView("SQRT(") }

        }

        tvOutput = findViewById<TextView>(R.id.tv_Output)
        tvInput = findViewById<TextView>(R.id.tv_Input)

        btnZero.setOnClickListener { addSymbolToInputTextView("0") }
        btnOne.setOnClickListener { addSymbolToInputTextView("1") }
        btnTwo.setOnClickListener { addSymbolToInputTextView("2") }
        btnThree.setOnClickListener { addSymbolToInputTextView("3") }
        btnFour.setOnClickListener { addSymbolToInputTextView("4") }
        btnFive.setOnClickListener { addSymbolToInputTextView("5") }
        btnSix.setOnClickListener { addSymbolToInputTextView("6") }
        btnSeven.setOnClickListener { addSymbolToInputTextView("7") }
        btnEight.setOnClickListener { addSymbolToInputTextView("8") }
        btnNine.setOnClickListener { addSymbolToInputTextView("9") }

        btnDot.setOnClickListener { addSymbolToInputTextView(".") }
        btnDevide.setOnClickListener { addSymbolToInputTextView("/") }
        btnMultiplus.setOnClickListener { addSymbolToInputTextView("*") }
        btnMinus.setOnClickListener { addSymbolToInputTextView("-") }
        btnPlus.setOnClickListener { addSymbolToInputTextView("+") }
        btnPercent.setOnClickListener { addSymbolToInputTextView("%") }
        btnAC.setOnClickListener { clearInputTextField() }
        btnDelete.setOnClickListener { removeLastSymbol() }
        btnEquals.setOnClickListener { getResult() }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("input", Input)
        outState.putString("output", tvOutput?.text.toString())
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        tvInput?.text = savedInstanceState.getString("input")
        tvOutput?.text = savedInstanceState.getString("output")
    }

    fun addSymbolToInputTextView(symbol: String) {
        if (Input == "Input") { Input = "" }
        Input += symbol
        tvInput?.text = Input
    }

    fun removeLastSymbol() {
        Input = Input.dropLast(1)
        tvInput?.text = Input
    }

    fun clearInputTextField() {
        Input = ""
        tvInput?.text = Input
        tvOutput?.text = ""
    }

    fun getResult() {
        val expression = Expression(Input)
        try {
            tvOutput?.text = expression.eval().toString()
        } catch (error: Expression.ExpressionException) {
            tvOutput?.text = "Error"
        }
    }
}