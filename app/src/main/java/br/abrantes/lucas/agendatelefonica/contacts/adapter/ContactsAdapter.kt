package br.abrantes.lucas.agendatelefonica.contacts.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import br.abrantes.lucas.agendatelefonica.R
import br.abrantes.lucas.agendatelefonica.contacts.model.Contact
import br.abrantes.lucas.agendatelefonica.contacts.view.holder.ContactsViewHolder
import io.realm.RealmResults

class ContactsAdapter(contact_list: RealmResults<Contact>):RecyclerView.Adapter<ContactsViewHolder>(){

    val contatos = contact_list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.view_holder_contact, parent, false)

        return ContactsViewHolder(view)
    }

    override fun getItemCount(): Int = contatos.size

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {

        contatos[position]?.let {
            holder.bind(it)
        }
    }

}