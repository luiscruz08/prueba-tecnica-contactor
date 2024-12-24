package com.lcr.contactos.presentation.addcontact

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.lcr.contactos.domain.model.Contact
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

@HiltViewModel
class AddContactViewModel @Inject constructor(): ViewModel() {

    private val _contact = mutableStateOf(Contact(
        name = "",
        lastName = "",
        phoneNumber = "",
        email = "",
        imageUrl = ""
    ))
    val contact: State<Contact> = _contact

    private val _eventFlow = MutableSharedFlow<AddContactUiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun onEvent(event: AddContactEvent) {
        when (event) {
            AddContactEvent.AddContact ->{
                Log.e("AddContactViewModel", "onEvent: ${_contact.value}")
            }
            is AddContactEvent.EnteredEmail -> _contact.value =
                _contact.value.copy(email = event.value)

            is AddContactEvent.EnteredLastName -> _contact.value =
                _contact.value.copy(lastName = event.value)

            is AddContactEvent.EnteredName -> _contact.value =
                _contact.value.copy(name = event.value)

            is AddContactEvent.EnteredPhone -> _contact.value =
                _contact.value.copy(phoneNumber = event.value)
        }
    }

}