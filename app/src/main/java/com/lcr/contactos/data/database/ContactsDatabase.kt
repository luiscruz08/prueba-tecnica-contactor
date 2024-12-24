package com.lcr.contactos.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lcr.contactos.data.database.dao.ContactDao
import com.lcr.contactos.data.database.entity.ContactEntity

@Database(entities = [ContactEntity::class], version = 1)
abstract class ContactsDatabase : RoomDatabase() {

    abstract val contactDao: ContactDao

    companion object {
        val DATABASE_NAME = "contacts_db"
    }
}