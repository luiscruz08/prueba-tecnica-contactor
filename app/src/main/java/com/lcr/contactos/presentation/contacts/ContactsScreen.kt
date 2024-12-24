package com.lcr.contactos.presentation.contacts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lcr.contactos.domain.model.Contact


@Composable
fun ContactsScreen(){
   val contact =   Contact(
            name = "John",
            lastName = "Doe",
            email = "example@email.com",
            phoneNumber = "1234567890",
            imageUrl = "https://example.com/image.jpg"
        )
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {}
            )
            {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add")
            }
        }
    ) {
        innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(100){
                ContactScreen(contact)
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun ContactsScreenPreview(){
    ContactsScreen()
}