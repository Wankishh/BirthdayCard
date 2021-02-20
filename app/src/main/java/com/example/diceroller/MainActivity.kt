package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    private val dice: Dice = Dice();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.rollButton);

        rollButton.setOnClickListener {
            rollDice()
        }

        rollDice()
    }

    private fun setImageResource(rollDiceNumber: Int) {
        val diceImage: ImageView = findViewById(R.id.diceView);
        val drawableResource = when(rollDiceNumber) {
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.dice_1
        }

        diceImage.setImageResource(drawableResource)
    }

    private fun rollDice() {
        val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
        toast.show()
        setImageResource(dice.roll())
    }
}
