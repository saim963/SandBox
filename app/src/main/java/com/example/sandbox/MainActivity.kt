package com.example.sandbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sandbox.ui.theme.SandBoxTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SandBoxTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CaptainGame()
                }
            }
        }
    }
}

@Composable
fun CaptainGame() {
//    val treasureFound = remember { mutableIntStateOf(0) }
    var treasureFound by remember { mutableIntStateOf(0) }
    val direction = remember { mutableStateOf("North") }
    val stormOrTreasure = remember { mutableStateOf("") }
    Column(
        Modifier.fillMaxSize(),
        Arrangement.Center,
        Alignment.CenterHorizontally
    ) {
        Text(text = "Treasure found: $treasureFound")
        Text(text = "Current direction: ${direction.value}")
        Text(text = stormOrTreasure.value)
        Spacer(modifier = Modifier.height(16.dp))
        Column {

            Button(onClick = {
                direction.value = "North"
                if (Random.nextBoolean()) {
                    treasureFound += 1
                    stormOrTreasure.value = "Found the treasure!!"
                } else
                    stormOrTreasure.value = "Storm Ahead!!"

            },
                modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Icon(Icons.Default.KeyboardArrowUp, "Drop Down")
            }
            Row {
                Button(onClick = {
                    direction.value = "West"
                    if (Random.nextBoolean()) {
                        treasureFound += 1
                        stormOrTreasure.value = "Found the treasure!!"
                    } else
                        stormOrTreasure.value = "Storm Ahead!!"
                }) {
                    Icon(Icons.Default.KeyboardArrowLeft, "Drop Down")
                }
                Spacer(modifier = Modifier.width(64.dp))
                Button(onClick = {
                    direction.value = "East"
                    if (Random.nextBoolean()) {
                        treasureFound += 1
                        stormOrTreasure.value = "Found the treasure!!"
                    } else
                        stormOrTreasure.value = "Storm Ahead!!"
                }) {
                    Icon(Icons.Default.KeyboardArrowRight, "Drop Down")
                }
            }
            Button(onClick = {
                direction.value = "South"
                if (Random.nextBoolean()) {
                    treasureFound += 1
                    stormOrTreasure.value = "Found the treasure!!"
                } else
                    stormOrTreasure.value = "Storm Ahead!!"
            },
                modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Icon(Icons.Default.KeyboardArrowDown, "Drop Down")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Ship() {
    SandBoxTheme {
        CaptainGame()
    }
}