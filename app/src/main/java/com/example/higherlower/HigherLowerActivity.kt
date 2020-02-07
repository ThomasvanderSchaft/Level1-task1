package com.example.higherlower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class HigherLowerActivity : AppCompatActivity() {
    private var currentThrow: Int = 1
    private var lastThrow: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initViews()
    }

    private fun initViews() {

        btnEquels.setOnClickListener {
            rollDice()
            onEqualClick()
        }
        btnLower.setOnClickListener {
            rollDice()
            onLowerClick()
        }
        btnHigher.setOnClickListener {
            rollDice()
            onHigherClick()
        }
        updateUI()
    }

    private fun rollDice() {
        lastThrow = currentThrow
        currentThrow = (1..6).random()
        println("Huidige: $lastThrow + nieuwe: $currentThrow")
        updateUI()
    }
    private fun onHigherClick() {
        if (currentThrow > lastThrow){
            onAnswerCorrect()
        }
        else{
            onAnswerIncorrect()
        }
    }

    private fun onLowerClick() {
        if (currentThrow < lastThrow){
            onAnswerCorrect()
        }
        else{
            onAnswerIncorrect()
        }
    }

    private fun onEqualClick() {
        if (currentThrow == lastThrow){
            onAnswerCorrect()
        }
        else{
            onAnswerIncorrect()
        }
    }

    private fun onAnswerCorrect() {
        Toast.makeText(this@HigherLowerActivity, getString(R.string.correct), Toast.LENGTH_LONG).show()
    }

    private fun onAnswerIncorrect() {
        Toast.makeText(this@HigherLowerActivity, getString(R.string.incorrect), Toast.LENGTH_LONG).show()
    }



    fun updateUI(){
        tvLastThrow.text = getString(R.string.last_throw, lastThrow)

        when (currentThrow) {
            1 -> diceThrow.setImageResource(R.drawable.dice1)
            2 -> diceThrow.setImageResource(R.drawable.dice2)
            3 -> diceThrow.setImageResource(R.drawable.dice3)
            4 -> diceThrow.setImageResource(R.drawable.dice4)
            5 -> diceThrow.setImageResource(R.drawable.dice5)
            6 -> diceThrow.setImageResource(R.drawable.dice6)
        }


    }
}
