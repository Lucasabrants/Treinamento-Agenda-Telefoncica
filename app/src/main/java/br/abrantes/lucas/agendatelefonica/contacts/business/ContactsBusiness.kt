package br.abrantes.lucas.agendatelefonica.contacts.business

import br.abrantes.lucas.agendatelefonica.auth.database.AuthDatabase
import br.abrantes.lucas.agendatelefonica.contacts.database.ContactsDatabase
import br.abrantes.lucas.agendatelefonica.contacts.network.ContactsNetwork

object ContactsBusiness {

    fun getContatos(onSuccess: (boolean:Boolean) -> Unit, onError: () -> Unit) {
        AuthDatabase.retornaUsuario {usuario->

            ContactsNetwork.getContatos(usuario,{lista_de_contatos->

                ContactsDatabase.salvarContatos(lista_de_contatos){
                    onSuccess(true)
                }

            },{
                onError()
            })

        }

    }


}