package br.abrantes.lucas.agendatelefonica.contacts.database

import br.abrantes.lucas.agendatelefonica.contacts.model.Contact
import io.realm.Realm
import io.realm.RealmResults

object ContactsDatabase {

    fun adicionarContato(contact: Contact, onSuccess: () -> Unit) {

        Realm.getDefaultInstance().use { realm ->

            realm.beginTransaction()
            realm.copyToRealm(contact)
            realm.commitTransaction()
            onSuccess()

        }
    }

    fun listarContatos(onSuccess: (contacts: RealmResults<Contact>) -> Unit) {

        Realm.getDefaultInstance().use { realm ->

            onSuccess(realm.where(Contact::class.java).findAll().sort("name"))

        }
    }

    fun salvarContatos(contacts: List<Contact>, onSuccess: () -> Unit) {

        Realm.getDefaultInstance().use { realm ->

            contacts.forEach {

                realm.beginTransaction()
                realm.copyToRealm(it)
                realm.commitTransaction()

            }

            onSuccess()
        }
    }


}