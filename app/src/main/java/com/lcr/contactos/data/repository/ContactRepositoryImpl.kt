package com.lcr.contactos.data.repository

import com.lcr.contactos.data.database.dao.ContactDao
import com.lcr.contactos.domain.model.Contact
import com.lcr.contactos.domain.model.toEntity
import com.lcr.contactos.domain.repository.ContactRepository

class ContactRepositoryImpl(private val contactDao: ContactDao): ContactRepository {
    override suspend fun addContact(contact: Contact) {
        contactDao.insert(contact.toEntity())
    }

}