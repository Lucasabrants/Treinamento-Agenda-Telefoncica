package br.abrantes.lucas.agendatelefonica.contacts.network

import br.abrantes.lucas.agendatelefonica.contacts.model.Contact
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface ContactsAPI {

    @GET("/contacts")
    fun getContatos(@Header("uid") uid: String, @Header("client") client: String, @Header("access-token") accessToken: String): Observable<Response<List<Contact>>>


}