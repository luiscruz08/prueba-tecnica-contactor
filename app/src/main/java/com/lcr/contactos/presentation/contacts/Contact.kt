package com.lcr.contactos.presentation.contacts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lcr.contactos.domain.model.Contact

@Composable

fun ContactItem(contact: Contact, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                Icons.Rounded.AccountCircle,
                contentDescription = "Icono de persona",
                modifier = Modifier.size(100.dp)
            )
            Text(text = "${contact.name} ${contact.lastName}",
                style = MaterialTheme.typography.titleMedium
            )
            Text(text = contact.email)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ContactScreenPreview() {
    ContactItem(
        contact = Contact(
            name = "John",
            lastName = "Doe",
            email = "example@email.com",
            phoneNumber = "1234567890",
            imageUrl = "https://example.com/image.jpg"
        )
    )
}