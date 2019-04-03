package com.solutions.hamza.mycontactsmvvm.ui.updatecontact

import androidx.lifecycle.ViewModel
import com.solutions.hamza.mycontactsmvvm.datamanger.ContactsRepository
import com.solutions.hamza.mycontactsmvvm.db.Contact

class UpdateContactViewModel(private var contactsRepository: ContactsRepository) : ViewModel() {

    fun updateContact(contact: Contact){
        return contactsRepository.updateContact(contact.copy(name = contact.name ,phoneNumber = contact.phoneNumber))
    }
}