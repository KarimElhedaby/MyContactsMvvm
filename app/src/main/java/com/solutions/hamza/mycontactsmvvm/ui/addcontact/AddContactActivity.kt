package com.solutions.hamza.mycontactsmvvm.ui.addcontact

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.solutions.hamza.mycontactsmvvm.R
import com.solutions.hamza.mycontactsmvvm.datamanger.ContactsRepository
import com.solutions.hamza.mycontactsmvvm.db.Contact
import com.solutions.hamza.mycontactsmvvm.db.ContactsDatabase
import kotlinx.android.synthetic.main.activity_add_contact.*
import java.util.*


class AddContactActivity : AppCompatActivity() {
    lateinit var contact: Contact
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contact)

        phoneSaveB.setOnClickListener {
            contact = Contact(name = phoneNameTV.text.toString(), phoneNumber = phoneNumTV.text.toString(), date = Date())
            val db = ContactsDatabase.getInstance(applicationContext)
            val factory = AddContactsViewModelFactory(ContactsRepository(db))
            val viewModel = ViewModelProviders.of(this, factory).get(AddContactViewModel::class.java)
            viewModel.addContact(contact)

            Toast.makeText(this, contact.name + "saved successfully", Toast.LENGTH_LONG).show()
            finish()
        }
    }
}
