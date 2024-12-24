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
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.flow.collectLatest

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddContactScreen(viewModel: AddContactViewModel = hiltViewModel(), onNavigateUp: () -> Unit) {

    val contactState = viewModel.contact.value
    val snackBarHostState = remember { SnackbarHostState() }
    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event->
            when(event){
                AddContactUiEvent.AddContact -> {
                    onNavigateUp()
                }
                is  AddContactUiEvent.ShowSnackBar -> {
                    snackBarHostState.showSnackbar(message = event.message)
                }
            }
        }
    }

    Scaffold(
        modifier = Modifier.imePadding(),
        snackbarHost = { SnackbarHost(snackBarHostState) },
        topBar = {
            TopAppBar(
                title = { Text(text = "Agregar contacto") },
                navigationIcon = {
                    IconButton(onClick = {onNavigateUp()}) {
                        Icon(imageVector = Icons.AutoMirrored.Default.ArrowBack, contentDescription = "Regresar")
                    }
                }

            )
        }
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
                text = contactState.name,
                hint = "Nombre",
                modifier = Modifier
                    .fillMaxWidth(),
                onValueChange = {
                    viewModel.onEvent(AddContactEvent.EnteredName(it))
                }
            )

            CustomTextField(
                text = contactState.lastName,
                hint = "Apellido",
                modifier = Modifier
                    .fillMaxWidth(),
                onValueChange = {
                    viewModel.onEvent(AddContactEvent.EnteredLastName(it))
                }
            )

            CustomTextField(
                text = contactState.email,
                hint = "Correo",
                modifier = Modifier
                    .fillMaxWidth(),
                onValueChange = {
                    viewModel.onEvent(AddContactEvent.EnteredEmail(it))
                }
            )

            CustomTextField(
                text = contactState.phoneNumber,
                hint = "Teléfono",
                modifier = Modifier
                    .fillMaxWidth(),
                onValueChange = {
                    viewModel.onEvent(AddContactEvent.EnteredPhone(it))
                }
            )
            Spacer(modifier = Modifier.weight(1f))
            Button(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                onClick = { viewModel.onEvent(AddContactEvent.AddContact) }) {
                Text(text = "Guardar")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AddContactScreenPreview() {
    AddContactScreen{
    }
}