package com.lcr.contactos.domain.model

sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}