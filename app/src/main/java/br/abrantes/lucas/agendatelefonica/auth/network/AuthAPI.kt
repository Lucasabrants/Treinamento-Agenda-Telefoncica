package br.abrantes.lucas.agendatelefonica.auth.network

import br.abrantes.lucas.agendatelefonica.auth.model.Data
import br.abrantes.lucas.agendatelefonica.auth.model.User
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.*

interface AuthAPI {

    @DELETE("/auth/sign_out")
    fun fazerLogOut(@Header("uid") uid: String, @Header("client") client: String, @Header("accessToken") accessToken: String): Observable<Data>

    @POST("/auth/sign_in")
    fun fazerLogin(@Body user: User): Observable<Response<User>>

    @POST("/auth")
    fun criarUsuario(@Body user: User): Observable<Data>

}