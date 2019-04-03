package com.solutions.hamza.mycontactsmvvm.ui.addcontact

import androidx.lifecycle.ViewModel
import com.solutions.hamza.mycontactsmvvm.datamanger.ContactsRepository
import com.solutions.hamza.mycontactsmvvm.db.Contact

class AddContactViewModel(private var contactsRepository: ContactsRepository) : ViewModel() {

    fun addContact(contact: Contact){
        return contactsRepository.insertContact(contact)
    }
}