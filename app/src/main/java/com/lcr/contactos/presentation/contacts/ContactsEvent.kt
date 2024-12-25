package com.lcr.contactos.presentation.contacts

import com.lcr.contactos.domain.model.OrderType

sealed class ContactsEvent {
    data class UpdateOrderType(val orderType: OrderType) : ContactsEvent()
    data class UpdateSearchQuery(val query: String) : ContactsEvent()
}