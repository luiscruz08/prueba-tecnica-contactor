package com.lcr.contactos.presentation.contacts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lcr.contactos.domain.model.Contact

@Composable

fun ContactScreen(contact: Contact){
    Card(modifier = Modifier
        .fillMaxWidth())
     {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon( Icons.Rounded.AccountCircle,
                contentDescription = "Icono de persona",
                modifier = Modifier.weight(1f)

            )
            Column(
                modifier = Modifier.weight(4f)
            ){
                Text(text = contact.name)
                Text(text = contact.lastName)
                Text(text = contact.email)
                Text(text = contact.phoneNumber)
            }
        }


    }
}

@Composable
@Preview(showBackground = true)
fun ContactScreenPreview(){
    ContactScreen(
        contact = Contact(
            name = "John",
            lastName = "Doe",
            email = "example@email.com",
            phoneNumber = "1234567890",
            imageUrl = "https://example.com/image.jpg"
        )
    )
}