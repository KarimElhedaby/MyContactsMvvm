package com.solutions.hamza.mycontactsmvvm.ui.updatecontact

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.solutions.hamza.mycontactsmvvm.datamanger.ContactsRepository

/**
 * Factory class to create [UpdateContactsViewModel] to inject the [ContactsRepository] to it's constructor
 * for better testing.
 */
class UpdateContactsViewModelFactory(private val repository: ContactsRepository) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UpdateContactViewModel(repository) as T
    }

}