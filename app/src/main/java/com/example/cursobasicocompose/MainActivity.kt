@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.cursobasicocompose

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewContainer()
        }
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview
@Composable
fun ViewContainer() {
    Scaffold(
        topBar = { Toolbar() },
        content = { Content() },
        floatingActionButton = { FAB() },
        floatingActionButtonPosition = FabPosition.End
    )
}

@Composable
fun FAB() {
    val context = LocalContext.current
    FloatingActionButton(onClick = {
        Toast.makeText(context, "Desarrollo", Toast.LENGTH_LONG).show()
    }) {
        Text(text = "X")
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar() {
    TopAppBar(
        title = { Text(text = "Iespinosa", color = Color.Red) },
        modifier = Modifier.background(
            Color(
                0xFFBB86FC
            )
        )
    )
}

@Preview
@Composable
fun Content() {
    // Crear estado variable, y que lo recuerde para que cada vez que
    // se dibuja la vista se reiniciaria
    var counter by rememberSaveable { mutableStateOf(0) }

    // Modificadores se pueden concatenar
    // Siguen el orden, lo primero que se aplica es lo primero que se asigna
    LazyColumn(
        // Lazy column permite hacer scroll
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
            .padding(16.dp)
    ) {
        // En los lazy column solo se puede utilizar items
        // por eso se debe meter los componentes dentro de ITEMS
        item {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(Color.White),
                painter = painterResource(id = R.drawable.health),
                contentDescription = "Casa logo"

            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(top = 8.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_fav),
                    contentDescription = "Favorite icon",
                    modifier = Modifier.clickable {
                        counter++
                    }
                )
                Text(
                    text = counter.toString(),
                    color = Color.Red,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }

            Text(
                text = "Ivan",
                fontSize = 32.sp,
                color = Color.Blue,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White),
                textAlign = TextAlign.Center
            )
            Text(
                text = "Suscribete",
                color = Color.Red,
                fontSize = 16.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
            )
            Text(
                text = "Año 2023",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
            )
            Row(
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                Text(text = "Stack: ")
                Text(text = "Java")
                Text(text = "Kotlin")
            }
        }
    }
}