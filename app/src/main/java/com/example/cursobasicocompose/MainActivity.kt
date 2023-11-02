package com.example.cursobasicocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            app()

        }
    }
}

@Preview
@Composable
fun app() {
    // Modificadores se pueden concatenar
    // Siguen el orden, lo primero que se aplica es lo primero que se asigna
    LazyColumn(
        // Lazy column permite hacer scroll
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // En los lazy column solo se puede utilizar items
        // por eso se debe meter los componentes dentro de ITEMS
        item {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                painter = painterResource(id = R.drawable.house),
                contentDescription = "Casa logo"
            )
            Text(
                text = "Ivan",
                fontSize = 32.sp,
                color = Color.Blue,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Text(
                text = "Suscribete",
                color = Color.Red,
                fontSize = 16.sp
            )
            Text(text = "Año 2023")
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth().padding(16.dp)
            ) {
                Text(text = "Stack: ")
                Text(text = "Java")
                Text(text = "Kotlin")
                Text(text = "TypeScript")
            }
            LazyRow(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth().padding(16.dp)
            ) {
                item {
                    Text(text = "Stack: ")
                    Text(text = "Java")
                    Text(text = "Kotlin")
                    Text(text = "TypeScript")
                    Text(text = "Stack: ")
                    Text(text = "Java")
                    Text(text = "Kotlin")
                    Text(text = "TypeScript")
                    Text(text = "Stack: ")
                    Text(text = "Java")
                    Text(text = "Kotlin")
                    Text(text = "TypeScript")
                    Text(text = "Stack: ")
                    Text(text = "Java")
                    Text(text = "Kotlin")
                    Text(text = "TypeScript")
                }

            }
        }
    }
}
