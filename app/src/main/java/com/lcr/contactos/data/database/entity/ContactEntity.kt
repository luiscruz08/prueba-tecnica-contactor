package com.lcr.contactos.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "contacts")
data class ContactEntity(
    @PrimaryKey val id: Int?= null,
    val name: String,
    val lastName: String,
    val phoneNumber: String,
    val email: String,
    val imageUrl: String?
)