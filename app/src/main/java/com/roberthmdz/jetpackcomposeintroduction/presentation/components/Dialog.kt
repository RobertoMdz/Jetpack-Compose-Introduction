package com.roberthmdz.jetpackcomposeintroduction.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Dialog(
    showDialog: Boolean,
    dismissDialog: () -> Unit
) {
    if(showDialog) {
        AlertDialog(
            onDismissRequest = {},
            title = {
                Text(
                    text = "Dialog title",
                    style = TextStyle(fontSize = 22.sp, fontWeight = FontWeight.Bold)
                )
            },
            text = {
                Column {
                    Text(text = "Fila 1")
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "Fila 2")
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "Fila 3")
                    Spacer(modifier = Modifier.height(4.dp))
                }
            },
            confirmButton = {
                Button(onClick = { dismissDialog() }) {
                    Text(text = "Aceptar")
                }
            },
            dismissButton = {
                Button(onClick = {dismissDialog() }) {
                    Text(text = "Cancelar")
                }
            }
        )
            

    }
    
}