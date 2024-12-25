package com.lcr.contactos.presentation.contacts

import com.lcr.contactos.domain.model.Contact
import com.lcr.contactos.domain.model.OrderType


data class ContactsState(
    val contacts: List<Contact> = emptyList(),
    val orderType: OrderType = OrderType.Ascending,
    val searchQuery: String = "",
)