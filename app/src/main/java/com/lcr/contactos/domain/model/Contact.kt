package com.lcr.contactos.domain.model

import com.lcr.contactos.data.database.entity.ContactEntity

data class Contact(
    val name: String,
    val lastName: String,
    val phoneNumber: String,
    val email: String,
    val imageUrl: String?,
    val id: Int? = null
)

fun Contact.toEntity() = ContactEntity(
    name = name,
    lastName = lastName,
    phoneNumber = phoneNumber,
    email = email,
    imageUrl = imageUrl,
    id = id
)

fun Contact.filterByAllData(query: String): Boolean {
    return if (query.isBlank()) {
        true
    } else {
        name.contains(query, ignoreCase = true) ||
                lastName.contains(query, ignoreCase = true) ||
                phoneNumber.contains(query, ignoreCase = true) ||
                email.contains(query, ignoreCase = true)
    }
}
