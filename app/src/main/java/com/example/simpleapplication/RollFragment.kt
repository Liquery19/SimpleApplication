package com.example.simpleapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import kotlin.random.Random

private const val LAST_ROLLED_IMAGE="image"

class RollFragment : Fragment() {

    lateinit var diceImageViewOne: ImageView
    lateinit var diceImageViewTwo: ImageView
    lateinit var rollButton: Button
    private val diceImageList:List<Int> = listOf(
        R.drawable.dice_one,
        R.drawable.dice_two,
        R.drawable.dice_three,
        R.drawable.dice_four,
        R.drawable.dice_five,
        R.drawable.dice_six,
    )

    var lastRolledImageResOne=0
    var lastRolledImageResTwo=0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_roll, container, false)

        diceImageViewOne = view.findViewById(R.id.first_dice_image_view)
        diceImageViewTwo = view.findViewById(R.id.second_dice_image_view)
        rollButton = view.findViewById(R.id.roll_button)


        if(savedInstanceState!=null) {
            diceImageViewOne.setImageResource(savedInstanceState.getInt(LAST_ROLLED_IMAGE))
            diceImageViewTwo.setImageResource(savedInstanceState.getInt(LAST_ROLLED_IMAGE))
        }

        rollButton.setOnClickListener {
            lastRolledImageResOne=diceImageList.random()
            lastRolledImageResTwo=diceImageList.random()
            diceImageViewOne.setImageResource(lastRolledImageResOne)
            diceImageViewTwo.setImageResource(lastRolledImageResTwo)


        }

        return view
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(LAST_ROLLED_IMAGE,lastRolledImageResTwo)
        outState.putInt(LAST_ROLLED_IMAGE,lastRolledImageResOne)
    }
}