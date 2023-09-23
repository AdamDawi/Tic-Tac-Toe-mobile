package com.example.tic_tac_toe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.core.view.get

class MainActivity : AppCompatActivity()
{
    var llMain : LinearLayout? = null
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        llMain = findViewById(R.id.llMain)

        llMain
    }
}