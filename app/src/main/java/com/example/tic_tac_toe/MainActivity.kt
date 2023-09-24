package com.example.tic_tac_toe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Im
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity()
{
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
        var textAnim = AnimationUtils.loadAnimation(this, R.anim.text_anim)

        tvClick.startAnimation(textAnim)
        tvTurn.startAnimation(textAnim)
        ivTurn.startAnimation(textAnim)

        iv1 = findViewById<ImageView>(R.id.iv1)
        iv2 = findViewById<ImageView>(R.id.iv2)
        iv3 = findViewById<ImageView>(R.id.iv3)
        iv4 = findViewById<ImageView>(R.id.iv4)
        iv5 = findViewById<ImageView>(R.id.iv5)
        iv6 = findViewById<ImageView>(R.id.iv6)
        iv7 = findViewById<ImageView>(R.id.iv7)
        iv8 = findViewById<ImageView>(R.id.iv8)
        iv9 = findViewById<ImageView>(R.id.iv9)


    }

    fun onClickImageView(view: View)
    {
        val iv = view as ImageView

        if(iv.drawable == null)
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
        }
        ifWin()
    }

    private fun ifWin()
    {
        if(iv1?.tag == iv2?.tag && iv3?.tag == iv1?.tag && iv1?.tag !=null)
        {
            val pulse = AnimationUtils.loadAnimation(this, R.anim.pulse)

            Toast.makeText(this, "Winner ${iv1?.tag}", Toast.LENGTH_LONG).show()
            (iv1?.parent as FrameLayout).setBackgroundColor(Color.parseColor("#BAD507"))
            (iv2?.parent as FrameLayout).setBackgroundColor(Color.parseColor("#BAD507"))
            (iv3?.parent as FrameLayout).setBackgroundColor(Color.parseColor("#BAD507"))
            (iv1?.parent as FrameLayout).startAnimation(pulse)
            (iv2?.parent as FrameLayout).startAnimation(pulse)
            (iv3?.parent as FrameLayout).startAnimation(pulse)
        }
        else if(iv4?.tag == iv5?.tag && iv4?.tag == iv6?.tag && iv4?.tag !=null)
        {
            val pulse = AnimationUtils.loadAnimation(this, R.anim.pulse)

            Toast.makeText(this, "Winner ${iv4?.tag}", Toast.LENGTH_LONG).show()
            (iv4?.parent as FrameLayout).setBackgroundColor(Color.parseColor("#BAD507"))
            (iv5?.parent as FrameLayout).setBackgroundColor(Color.parseColor("#BAD507"))
            (iv6?.parent as FrameLayout).setBackgroundColor(Color.parseColor("#BAD507"))
            (iv4?.parent as FrameLayout).startAnimation(pulse)
            (iv5?.parent as FrameLayout).startAnimation(pulse)
            (iv6?.parent as FrameLayout).startAnimation(pulse)
        }
        else if(iv7?.tag == iv8?.tag && iv7?.tag == iv9?.tag && iv7?.tag !=null)
        {
            val pulse = AnimationUtils.loadAnimation(this, R.anim.pulse)

            Toast.makeText(this, "Winner ${iv7?.tag}", Toast.LENGTH_LONG).show()
            (iv7?.parent as FrameLayout).setBackgroundColor(Color.parseColor("#BAD507"))
            (iv8?.parent as FrameLayout).setBackgroundColor(Color.parseColor("#BAD507"))
            (iv9?.parent as FrameLayout).setBackgroundColor(Color.parseColor("#BAD507"))
            (iv7?.parent as FrameLayout).startAnimation(pulse)
            (iv8?.parent as FrameLayout).startAnimation(pulse)
            (iv9?.parent as FrameLayout).startAnimation(pulse)
        }
        else if(iv1?.tag == iv5?.tag && iv1?.tag == iv9?.tag && iv1?.tag !=null)
        {
            val pulse = AnimationUtils.loadAnimation(this, R.anim.pulse)

            Toast.makeText(this, "Winner ${iv1?.tag}", Toast.LENGTH_LONG).show()
            (iv1?.parent as FrameLayout).setBackgroundColor(Color.parseColor("#BAD507"))
            (iv5?.parent as FrameLayout).setBackgroundColor(Color.parseColor("#BAD507"))
            (iv9?.parent as FrameLayout).setBackgroundColor(Color.parseColor("#BAD507"))
            (iv1?.parent as FrameLayout).startAnimation(pulse)
            (iv5?.parent as FrameLayout).startAnimation(pulse)
            (iv9?.parent as FrameLayout).startAnimation(pulse)
        }
        else if(iv3?.tag == iv5?.tag && iv3?.tag == iv7?.tag && iv3?.tag !=null)
        {
            val pulse = AnimationUtils.loadAnimation(this, R.anim.pulse)

            Toast.makeText(this, "Winner ${iv3?.tag}", Toast.LENGTH_LONG).show()
            (iv3?.parent as FrameLayout).setBackgroundColor(Color.parseColor("#BAD507"))
            (iv5?.parent as FrameLayout).setBackgroundColor(Color.parseColor("#BAD507"))
            (iv7?.parent as FrameLayout).setBackgroundColor(Color.parseColor("#BAD507"))
            (iv3?.parent as FrameLayout).startAnimation(pulse)
            (iv5?.parent as FrameLayout).startAnimation(pulse)
            (iv7?.parent as FrameLayout).startAnimation(pulse)
        }
    }
}