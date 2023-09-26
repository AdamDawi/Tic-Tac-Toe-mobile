package com.example.tic_tac_toe

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity()
{
    private var endGame = false
    private var turn = "o"
    private var iv1 : ImageView? = null
    private var iv2 : ImageView? = null
    private var iv3 : ImageView? = null
    private var iv4 : ImageView? = null
    private var iv5 : ImageView? = null
    private var iv6 : ImageView? = null
    private var iv7 : ImageView? = null
    private var iv8 : ImageView? = null
    private var iv9 : ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvClick = findViewById<TextView>(R.id.tvClick)
        val tvTurn = findViewById<TextView>(R.id.tvTurn)
        val ivTurn = findViewById<ImageView>(R.id.ivTurn)
        val textAnim = AnimationUtils.loadAnimation(this, R.anim.slide_anim)

        tvClick.startAnimation(textAnim)
        tvTurn.startAnimation(textAnim)
        ivTurn.startAnimation(textAnim)

        iv1 = findViewById(R.id.iv1)
        iv2 = findViewById(R.id.iv2)
        iv3 = findViewById(R.id.iv3)
        iv4 = findViewById(R.id.iv4)
        iv5 = findViewById(R.id.iv5)
        iv6 = findViewById(R.id.iv6)
        iv7 = findViewById(R.id.iv7)
        iv8 = findViewById(R.id.iv8)
        iv9 = findViewById(R.id.iv9)
    }

    fun onClickImageView(view: View)
    {
        val iv = view as ImageView


        if(iv.drawable == null && !endGame)
        {
            val cellAnim = AnimationUtils.loadAnimation(this, R.anim.cell_anim)
            iv.startAnimation(cellAnim)
            val ivTurn = findViewById<ImageView>(R.id.ivTurn)
            if (turn == "x")
            {
                iv.setImageResource(R.drawable.x)
                ivTurn.setImageResource(R.drawable.circle)
                iv.tag = "x"
                turn = "o"
            }
            else
            {
                iv.setImageResource(R.drawable.circle)
                ivTurn.setImageResource(R.drawable.x_small)
                iv.tag = "o"
                turn = "x"
            }
            checkIfWin()
        }
        else if(endGame)
        {
            showEndDialog()
        }

    }

    private fun checkIfWin()
    {
        if(iv1?.tag == iv2?.tag && iv3?.tag == iv1?.tag && iv1?.tag !=null)
        {
            setWinningAnimation(iv1, iv2, iv3)
        }
        else if(iv4?.tag == iv5?.tag && iv4?.tag == iv6?.tag && iv4?.tag !=null)
        {
            setWinningAnimation(iv4, iv5, iv6)
        }
        else if(iv7?.tag == iv8?.tag && iv7?.tag == iv9?.tag && iv7?.tag !=null)
        {
            setWinningAnimation(iv7, iv8, iv9)
        }
        else if(iv1?.tag == iv5?.tag && iv1?.tag == iv9?.tag && iv1?.tag !=null)
        {
            setWinningAnimation(iv1, iv5, iv9)
        }
        else if(iv3?.tag == iv5?.tag && iv3?.tag == iv7?.tag && iv3?.tag !=null)
        {
            setWinningAnimation(iv3, iv5, iv7)
        }
        else if(iv3?.tag == iv6?.tag && iv3?.tag == iv9?.tag && iv3?.tag !=null)
        {
            setWinningAnimation(iv3, iv6, iv9)
        }
        else if(iv2?.tag == iv5?.tag && iv2?.tag == iv8?.tag && iv2?.tag !=null)
        {
            setWinningAnimation(iv2, iv5, iv8)
        }
        else if(iv1?.tag == iv4?.tag && iv1?.tag == iv7?.tag && iv1?.tag !=null)
        {
            setWinningAnimation(iv1, iv4, iv7)
        }
        else if(iv1?.tag !=null && iv2?.tag !=null && iv3?.tag !=null && iv4?.tag !=null && iv5?.tag !=null
            && iv6?.tag !=null && iv7?.tag !=null && iv8?.tag !=null && iv9?.tag !=null)
        {
            showEndDialog()
            endGame = true
        }
    }
    private fun setWinningAnimation(imageV1 : ImageView?, imageV2 : ImageView?, imageV3 : ImageView?)
    {
        val pulse = AnimationUtils.loadAnimation(this, R.anim.pulse)
        val colorGreen = Color.parseColor("#BAD507")

        Toast.makeText(this, "Winner ${(imageV1?.tag).toString().uppercase()}", Toast.LENGTH_LONG).show()
        (imageV1?.parent as FrameLayout).setBackgroundColor(colorGreen)
        (imageV2?.parent as FrameLayout).setBackgroundColor(colorGreen)
        (imageV3?.parent as FrameLayout).setBackgroundColor(colorGreen)
        imageV1.startAnimation(pulse)
        imageV2.startAnimation(pulse)
        imageV3.startAnimation(pulse)
        endGame = true
    }

    private fun showEndDialog()
    {
        val dialog : Dialog = Dialog(this)
        dialog.setContentView(R.layout.end_dialog)
        dialog.setCancelable(false)

        val btnRestart : Button = dialog.findViewById(R.id.btnRestart)
        btnRestart.setOnClickListener {
            restartGame()
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun restartGame()
    {
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()
//        endGame=false
//        turn="o"
//        setDefaultView()
    }
}