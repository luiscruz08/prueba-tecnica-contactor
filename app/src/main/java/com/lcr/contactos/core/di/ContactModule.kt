package com.lcr.contactos.core.di

import android.app.Application
import androidx.room.Room
import com.lcr.contactos.data.database.ContactsDatabase
import com.lcr.contactos.data.repository.ContactRepositoryImpl
import com.lcr.contactos.domain.repository.ContactRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ContactModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): ContactsDatabase {
        return Room.databaseBuilder(app,ContactsDatabase::class.java,ContactsDatabase.DATABASE_NAME).build()
    }

    @Provides
    @Singleton
    fun provideContactRepository(db:ContactsDatabase): ContactRepository {
        return ContactRepositoryImpl(db.contactDao)
    }

}
