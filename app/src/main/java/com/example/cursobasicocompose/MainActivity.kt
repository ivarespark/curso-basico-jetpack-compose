package com.example.cursobasicocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cursobasicocompose.ui.theme.CursoBasicoComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            helloApp()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun helloApp(){
    CursoBasicoComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Greeting("Android")
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

// Modificadores son las propiedades del componente
@Preview(showBackground = true)
@Composable
fun exampleModifier() {
    Text(text = "Suscribete", modifier = Modifier.padding(16.dp))
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CursoBasicoComposeTheme {
        Greeting("Ivan")
    }
}

@Preview(showBackground = true)
@Composable
fun SecondPreview() {
    CursoBasicoComposeTheme {
        Greeting("Android")
    }
}