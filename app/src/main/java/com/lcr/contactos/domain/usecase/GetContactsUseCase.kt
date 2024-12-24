package com.lcr.contactos.domain.usecase

import com.lcr.contactos.domain.model.Contact
import com.lcr.contactos.domain.repository.ContactRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetContactsUseCase @Inject constructor(private val contactRepository: ContactRepository){

operator fun invoke(): Flow<List<Contact>> {
        return contactRepository.getContacts()
    }

}