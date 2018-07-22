package br.abrantes.lucas.agendatelefonica.auth.database

import br.abrantes.lucas.agendatelefonica.auth.model.User
import io.realm.Realm

object AuthDatabase {

    fun salvaUsuario(user: User, onSuccess: () -> Unit) {

        Realm.getDefaultInstance().use { realm ->

            realm.beginTransaction()
            realm.copyToRealm(user)
            realm.commitTransaction()
            onSuccess()

        }
    }

    fun retornaUsuario(onSuccess: (user: User) -> Unit) {

        Realm.getDefaultInstance().use { realm ->

            val users = realm.where(User::class.java)
                    .findAll()
            val user = users.first()

            return@use user?.let {
                onSuccess(it)
            }

        }
    }

    fun limparBanco() {

        Realm.getDefaultInstance().use { realm ->
            realm.beginTransaction()
            realm.deleteAll()
            realm.commitTransaction()
        }
    }

}