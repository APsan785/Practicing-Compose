package com.apsan.practicingcompose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.apsan.practicingcompose.ui.theme.PracticingComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticingComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Yoo...")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
        color = MaterialTheme.colors.primary,
        modifier = Modifier.background(MaterialTheme.colors.secondaryVariant)
    )
}

@Preview(showBackground = true, name = "Preview1")
@Composable
fun DefaultPreview() {
    PracticingComposeTheme(darkTheme = true) {
        Greeting("Yoo...")
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, showSystemUi = true)
@Composable
fun DefaultPreview1() {
    PracticingComposeTheme {
        Greeting("Yoo...")
    }
}