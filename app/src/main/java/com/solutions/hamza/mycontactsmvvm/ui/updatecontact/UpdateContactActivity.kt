package com.solutions.hamza.mycontactsmvvm.ui.updatecontact

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.solutions.hamza.mycontactsmvvm.R
import com.solutions.hamza.mycontactsmvvm.datamanger.ContactsRepository
import com.solutions.hamza.mycontactsmvvm.db.Contact
import com.solutions.hamza.mycontactsmvvm.db.ContactsDatabase
import kotlinx.android.synthetic.main.activity_update_contact.*
import java.util.*

class UpdateContactActivity : AppCompatActivity() {

    lateinit var contact: Contact

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_contact)

        contact = intent.getParcelableExtra("contact")
        updatePhoneNameTV.setText(contact.name)
        updatePhoneNumTV.setText(contact.phoneNumber)

        updatePhoneSaveB.setOnClickListener {
            val db = ContactsDatabase.getInstance(applicationContext)
            val factory = UpdateContactsViewModelFactory(ContactsRepository(db))
            val viewModel = ViewModelProviders.of(this, factory).get(UpdateContactViewModel::class.java)
            viewModel.updateContact(contact.copy(name = updatePhoneNameTV.text.toString(), phoneNumber = updatePhoneNumTV.text.toString(), date = Date()))

            Toast.makeText(this, contact.name + "updated successfully", Toast.LENGTH_LONG).show()
            finish()
        }

    }
}
