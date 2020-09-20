package com.example.tazaoyin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var firstNumber:Int=0
    private var secondNumber:Int=0
    private var operator:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        playGame()
    }
    fun variantClick(view: View){
        val intent=Intent(this, SecondActivity::class.java)
        if ((view as Button).text.toString().toInt()==getRightAnswer()){
            intent.putExtra("result", "Right!")
        }else{
            intent.putExtra("result", "Wrong!")}
            startActivity(intent)
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