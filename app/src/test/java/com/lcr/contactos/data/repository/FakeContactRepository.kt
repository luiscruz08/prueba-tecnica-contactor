package com.lcr.contactos.data.repository

import com.lcr.contactos.domain.model.Contact
import com.lcr.contactos.domain.repository.ContactRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeContactRepository: ContactRepository {

    var contacts = mutableListOf<Contact>()

    override suspend fun addContact(contact: Contact) {
        contacts.add(contact)
    }

    override fun getContacts(): Flow<List<Contact>> {
        return flowOf(contacts)
    }
}