package com.lcr.contactos.presentation.addcontact

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lcr.contactos.domain.model.Contact
import com.lcr.contactos.domain.model.InvalidContactException
import com.lcr.contactos.domain.usecase.AddContactUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddContactViewModel @Inject constructor(
    private val addContactUseCase: AddContactUseCase
): ViewModel() {

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
                viewModelScope.launch {
                    try {
                        addContactUseCase.invoke(
                            contact = Contact(
                                name = contact.value.name,
                                lastName = contact.value.lastName,
                                phoneNumber = contact.value.phoneNumber,
                                email = contact.value.email,
                                imageUrl = contact.value.imageUrl
                            ))
                        _eventFlow.emit(AddContactUiEvent.AddContact)
                    }catch (e: InvalidContactException){
                        _eventFlow.emit(
                            AddContactUiEvent.ShowSnackBar(
                                message = e.message ?: "Error desconocido"
                            )
                        )
                    }
                }


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