package com.solutions.hamza.mycontactsmvvm.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.solutions.hamza.mycontactsmvvm.datamanger.ContactsRepository
import com.solutions.hamza.mycontactsmvvm.db.Contact

class ContactsViewModel(private var contactsRepository: ContactsRepository) : ViewModel() {
//    val contactsLiveData: LiveData<List<Contact>> = contactsRepository.loadContacts()

    fun loadContacts(): LiveData<List<Contact>> {
        return contactsRepository.loadContacts()
    }
    fun deleteContact(contact: Contact) {
        contactsRepository.deleteUser(contact)
    }

  }