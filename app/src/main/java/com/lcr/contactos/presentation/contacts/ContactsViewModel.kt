package com.lcr.contactos.presentation.contacts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lcr.contactos.domain.model.Contact
import com.lcr.contactos.domain.usecase.GetContactsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContactsViewModel @Inject constructor(
    private val getContactsUseCase: GetContactsUseCase
): ViewModel() {
    private var contactsLoaded = false
    private val _contacts = MutableStateFlow<List<Contact>>(emptyList())
    val contacts = _contacts.onStart {
            if (!contactsLoaded) {
                loadContacts()
                contactsLoaded = true
            }
    }.stateIn(viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        _contacts.value)

    private fun loadContacts() {
        viewModelScope.launch {
            getContactsUseCase().collect {
                _contacts.value = it
            }
        }
    }
}
