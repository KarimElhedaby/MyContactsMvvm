package com.solutions.hamza.mycontactsmvvm.ui.addcontact

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.solutions.hamza.mycontactsmvvm.datamanger.ContactsRepository

/**
 * Factory class to create [AddContactsViewModel] to inject the [ContactsRepository] to it's constructor
 * for better testing.
 */
class AddContactsViewModelFactory(private val repository: ContactsRepository) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AddContactViewModel(repository) as T
    }

}