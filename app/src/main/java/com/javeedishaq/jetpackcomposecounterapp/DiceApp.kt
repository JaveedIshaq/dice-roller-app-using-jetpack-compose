package com.javeedishaq.jetpackcomposecounterapp

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp

import com.google.android.material.bottomappbar.BottomAppBar

@Composable
fun DiceApp() {
    //val rollResult = remember { mutableSetOf(0)}
    var result = remember {
        mutableStateOf(0)
    }

    val imageName: String = "dice_image"

    fun rollDice() {
        // rollResult.value++
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRol = dice.roll()

        print(diceRol);

        result.value = diceRol
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Compose Roll the Dice App") })
        },
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize()
        ) {

            Text("Press Roll the Dice Button", style = MaterialTheme.typography.h6)
            Text("${result.value}" , style = MaterialTheme.typography.h3)
            Spacer(modifier = Modifier.height(16.dp))
            getDiceImage(result.value)
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { rollDice() }) {
                Text("Roll The Dice")
            }
        }
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}

@Composable
 fun getDiceImage(diceValue: Int) {
    when (diceValue) {
        1 ->  Image(
            painter = painterResource(R.drawable.dice_1),
            contentDescription = "Contact profile picture",
            modifier = Modifier.height(200.dp)
        )
        2 ->  Image(
            painter = painterResource(R.drawable.dice_2),
            contentDescription = "Contact profile picture",
            modifier = Modifier.height(200.dp)
        )
        3 ->  Image(
            painter = painterResource(R.drawable.dice_3),
            contentDescription = "Contact profile picture",
            modifier = Modifier.height(200.dp)
        )
        4 ->  Image(
            painter = painterResource(R.drawable.dice_4),
            contentDescription = "Contact profile picture",
            modifier = Modifier.height(200.dp)
        )
        5 ->  Image(
            painter = painterResource(R.drawable.dice_5),
            contentDescription = "Contact profile picture",
            modifier = Modifier.height(200.dp)
        )
        6 -> Image(
        painter = painterResource(R.drawable.dice_6),
        contentDescription = "Contact profile picture",
        modifier = Modifier.height(200.dp)
       )
        else -> Spacer(modifier = Modifier.height(10.dp))
    }
}