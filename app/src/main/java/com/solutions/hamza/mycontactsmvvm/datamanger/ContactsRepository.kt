package com.solutions.hamza.mycontactsmvvm.datamanger

import android.util.Log
import androidx.lifecycle.LiveData
import com.solutions.hamza.mycontactsmvvm.db.Contact
import com.solutions.hamza.mycontactsmvvm.db.ContactsDatabase
import java.lang.Exception
import java.util.concurrent.Executors

class ContactsRepository(private val db: ContactsDatabase) {

    private val executor = Executors.newSingleThreadExecutor()

    fun loadContacts(): LiveData<List<Contact>> {
        return db.contactsDao().loadContacts()
    }

    fun updateContact(contact: Contact) {
        executor.execute {
            try {
                db.contactsDao().updateContact(contact)
            } catch (ex: Exception) {
                //TODO in production provide better error handling
                Log.e("ContactsRepository", "Couldn't update contact: $contact")
            }
        }
    }

    fun insertContact(contact: Contact) {
        executor.execute {
            try {
                db.contactsDao().insertContact(contact)
            } catch (ex: Exception) {
                //TODO in production provide better error handling
                Log.e("ContactsRepository", "Couldn't insert contact: $contact")
            }
        }
    }

    fun deleteUser(contact: Contact) {
        executor.execute {
            try {
                db.contactsDao().deleteContact(contact)
            } catch (ex: Exception) {
                //TODO in production provide better error handling
                Log.e("ContactsRepository", "Couldn't delete contact: $contact")
            }
        }
    }
}