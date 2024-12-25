package com.lcr.contactos.presentation.contacts

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.lcr.contactos.domain.model.OrderType
import com.lcr.contactos.presentation.addcontact.CustomTextField


@Composable
fun ContactsScreen(viewModel: ContactsViewModel = hiltViewModel(),selectContact: (Int) -> Unit,addContact: () -> Unit){
    val state = viewModel.state.collectAsState()
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
        Column(
            modifier = Modifier.padding(innerPadding),
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                IconButton(
                    onClick = {
                        if (state.value.orderType == OrderType.Ascending){
                            viewModel.onEvent(ContactsEvent.UpdateOrderType(OrderType.Descending))
                        }else {
                            viewModel.onEvent(ContactsEvent.UpdateOrderType(OrderType.Ascending))
                        }
                    }
                ){
                    Icon(
                        imageVector = if (state.value.orderType == OrderType.Ascending)
                            Icons.Filled.KeyboardArrowUp else Icons.Filled.ArrowDropDown,
                        contentDescription = "Ordenamiento"
                    )
                }
                CustomTextField(
                    modifier = Modifier.padding(8.dp)
                        .weight(9f),
                    text = state.value.searchQuery,
                    hint = "Buscar",
                    onValueChange = {
                        viewModel.onEvent(ContactsEvent.UpdateSearchQuery(it))
                    }
                )
            }

            LazyVerticalGrid(

                columns = GridCells.Adaptive(200.dp),
                modifier = Modifier.fillMaxSize() ){
                items(state.value.contacts){contact->
                    ContactItem(contact,modifier = Modifier
                        .clickable {
                            selectContact(contact.id!!)
                        }
                    )
                }
            }
        }

    }
}



@Preview(showBackground = true)
@Composable
fun ContactsScreenPreview(){
    ContactsScreen(selectContact = {

    }){

    }
}