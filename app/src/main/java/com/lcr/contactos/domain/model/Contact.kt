package com.lcr.contactos.domain.model

import com.lcr.contactos.data.database.entity.ContactEntity

data class Contact(val name: String,
                   val lastName: String,
                   val phoneNumber: String,
                   val email: String,
                   val imageUrl: String?,
                    val id: Int? = null)

fun Contact.toEntity() = ContactEntity(
    name = name,
    lastName = lastName,
    phoneNumber = phoneNumber,
    email = email,
    imageUrl = imageUrl,
    id = id
)
