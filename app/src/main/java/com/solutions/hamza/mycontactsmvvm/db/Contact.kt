package com.solutions.hamza.mycontactsmvvm.db

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
@Entity(tableName = Contact.CONTACTS_TABLE)
data class Contact(
        @PrimaryKey(autoGenerate = true)
        val id: Long = 0,
        val name: String,
        @ColumnInfo(name = "phone_number")
        val phoneNumber: String,
        val date: Date) : Parcelable {

    companion object {
        //Contacts SQL table name.
        const val CONTACTS_TABLE = "contacts_table"

    }
}