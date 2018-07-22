package br.abrantes.lucas.agendatelefonica.contacts.network

import br.abrantes.lucas.agendatelefonica.auth.model.User
import br.abrantes.lucas.agendatelefonica.contacts.model.Contact
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.realm.RealmResults
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ContactsNetwork {

    val contactsAPI by lazy {
        getRetrofit().create(ContactsAPI::class.java)
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://api-agenda-unifor.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    fun getContatos(user: User, onSuccess: (contacts: RealmResults<Contact>) -> Unit, onError: () -> Unit) {

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

        contactsAPI.getContatos(uid, client, accessToken)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ contatos ->

                    onSuccess(contatos)

                }, {

                    onError()
                })
    }

}