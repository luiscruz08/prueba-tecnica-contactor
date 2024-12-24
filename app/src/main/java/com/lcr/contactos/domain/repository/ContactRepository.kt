package com.lcr.contactos.domain.repository

import com.lcr.contactos.domain.model.Contact

interface ContactRepository {
    suspend fun addContact(contact: Contact)
}