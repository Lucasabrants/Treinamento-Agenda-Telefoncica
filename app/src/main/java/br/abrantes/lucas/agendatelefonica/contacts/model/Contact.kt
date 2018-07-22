package br.abrantes.lucas.agendatelefonica.contacts.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Contact : RealmObject() {

    @PrimaryKey
    var id: Int = 0
    var name: String? = null
    var email: String? = null
    var phone: String? = null
    var picture: String = "http://www.topimagens.com.br/imagens/imagens-mais-novas.jpg"
    var birth: String? = null
}