package com.example.firstcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstcompose.ui.theme.FirstComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstComposeTheme {
                Counter()
            }
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun Counter() {
    val count = remember {
        mutableStateOf(0)
    }

    Scaffold(
        floatingActionButton = {
            Column {
                FloatingActionButton(onClick = {
                    count.value = 0
                }, backgroundColor = Color.Blue) {
                    Icon(
                        Icons.Rounded.Clear,
                        contentDescription = "min",
                        tint = Color.White
                    )
                }
                Box(modifier = Modifier.height(10.dp))
                FloatingActionButton(onClick = {
                    count.value++
                }, backgroundColor = Color.Blue) {
                    Icon(
                        Icons.Rounded.Add,
                        contentDescription = "add",
                        tint = Color.White
                    )
                }
            }
        },
        content = {
            Text(
                text = count.value.toString(),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentHeight(),
                fontSize = 36.sp
            )
        }
    )
}