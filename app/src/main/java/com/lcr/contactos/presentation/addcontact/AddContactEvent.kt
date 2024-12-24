package com.lcr.contactos.presentation.addcontact

sealed class AddContactEvent {
    data class EnteredName(val value: String): AddContactEvent()
    data class EnteredLastName(val value: String): AddContactEvent()
    data class EnteredEmail(val value: String): AddContactEvent()
    data class EnteredPhone(val value: String): AddContactEvent()
    object AddContact: AddContactEvent()
}