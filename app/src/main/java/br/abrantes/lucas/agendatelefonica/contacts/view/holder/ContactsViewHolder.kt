package br.abrantes.lucas.agendatelefonica.contacts.view.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import br.abrantes.lucas.agendatelefonica.contacts.model.Contact
//import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.view_holder_contact.view.*

class ContactsViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(contact: Contact){

        with(view){
            nomeLista.text = contact.name
            phoneLista.text = contact.phone
            emailLista.text = contact.email
        }
    }
}