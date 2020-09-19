package com.example.tazaoyin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    companion object{
        const val LEVEL_COUNT = 10
        const val RIGHT_ANSWERS_COUNT="rightAnswersCount"
        const val WRONG_ANSWERS_COUNT="wrongAnswersCount"
    }
    private var firstNumber:Int=0
    private var secondNumber:Int=0
    private var operator:String=""
    private var trueAnswer:Int=0
    private var falseAnswer:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        playGame()
    }
    fun variantClick(view: View){
        val selectedAnswer=(view as Button).text.toString().toInt()
        if (selectedAnswer==getRightAnswer()){
            trueAnswer++
        }else{
            falseAnswer++
        }
        if(trueAnswer+falseAnswer== LEVEL_COUNT) {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(RIGHT_ANSWERS_COUNT, trueAnswer)
            intent.putExtra(WRONG_ANSWERS_COUNT,falseAnswer)
            startActivity(intent)
        } else {
            playGame()
        }
    }
    private fun playGame(){
        firstNumber=generationRandomNumber(10,100)
        secondNumber=generationRandomNumber(10,100)
        operator=generateRandomOperator()
        tvfirst.text=firstNumber.toString()
        third.text=secondNumber.toString()
        tvsecond.text=operator
        generateWrongAnswer()
        setRightAnswer()

    }
    private fun generationRandomNumber(start:Int, end:Int):Int= Random.nextInt(start,end)

    private fun generateRandomOperator():String{
        return when(generationRandomNumber(0,4)){
            0->"+"
            1->"-"
            2->"*"
            3->"/"
            else->"+"
        }
    }

    private fun getRightAnswer():Int{
        return when (operator){
            "+"-> firstNumber + secondNumber
            "-"-> firstNumber - secondNumber
            "*"-> firstNumber * secondNumber
            "/"-> firstNumber / secondNumber
            else-> firstNumber+secondNumber
        }
    }

    private fun generateWrongAnswer(){
        val answer=getRightAnswer()
        val variantA=when(generationRandomNumber(0,2)){
            0->answer-generationRandomNumber(3,100)
            1->answer+generationRandomNumber(3,100)
            else->answer+generationRandomNumber(3,100)
        }
        val variantB=when(generationRandomNumber(0,2)){
            0->answer-generationRandomNumber(3,100)
            1->answer+generationRandomNumber(3,100)
            else->answer+generationRandomNumber(3,100)
        }
        val variantC=when(generationRandomNumber(0,2)){
            0->answer-generationRandomNumber(3,100)
            1->answer+generationRandomNumber(3,100)
            else->answer+generationRandomNumber(3,100)
        }
        val variantD=when (generationRandomNumber(0,2)){
            0->answer-generationRandomNumber(3,100)
            1->answer+generationRandomNumber(3,100)
            else->answer+generationRandomNumber(3,100)
        }
        btnA.text=variantA.toString()
        btnB.text=variantB.toString()
        btnC.text=variantC.toString()
        btnD.text=variantD.toString()
    }
    fun setRightAnswer(){
        val answer=getRightAnswer()
        when(generationRandomNumber(0,4)){
            0->btnA.text=answer.toString()
            1->btnB.text=answer.toString()
            2->btnC.text=answer.toString()
            3->btnD.text=answer.toString()
            else-> btnA.text=answer.toString()
        }
    }
}