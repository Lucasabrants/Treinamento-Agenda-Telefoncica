package br.abrantes.lucas.agendatelefonica.contacts.business

import br.abrantes.lucas.agendatelefonica.R
import br.abrantes.lucas.agendatelefonica.auth.database.AuthDatabase
import br.abrantes.lucas.agendatelefonica.auth.model.User
import br.abrantes.lucas.agendatelefonica.contacts.database.ContactsDatabase
import br.abrantes.lucas.agendatelefonica.contacts.model.Contact
import br.abrantes.lucas.agendatelefonica.contacts.network.ContactsNetwork
import io.realm.RealmResults

object ContactsBusiness {

    fun getContatos(onSuccess: () -> Unit, onError: () -> Unit) {
        AuthDatabase.retornaUsuario {user: User ->
            ContactsNetwork.getContatos(user,{contact_list: List<Contact>->

                ContactsDatabase.salvarContatos(contact_list){
                    onSuccess()
                }
            },{

                onError()
            })
        }
    }

    fun listarContatos(onSuccess: (contatos: RealmResults<Contact>) -> Unit, onError: (message: Int) -> Unit) {

        getContatos({

            ContactsDatabase.listarContatos {

                onSuccess(it)

            }
        },{

            onError(R.string.string_erro_listar_contatos)

        })

    }


}