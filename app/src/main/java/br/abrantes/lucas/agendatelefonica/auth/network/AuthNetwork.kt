package br.abrantes.lucas.agendatelefonica.auth.network

import android.util.Log
import br.abrantes.lucas.agendatelefonica.auth.model.Data
import br.abrantes.lucas.agendatelefonica.auth.model.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object AuthNetwork {

    val authAPI by lazy {
        getRetrofit().create(AuthAPI::class.java)
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://api-agenda-unifor.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    fun fazerLogOut(user: User, onSuccess: () -> Unit, onError: () -> Unit) {

        var uid: String = ""
        var client: String = ""
        var accessToken: String = ""

        user.uid?.let {
            uid = it
        }
        user.client?.let {
            client = it
        }
        user.accessToken?.let {
            accessToken = it
        }


        authAPI.fazerLogOut(uid, client, accessToken)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                    onSuccess()
                }, {

                    onError()
                })


    }

    fun fazerLogin(user: User, onSuccess: (user: User) -> Unit, onError: () -> Unit) {

        authAPI.fazerLogin(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ objeto ->

                    val userResponse = objeto.body()

                    userResponse?.let {
                        it.accessToken = objeto.headers()["access-Token"]
                        it.uid = objeto.headers()["uid"]
                        it.client = objeto.headers()["client"]

                        onSuccess(it)
                    }

                }, {

                    onError()
                })
    }

    fun criarConta(user: User, onSuccess: () -> Unit, onError: () -> Unit) {

        authAPI.criarUsuario(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                    onSuccess()

                }, {

                    onError()

                })
    }
}
