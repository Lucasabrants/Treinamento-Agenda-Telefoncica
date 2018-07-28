package br.abrantes.lucas.agendatelefonica.auth.business

import br.abrantes.lucas.agendatelefonica.R
import br.abrantes.lucas.agendatelefonica.auth.database.AuthDatabase
import br.abrantes.lucas.agendatelefonica.auth.model.Data
import br.abrantes.lucas.agendatelefonica.auth.model.User
import br.abrantes.lucas.agendatelefonica.auth.network.AuthNetwork
import io.realm.Realm

object AuthBusiness {

    fun fazerLogin(user: User, onSuccess: () -> Unit, onError: (message: Int) -> Unit) {

        AuthNetwork.fazerLogin(user, { usr: User ->

            usr?.let {
                AuthDatabase.limparBanco()
                AuthDatabase.salvaUsuario(it) {
                    onSuccess()
                }
            }
        }, {
            onError(R.string.erro_login)
        })
    }

    fun criarConta(user: User, onSuccess: () -> Unit, onError: (message: Int) -> Unit){

        AuthNetwork.criarConta(user, {
            onSuccess()
        }, {
            onError(R.string.string_erro_sign_up)
        })
    }

    fun fazerLogOut(onSuccess: () -> Unit){

        AuthDatabase.limparBanco()
        onSuccess()
    }

}