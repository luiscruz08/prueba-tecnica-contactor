package com.lcr.contactos.domain.repository

import com.lcr.contactos.domain.model.Contact
import kotlinx.coroutines.flow.Flow

interface ContactRepository {
    suspend fun addContact(contact: Contact)
    fun getContacts(): Flow<List<Contact>>
}