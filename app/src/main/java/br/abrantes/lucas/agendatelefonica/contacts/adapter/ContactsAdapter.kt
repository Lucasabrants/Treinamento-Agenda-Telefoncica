package br.abrantes.lucas.agendatelefonica.contacts.adapter

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.abrantes.lucas.agendatelefonica.R
import br.abrantes.lucas.agendatelefonica.contacts.model.Contact
import com.squareup.picasso.Picasso
import io.realm.RealmResults
import kotlinx.android.synthetic.main.view_holder_contact.view.*

class ContactsAdapter(private val contacts: RealmResults<Contact>) : Adapter<ContactsAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val contato = contacts[position]

        contato?.let {
            holder.bind(it)
        }
    }

    override fun getItemCount(): Int = contacts.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_contact, parent, false)
        return ViewHolder(view)
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(contact: Contact){

            val nome = itemView.nomeLista
            val telefone = itemView.phoneLista
            val email = itemView.emailLista
            val foto = itemView.imagemLista

            nome.text = contact.name
            telefone.text = contact.phone
            email.text = contact.email
            Picasso.get().load(contact.picture).into(foto)
        }
    }
}





