package com.example.roomdbtutorial

import android.graphics.drawable.DrawableContainer
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.ViewModelFactoryDsl
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.roomdbtutorial.data.WordDatabase
import com.example.roomdbtutorial.data.WordRepository
import com.example.roomdbtutorial.ui.theme.RoomDbTutorialTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            RoomDbTutorialTheme {
                Container {
                    Greeting(mainViewModel)
                }
                mainViewModel.getAllWords().observe(this) {
                    println(it)
                }
            }
        }
    }
}


@Composable
fun Container(content: @Composable () -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        content()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(viewModel: MainViewModel) {
    var text by remember { mutableStateOf("Word") }
    Column {
        TextField(
            value = text,
            onValueChange = {
                text = it
            },
            label = {
                Text(text = "Label")
            }
        )
        Button(onClick = { viewModel.addWord(text) }) {
            Text(text = "Insert")
        }
    }
}
