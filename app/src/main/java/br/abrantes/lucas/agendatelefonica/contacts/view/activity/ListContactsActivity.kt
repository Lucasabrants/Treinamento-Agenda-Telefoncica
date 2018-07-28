package br.abrantes.lucas.agendatelefonica.contacts.view.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import br.abrantes.lucas.agendatelefonica.R
import br.abrantes.lucas.agendatelefonica.contacts.adapter.ContactsAdapter
import br.abrantes.lucas.agendatelefonica.contacts.business.ContactsBusiness
import br.abrantes.lucas.agendatelefonica.contacts.model.Contact
import io.realm.RealmResults
import kotlinx.android.synthetic.main.activity_list_contacts.*

class ListContactsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_contacts)

        listarContatos()
    }

    private fun listarContatos(){

        ContactsBusiness.listarContatos({contatos ->

            configuraRecyclerView(contatos)

        },{messageResource ->

            Snackbar.make(recyclerView,messageResource,Snackbar.LENGTH_LONG).show()

        })
    }

    private fun configuraRecyclerView(contatos: RealmResults<Contact>){

        recyclerView.adapter = ContactsAdapter(contatos)

    }

}
