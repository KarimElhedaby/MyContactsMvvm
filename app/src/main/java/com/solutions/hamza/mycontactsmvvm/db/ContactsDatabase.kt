package com.solutions.hamza.mycontactsmvvm.db

import android.content.Context
import androidx.room.*
import com.solutions.hamza.mycontactsmvvm.util.SingletonHolder

@Database(entities = [Contact::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class ContactsDatabase : RoomDatabase() {

    abstract fun contactsDao(): ContactsDao

    /**
     * Initialize [ContactsDatabase] lazily as singleton to use on demand. For a production
     */
    companion object : SingletonHolder<ContactsDatabase, Context>({
        Room.databaseBuilder(it.applicationContext,
                ContactsDatabase::class.java, "contacts.db")
                .build()
    })

}