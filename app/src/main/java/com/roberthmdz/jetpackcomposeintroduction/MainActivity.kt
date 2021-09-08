package com.roberthmdz.jetpackcomposeintroduction

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.roberthmdz.jetpackcomposeintroduction.ui.theme.JetpackComposeIntroductionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           SimpleComposable()
        }
    }
}

@Composable
fun SimpleComposable() {
    // This implementation lost the state when mobile screen change to landscape
       //var num by remember { mutableStateOf(0) }

    // This implementation save the counter state and not lose it
    var num by rememberSaveable { mutableStateOf(0) }

    Column {
        
        Text(text = "Conteo: $num")
        Divider(thickness = 20.dp, color = Color.Transparent)
        Counter(
            textButton = "Incrementar",
            onClick = {
            num++
        })
        Counter(
            textButton = "Decrementar",
            onClick = {
            num--
        })

    }
}

@Composable
fun Counter(textButton: String, onClick: () -> Unit) {
    Button(
        onClick = { onClick() }
    ) {
        Text(text = textButton)
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    SimpleComposable()
}