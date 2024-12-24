package com.lcr.contactos.presentation.contacts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.lcr.contactos.domain.model.Contact


@Composable
fun ContactsScreen(viewModel: ContactsViewModel = hiltViewModel(),addContact: () -> Unit){
    val contacts = viewModel.contacts.collectAsState()
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {addContact()}
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
            items(contacts.value){contact->
                ContactScreen(contact)
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun ContactsScreenPreview(){
    ContactsScreen(){

    }
}