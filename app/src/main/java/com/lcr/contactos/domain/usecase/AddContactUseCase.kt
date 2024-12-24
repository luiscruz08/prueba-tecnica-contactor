package com.lcr.contactos.domain.usecase

import com.lcr.contactos.domain.model.Contact
import com.lcr.contactos.domain.model.InvalidContactException
import com.lcr.contactos.domain.repository.ContactRepository
import kotlin.jvm.Throws

class AddContactUseCase(private val repository: ContactRepository) {

    @Throws(InvalidContactException::class)
    suspend operator fun invoke(contact: Contact){
        if (contact.name.isBlank()){
            throw InvalidContactException("El nombre no puede estar vacío")
        }
        if (contact.lastName.isBlank()){
            throw InvalidContactException("El apellido no puede estar vacío")
        }
        if (contact.email.isBlank()){
            throw InvalidContactException("El correo no puede estar vacío")
        }
        if (contact.phoneNumber.isBlank()){
            throw InvalidContactException("El teléfono no puede estar vacío")
        }

        repository.addContact(contact)

    }
}