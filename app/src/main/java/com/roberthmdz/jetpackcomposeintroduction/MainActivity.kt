package com.roberthmdz.jetpackcomposeintroduction

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

    var textFieldValue by remember{ mutableStateOf("") }
    var textValue by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(bottom = 16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            painter = painterResource(id = R.drawable.mountain),
            contentDescription = "Mountain image",
            contentScale = ContentScale.FillWidth
        )
        
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = textValue,
            style = TextStyle(
                color = Color.Green,
                fontSize = 28.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Black,
                textAlign = TextAlign.Center
            )
        )

        TextField(
            value = textFieldValue,
            onValueChange = { text -> textFieldValue = text} ,
            label = {
                Text(text = "Type something")
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_android),
                    contentDescription = "Leading icon",
                )
            }

        )

        Button(
            onClick = {
                textValue = textFieldValue
            }
        ) {
            Text(text = "Apply")
        }

    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    SimpleComposable()
}