package com.lcr.contactos.domain.usecase

import com.google.common.truth.Truth.assertThat
import com.lcr.contactos.data.repository.FakeContactRepository
import com.lcr.contactos.domain.model.Contact
import com.lcr.contactos.domain.model.OrderType
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


class GetContactsUseCaseTest {

    private lateinit var getContactsUseCase: GetContactsUseCase
    private lateinit var fakeContactRepository: FakeContactRepository

    @Before
    fun setUp() {
        fakeContactRepository = FakeContactRepository()
        getContactsUseCase = GetContactsUseCase(fakeContactRepository)
        makeFakeContacts()
    }

    private fun makeFakeContacts(){
        runBlocking {
            for (i in 1..1000){
                fakeContactRepository.addContact(
                    Contact(
                        name = randomString(10),
                        lastName = randomString(10),
                        email = randomString(10),
                        phoneNumber = randomString(10),
                        imageUrl = randomString(10)
                    )
                )
            }
        }
    }

    @Test
    fun `Order contacts ascending, correct order query search empty`() = runBlocking{
        val contacts = getContactsUseCase("", OrderType.Ascending).first()

        for (i in 0..contacts.size-2){
            assertThat(contacts[i].name).isLessThan(contacts[i+1].name)
        }
    }

    @Test
    fun `Order contacts descending, correct order query search empty`() = runBlocking{
        val contacts = getContactsUseCase("", OrderType.Descending).first()

        for (i in 0..contacts.size-2){
            assertThat(contacts[i].name).isGreaterThan(contacts[i+1].name)
        }
    }

    @Test
    fun `Order contacts descending, correct order query search with random data`() = runBlocking{
        for (i in 1..200){
            val randomSearchString = randomString(2)
            val contactsOrderedFromRepository = fakeContactRepository.contacts.filter {
                contact->
                contact.name.contains(randomSearchString) || contact.lastName.contains(randomSearchString)
                        || contact.email.contains(randomSearchString) || contact.phoneNumber.contains(randomSearchString)
            }.sortedByDescending { it.name }
            val contactsFromUseCase = getContactsUseCase(randomSearchString, OrderType.Descending).first()
            assertThat(contactsFromUseCase).containsExactlyElementsIn(contactsOrderedFromRepository).inOrder()
        }
        for (i in 1..200){
            val randomSearchString = randomString(3)
            val contactsOrderedFromRepository = fakeContactRepository.contacts.filter {
                    contact->
                contact.name.contains(randomSearchString) || contact.lastName.contains(randomSearchString)
                        || contact.email.contains(randomSearchString) || contact.phoneNumber.contains(randomSearchString)
            }.sortedByDescending { it.name }
            val contactsFromUseCase = getContactsUseCase(randomSearchString, OrderType.Descending).first()
            assertThat(contactsFromUseCase).containsExactlyElementsIn(contactsOrderedFromRepository).inOrder()
        }
        for (i in 1..200){
            val randomSearchString = randomString(4)
            val contactsOrderedFromRepository = fakeContactRepository.contacts.filter {
                    contact->
                contact.name.contains(randomSearchString) || contact.lastName.contains(randomSearchString)
                        || contact.email.contains(randomSearchString) || contact.phoneNumber.contains(randomSearchString)
            }.sortedByDescending { it.name }
            val contactsFromUseCase = getContactsUseCase(randomSearchString, OrderType.Descending).first()
            assertThat(contactsFromUseCase).containsExactlyElementsIn(contactsOrderedFromRepository).inOrder()
        }
    }

    @Test
    fun `Order contacts ascending, correct order query search with random data`() = runBlocking{
        for (i in 1..200){
            val randomSearchString = randomString(2)
            val contactsOrderedFromRepository = fakeContactRepository.contacts.filter {
                    contact->
                contact.name.contains(randomSearchString) || contact.lastName.contains(randomSearchString)
                        || contact.email.contains(randomSearchString) || contact.phoneNumber.contains(randomSearchString)
            }.sortedBy { it.name }
            val contactsFromUseCase = getContactsUseCase(randomSearchString, OrderType.Ascending).first()
            assertThat(contactsFromUseCase).containsExactlyElementsIn(contactsOrderedFromRepository).inOrder()
        }

        for (i in 1..200){
            val randomSearchString = randomString(3)
            val contactsOrderedFromRepository = fakeContactRepository.contacts.filter {
                    contact->
                contact.name.contains(randomSearchString) || contact.lastName.contains(randomSearchString)
                        || contact.email.contains(randomSearchString) || contact.phoneNumber.contains(randomSearchString)
            }.sortedBy { it.name }
            val contactsFromUseCase = getContactsUseCase(randomSearchString, OrderType.Ascending).first()
            assertThat(contactsFromUseCase).containsExactlyElementsIn(contactsOrderedFromRepository).inOrder()
        }

        for (i in 1..200){
            val randomSearchString = randomString(4)
            val contactsOrderedFromRepository = fakeContactRepository.contacts.filter {
                    contact->
                contact.name.contains(randomSearchString) || contact.lastName.contains(randomSearchString)
                        || contact.email.contains(randomSearchString) || contact.phoneNumber.contains(randomSearchString)
            }.sortedBy { it.name }
            val contactsFromUseCase = getContactsUseCase(randomSearchString, OrderType.Ascending).first()
            assertThat(contactsFromUseCase).containsExactlyElementsIn(contactsOrderedFromRepository).inOrder()
        }

    }



    private fun randomString(longitud: Int): String {
        val characters = ('a'..'z')
        return buildString {
            repeat(longitud) {
                append(characters.random())
            }
        }
    }
}