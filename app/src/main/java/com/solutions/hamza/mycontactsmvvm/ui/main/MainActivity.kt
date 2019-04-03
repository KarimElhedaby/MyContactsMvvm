package com.solutions.hamza.mycontactsmvvm.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.solutions.hamza.mycontactsmvvm.R
import com.solutions.hamza.mycontactsmvvm.datamanger.ContactsRepository
import com.solutions.hamza.mycontactsmvvm.db.Contact
import com.solutions.hamza.mycontactsmvvm.db.ContactsDatabase
import com.solutions.hamza.mycontactsmvvm.ui.adapter.ContactsAdapter
import com.solutions.hamza.mycontactsmvvm.ui.addcontact.AddContactActivity
import com.solutions.hamza.mycontactsmvvm.ui.updatecontact.UpdateContactActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ContactsAdapter.MenuClick {
    lateinit var adapter: ContactsAdapter
    lateinit var girdLayoutManager: GridLayoutManager
    lateinit var viewModel: ContactsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addContactFAB.setOnClickListener {
            val intent = Intent(this, AddContactActivity::class.java)
            startActivity(intent)
        }

        val db = ContactsDatabase.getInstance(applicationContext)
        val factory = ContactsViewModelFactory(ContactsRepository(db))

        viewModel = ViewModelProviders.of(this, factory).get(ContactsViewModel::class.java)
        viewModel.loadContacts().observe(
                this, Observer {
            adapter = ContactsAdapter(it as MutableList<Contact>, this)
            girdLayoutManager = GridLayoutManager(this, 1)
            contactsRV?.layoutManager = girdLayoutManager
            contactsRV?.adapter = adapter

        })

    }

    override fun onMenuClickListener(contact: Contact, view: View) {
        var popup: PopupMenu? = null;
        popup = PopupMenu(this, view)
        popup.inflate(R.menu.menu)

        popup.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item: MenuItem? ->

            when (item!!.itemId) {
                R.id.update -> {
                    val intent = Intent(this, UpdateContactActivity::class.java)
                    intent.putExtra("contact", contact)
                    startActivity(intent)
                }
                R.id.delete -> {
                    viewModel.deleteContact(contact)
                }
            }
            true
        })

        popup.show()
    }
}
