package com.lcr.contactos.presentation.addcontact

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AddContactScreen() {

    Scaffold(
        modifier = Modifier.imePadding()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
               .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Icon( Icons.Rounded.AccountCircle,
                contentDescription = "Icono de persona",
                modifier = Modifier
                    .size(200.dp)
            )

            CustomTextField(
                text = "",
                hint = "Nombre",
                modifier = Modifier
                    .fillMaxWidth(),
                onValueChange = {

                }
            )

            CustomTextField(
                text = "",
                hint = "Apellido",
                modifier = Modifier
                    .fillMaxWidth(),
                onValueChange = {

                }
            )

            CustomTextField(
                text = "",
                hint = "Correo",
                modifier = Modifier
                    .fillMaxWidth(),
                onValueChange = {

                }
            )

            CustomTextField(
                text = "",
                hint = "Teléfono",
                modifier = Modifier
                    .fillMaxWidth(),
                onValueChange = {

                }
            )
            Spacer(modifier = Modifier.weight(1f))
            Button(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                onClick = { /*TODO*/ }) {
                Text(text = "Guardar")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AddContactScreenPreview() {
    AddContactScreen()
}