package com.roberthmdz.jetpackcomposeintroduction

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

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

    val constraints = ConstraintSet {

        // Create references for compose elements
        val greenBox = createRefFor("greenBox")
        val redBox = createRefFor("redBox")
        val blueBox = createRefFor("blueBox")

        val guideLine = createGuidelineFromStart(0.5f)

        // Define constraints for references
        constrain(greenBox) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }
        /*constrain(redBox) {
            top.linkTo(greenBox.top, margin = 50.dp)
            start.linkTo(greenBox.start, margin = 50.dp)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }*/
        constrain(redBox) {
           top.linkTo(greenBox.bottom)
           start.linkTo(guideLine)
           width = Dimension.value(100.dp)
           height = Dimension.value(100.dp)
       }
        constrain(blueBox) {
            top.linkTo(redBox.bottom)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }

        // Create a chain with boxes
        createVerticalChain(blueBox, redBox, greenBox)
    }

    ConstraintLayout(constraints, modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier.background(Color.Green).layoutId("greenBox")
        )
        Box(
            modifier = Modifier.background(Color.Red).layoutId("redBox")
        )
        Box(
            modifier = Modifier.background(Color.Blue).layoutId("blueBox")
        )
    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    SimpleComposable()
}