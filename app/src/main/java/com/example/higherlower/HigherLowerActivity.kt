package com.example.higherlower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @author Thomas van der Schaft
 */

class HigherLowerActivity : AppCompatActivity() {
    private var currentThrow: Int = 1
    private var lastThrow: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //call method initViews
        initViews()
    }

    private fun initViews() {

        //create a listener event when one of the buttons is clicked
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
        //call method to update User Interface
        updateUI()
    }

    private fun rollDice() {

        //Overwrite the last throw when dice have been rolled. If they have not been rolled before,
        // it will overwrite with a standard value of 1 specified above
        lastThrow = currentThrow

        //Give the current throw a random number between the values 1 and 6
        currentThrow = (1..6).random()

        //Print the variables lastThrow and currentThrow in the console
        println("Huidige: $lastThrow + nieuwe: $currentThrow")

        //Update user interface with new values
        updateUI()
    }
    private fun onHigherClick() {
        //statement to check if the new value is higher than the previous throw
        if (currentThrow > lastThrow){
            //call method when the statement returns a true value
            onAnswerCorrect()
        }
        else{
            //call method when the statement returns a false value
            onAnswerIncorrect()
        }
    }

    private fun onLowerClick() {
        //statement to check if the new value is lower than the previous throw
        if (currentThrow < lastThrow){
            //call method when the statement returns a true value
            onAnswerCorrect()
        }
        else{
            //call method when the statement returns a false value
            onAnswerIncorrect()
        }
    }

    private fun onEqualClick() {
        //statement to check if the new value is equal to the previous throw
        if (currentThrow == lastThrow){
            //call method when the statement returns a true value
            onAnswerCorrect()
        }
        else{
            //call method when the statement returns a false value
            onAnswerIncorrect()
        }
    }

    private fun onAnswerCorrect() {
        //Create toast message on current activity
        Toast.makeText(this@HigherLowerActivity, getString(R.string.correct), Toast.LENGTH_LONG).show()
    }

    private fun onAnswerIncorrect() {
        //Create toast message on current activity
        Toast.makeText(this@HigherLowerActivity, getString(R.string.incorrect), Toast.LENGTH_LONG).show()
    }



    fun updateUI(){
        //update textView with the variable of the last throw
        tvLastThrow.text = getString(R.string.last_throw, lastThrow)

        //update imageResource depending on the current throw
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
