package com.javeedishaq.jetpackcomposecounterapp

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.google.android.material.bottomappbar.BottomAppBar

@Composable
fun CounterApp() {
    //val rollResult = remember { mutableSetOf(0)}
    var result = remember {
        mutableStateOf("")
    }


    fun rollDice() {
        // rollResult.value++
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRol = dice.roll()

        print(diceRol);

        result.value = diceRol.toString()
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
            Text("Press Roll the Dice Button", style = MaterialTheme.typography.h4)
            Text("${result.value}" , style = MaterialTheme.typography.h1)
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