package com.example.android.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.example.android.diceroller.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var diceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /* Set up the binding class for the activity_main layout
         * https://developer.android.com/topic/libraries/view-binding */
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val rollButton = binding.rollButton
        rollButton.setText("Let's Roll!")

        rollButton.setOnClickListener {
            // Toast.makeText(this, "Button pressed!", Toast.LENGTH_SHORT).show()
            rollDice()
        }

        diceImage = binding.diceImage
    }

    private fun rollDice() {
        val srcImage = when (Random.nextInt(6) + 1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(srcImage)
    }
}
