package com.sanketguru.expensetracker

import android.os.Bundle
import android.os.SystemClock
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.res.painterResource
import com.sanketguru.expensetracker.ui.theme.MoneytrackerTheme
import timber.log.Timber
import androidx.compose.runtime.collectAsState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.time.Instant.now
import java.util.*


class MainActivity : ComponentActivity() {

    lateinit var flow: Flow<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

            flow= flow {
                emit("btn "+SystemClock.currentThreadTimeMillis()) }

        setContent {
            MoneytrackerTheme {
                HomeContent()
            }
        }
    }

    @Composable
    fun HomeContent() {
        var _slist: List<String> by remember {
            mutableStateOf(emptyList())
        }

        val value: String by flow.collectAsState("initial")
        Scaffold(
            topBar = {
                TopAppBar(title = { Text(getString(R.string.app_name)) })
            },
            floatingActionButton = { GetFab() },
            content = {
                Text("Value is $value")
                MessageList(_slist)

            }
        )
    }

    @Composable
    fun MessageList(messages: List<String>) {
        LazyColumn {
            items(messages) { index ->
                Greeting(index)
            }
        }
    }

    @Composable
    fun Greeting(name: String) {
        var cnt: Int by remember {
            mutableStateOf(0)
        }

        Button(onClick = {
            cnt++

        }) {
            Text(text = "Hello $name! clicked $cnt")

        }

    }
private fun addExpense(){
    Timber.i("Btn Click")

}
    @Composable
    fun GetFab() {
        FloatingActionButton(
            onClick = { /*TODO*/
                addExpense()
                      },
            backgroundColor = MaterialTheme.colors.background,
            content = {
                Icon(
                    painter = painterResource(id = android.R.drawable.ic_input_add),
                    contentDescription = getString(R.string.msg_add_expense),
                    tint = MaterialTheme.colors.primary
                )
            }
        )
    }
}
interface MessagesListener {
    fun onNewMessageReceived(message: String)
}


