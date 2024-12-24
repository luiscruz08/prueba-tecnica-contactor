package com.lcr.contactos.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.lcr.contactos.domain.model.Contact

@Entity (tableName = "contacts")
data class ContactEntity(
    @PrimaryKey val id: Int?= null,
    val name: String,
    val lastName: String,
    val phoneNumber: String,
    val email: String,
    val imageUrl: String?
)

fun ContactEntity.toDomain() = Contact(
    id = id,
    name = name,
    lastName = lastName,
    phoneNumber = phoneNumber,
    email = email,
    imageUrl = imageUrl
)