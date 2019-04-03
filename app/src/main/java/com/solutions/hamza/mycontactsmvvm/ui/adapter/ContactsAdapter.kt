package com.solutions.hamza.mycontactsmvvm.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.solutions.hamza.mycontactsmvvm.R
import com.solutions.hamza.mycontactsmvvm.db.Contact
import kotlinx.android.synthetic.main.item_contact.view.*


class ContactsAdapter(var contacts: MutableList<Contact>, var MenuListner: MenuClick) :
        RecyclerView.Adapter<ContactsVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsVH {
        return ContactsVH(
                LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_contact, null)
        )
    }

    override fun onBindViewHolder(holder: ContactsVH, position: Int) {

        with(holder.itemView) {
            contactNameTV.text = contacts[position].name
            contactPhoneTV.text = contacts[position].phoneNumber

            menuIV.setOnClickListener {
                MenuListner.onMenuClickListener(contacts[position],it )
            }


        }
    }

    open interface MenuClick {
        fun onMenuClickListener(contact: Contact, view: View)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }
}


