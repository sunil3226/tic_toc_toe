package com.example.tictoctoe

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var flag = 0
    var counter = 0
    lateinit var display: TextView

    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var btn3: Button
    lateinit var btn4: Button
    lateinit var btn5: Button
    lateinit var btn6: Button
    lateinit var btn7: Button
    lateinit var btn8: Button
    lateinit var btn9: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)

        display = findViewById(R.id.display)

        findViewById<Button>(R.id.resetButton).setOnClickListener {
            resetGame()
        }
    }

    fun click(view: View) {

        var currentbtn: Button = view as Button
        counter++

        if (currentbtn.text.isBlank()) {
            if (flag == 0) {
                currentbtn.text = "0"
                flag = 1
            } else {
                currentbtn.text = "*"
                flag = 0
            }

            if (counter > 4) {
                checkwincondition()
            }
        }
    }

    fun checkwincondition() {

        var b1 = btn1.text.toString()
        var b2 = btn2.text.toString()
        var b3 = btn3.text.toString()
        var b4 = btn4.text.toString()
        var b5 = btn5.text.toString()
        var b6 = btn6.text.toString()
        var b7 = btn7.text.toString()
        var b8 = btn8.text.toString()
        var b9 = btn9.text.toString()

        // Check Rows
        if (b1 == b2 && b2 == b3 && b1.isNotBlank()) {

            printmsg(b1)

            btn4.isEnabled = false
            btn5.isEnabled = false
            btn6.isEnabled = false
            btn7.isEnabled = false
            btn8.isEnabled = false
            btn9.isEnabled = false

        } else if (b4 == b5 && b5 == b6 && b4.isNotBlank()) {

            printmsg(b4)

            btn1.isEnabled = false
            btn2.isEnabled = false
            btn3.isEnabled = false
            btn7.isEnabled = false
            btn8.isEnabled = false
            btn9.isEnabled = false

        } else if (b7 == b8 && b8 == b9 && b7.isNotBlank()) {

            printmsg(b7)

            btn1.isEnabled = false
            btn2.isEnabled = false
            btn3.isEnabled = false
            btn4.isEnabled = false
            btn5.isEnabled = false
            btn6.isEnabled = false

        }

        // Check columns
        else if (b1 == b4 && b4 == b7 && b1.isNotBlank()) {

            printmsg(b1)

            btn2.isEnabled = false
            btn3.isEnabled = false
            btn5.isEnabled = false
            btn6.isEnabled = false
            btn8.isEnabled = false
            btn9.isEnabled = false

        } else if (b2 == b5 && b5 == b8 && b2.isNotBlank()) {

            printmsg(b2)

            btn1.isEnabled = false
            btn3.isEnabled = false
            btn4.isEnabled = false
            btn6.isEnabled = false
            btn7.isEnabled = false
            btn9.isEnabled = false

        } else if (b3 == b6 && b6 == b9 && b3.isNotBlank()) {

            printmsg(b3)

            btn2.isEnabled = false
            btn1.isEnabled = false
            btn5.isEnabled = false
            btn4.isEnabled = false
            btn8.isEnabled = false
            btn7.isEnabled = false

        }

        // Check diagonals
        else if (b1 == b5 && b5 == b9 && b1.isNotBlank()) {

            printmsg(b1)

            btn2.isEnabled = false
            btn3.isEnabled = false
            btn4.isEnabled = false
            btn6.isEnabled = false
            btn8.isEnabled = false
            btn7.isEnabled = false

        } else if (b3 == b5 && b5 == b7 && b3.isNotBlank()) {

            printmsg(b3)

            btn2.isEnabled = false
            btn1.isEnabled = false
            btn4.isEnabled = false
            btn6.isEnabled = false
            btn8.isEnabled = false
            btn9.isEnabled = false

        }

        // Check for draw
        else if (b1.isNotBlank() && b2.isNotBlank() && b3.isNotBlank() && b4.isNotBlank() && b5.isNotBlank() && b6.isNotBlank() && b7.isNotBlank() && b8.isNotBlank() && b9.isNotBlank()) {

            display.text = " Tic Tac Toe \n It's a draw!"
            Toast.makeText(this, "It's a draw!", Toast.LENGTH_LONG).show()
            disableButtons()
        }
    }

    fun resetGame() {

        enableButtons()
        display.text = "Tic Tac Toe"

        btn1.text = ""
        btn2.text = ""
        btn3.text = ""
        btn4.text = ""
        btn5.text = ""
        btn6.text = ""
        btn7.text = ""
        btn8.text = ""
        btn9.text = ""

        counter = 0
        flag = 0
    }

    fun disableButtons() {
        btn1.isEnabled = false
        btn2.isEnabled = false
        btn3.isEnabled = false
        btn4.isEnabled = false
        btn5.isEnabled = false
        btn6.isEnabled = false
        btn7.isEnabled = false
        btn8.isEnabled = false
        btn9.isEnabled = false
    }

    fun enableButtons() {
        btn1.isEnabled = true
        btn2.isEnabled = true
        btn3.isEnabled = true
        btn4.isEnabled = true
        btn5.isEnabled = true
        btn6.isEnabled = true
        btn7.isEnabled = true
        btn8.isEnabled = true
        btn9.isEnabled = true
    }

    fun printmsg(msg: String) {
        display.text = " Tic Tac Toe \n $msg is the Winner"
        Toast.makeText(this, "$msg is the Winner", Toast.LENGTH_LONG).show()
    }
}