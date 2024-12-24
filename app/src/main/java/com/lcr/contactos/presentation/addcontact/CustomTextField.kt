package com.lcr.contactos.presentation.addcontact

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CustomTextField(
    text: String,
    hint: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit
){
    TextField(
        modifier = modifier.padding(horizontal = 16.dp),
        value = text,
        onValueChange = { newText ->
            onValueChange(newText)
        },
        label = { Text(text = hint) }
    )
}