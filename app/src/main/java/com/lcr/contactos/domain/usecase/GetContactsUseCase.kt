package com.lcr.contactos.domain.usecase

import com.lcr.contactos.domain.model.Contact
import com.lcr.contactos.domain.model.OrderType
import com.lcr.contactos.domain.model.filterByAllData
import com.lcr.contactos.domain.repository.ContactRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetContactsUseCase @Inject constructor(private val contactRepository: ContactRepository) {

    operator fun invoke(query: String, orderType: OrderType): Flow<List<Contact>> {
        return contactRepository.getContacts()
            .map { contacts ->
                when (orderType) {
                    is OrderType.Ascending -> contacts.sortedBy { it.name.lowercase() }
                        .filter { contact -> contact.filterByAllData(query) }

                    is OrderType.Descending -> contacts.sortedByDescending { it.name.lowercase() }
                        .filter { contact -> contact.filterByAllData(query) }
                }
            }
    }

}