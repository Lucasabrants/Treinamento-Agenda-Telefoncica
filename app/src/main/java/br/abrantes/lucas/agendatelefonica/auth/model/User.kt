package br.abrantes.lucas.agendatelefonica.auth.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class User : RealmObject() {

    @PrimaryKey
    var id: Int = 0
    var password: String? = null
    var password_confirmation: String? = null
    var email: String? = null
    var uid: String? = null
    var client: String? = null
    var accessToken: String? = null

}