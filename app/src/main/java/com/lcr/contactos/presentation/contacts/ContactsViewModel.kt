package com.lcr.contactos.presentation.contacts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lcr.contactos.domain.model.Contact
import com.lcr.contactos.domain.model.OrderType
import com.lcr.contactos.domain.model.filterByAllData
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
) : ViewModel() {

    private val _state = MutableStateFlow(ContactsState())
    val state = _state.onStart {
        loadContacts()
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        _state.value
    )

    fun onEvent(contactsEvent: ContactsEvent) {
        when(contactsEvent){
            is ContactsEvent.UpdateOrderType -> {
                _state.value = state.value.copy(orderType = contactsEvent.orderType)
                loadContacts()
            }

            is ContactsEvent.UpdateSearchQuery -> {
                _state.value = state.value.copy(searchQuery = contactsEvent.query)
                loadContacts()
            }
        }
    }

    private fun loadContacts() {
        viewModelScope.launch {
            getContactsUseCase(state.value.searchQuery, state.value.orderType).collect {
                _state.value = state.value.copy(contacts = it)
            }
        }
    }
}
