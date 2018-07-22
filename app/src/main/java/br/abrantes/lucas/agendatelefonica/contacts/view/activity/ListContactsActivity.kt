package br.abrantes.lucas.agendatelefonica.contacts.view.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.abrantes.lucas.agendatelefonica.R
import br.abrantes.lucas.agendatelefonica.contacts.model.Contact
import kotlinx.android.synthetic.main.activity_list_contacts.*

private val aux:Contact = Contact()

class ListContactsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_contacts)

        configuraRecyclerView()
    }

    private fun configuraRecyclerView(){
    }

    private fun contatos(): List<Contact> {
        return listOf(aux)
    }
}
