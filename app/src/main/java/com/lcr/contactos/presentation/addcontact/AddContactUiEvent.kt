package com.lcr.contactos.presentation.addcontact

sealed class AddContactUiEvent {
    data class ShowSnackBar(val message: String) : AddContactUiEvent()
    object AddContact : AddContactUiEvent()
}