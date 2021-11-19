package com.sanketguru.expensetracker

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import com.sanketguru.expensetracker.ui.theme.MoneytrackerTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoneytrackerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(

                    ) {
                        Greeting("Android")
                        Greeting("sanket")
                    }

                }
            }
        }
    }
    @Composable
    fun Greeting(name: String) {
        var cnt :Int by remember {
            mutableStateOf(0)
        }

        Button(onClick = {
            cnt++
        }) {

            Text(text = "Hello $name! clicked $cnt")
        }

    }
    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        MoneytrackerTheme {
            Greeting("Android")
        }
    }
}



