package com.example.tazaoyin

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val dj=intent.getIntExtra(MainActivity.RIGHT_ANSWERS_COUNT,0)
        val qj=intent.getIntExtra(MainActivity.WRONG_ANSWERS_COUNT,0)
        TvResultTrue.text= dj.toString()
        TvResultFalse.text=qj.toString()

        btn6.setOnClickListener {
            val intent=Intent(this, MainActivity::class.java)
            intent.flags=Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }
    }
}