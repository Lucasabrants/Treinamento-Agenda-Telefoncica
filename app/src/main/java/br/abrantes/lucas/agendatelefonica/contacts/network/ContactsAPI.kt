package br.abrantes.lucas.agendatelefonica.contacts.network

import br.abrantes.lucas.agendatelefonica.contacts.model.Contact
import io.reactivex.Observable
import io.realm.RealmResults
import retrofit2.http.GET
import retrofit2.http.Header

interface ContactsAPI {

    @GET("/contacts")
    fun getContatos(@Header("uid") uid: String, @Header("client") client: String, @Header("accessToken") accessToken: String): Observable<RealmResults<Contact>>


}