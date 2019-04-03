package com.solutions.hamza.mycontactsmvvm.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.solutions.hamza.mycontactsmvvm.db.Contact

/**
 * Room data access object to do operations on the [Contact.CONTACTS_TABLE]
 */
@Dao
interface ContactsDao {
    /**
     * Wrapped around [LiveData] so when a new photo added to the db it will be observed
     * automatically at the UI to avoid pulling the db and have better lifecycle support.
     */
    @Query("SELECT * FROM ${Contact.CONTACTS_TABLE}")
    fun loadContacts(): LiveData<List<Contact>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertContact(contact: Contact)

        @Update
        fun updateContact(contact: Contact)

    @Delete
    fun deleteContact(contact: Contact)

}