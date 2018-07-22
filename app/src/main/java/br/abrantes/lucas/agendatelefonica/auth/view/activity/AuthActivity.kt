package br.abrantes.lucas.agendatelefonica.auth.view.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.util.Log
import br.abrantes.lucas.agendatelefonica.R
import br.abrantes.lucas.agendatelefonica.auth.business.AuthBusiness
import br.abrantes.lucas.agendatelefonica.auth.model.User
import br.abrantes.lucas.agendatelefonica.contacts.view.activity.ListContactsActivity
import com.squareup.picasso.Picasso
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_auth.*

class AuthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        configuraImagem()

        Realm.init(this)

        configuraBotaoLogin()
        configuraBotaoSignUp()


    }

    private fun configuraImagem() {

        Picasso.get()
                .load("https://avatars0.githubusercontent.com/u/32719438?s=460&v=4")
                .into(imagemLogin)
    }

    private fun configuraBotaoSignUp() {

        botaoSignUp.setOnClickListener {

            var user = User()
            user.email = campoEmail.text.toString()
            user.password = campoSenha.text.toString()
            user.password_confirmation = campoSenha.text.toString()

            AuthBusiness.criarConta(user, {
                Snackbar.make(botaoSignUp, getString(R.string.mensagem_contacriada), Snackbar.LENGTH_LONG).show()
            }, {messageResource ->

                Snackbar.make(botaoSignUp, messageResource, Snackbar.LENGTH_LONG).show()

            })
        }

    }

    private fun configuraBotaoLogin() {

        botaoLogin.setOnClickListener {

            var user = User()
            user.email = campoEmail.text.toString()
            user.password = campoSenha.text.toString()

            AuthBusiness.fazerLogin(user, {
                Snackbar.make(botaoLogin, getString(R.string.mensagem_login), Snackbar.LENGTH_LONG).show()
                Log.d("TAG","login deu certo")
                val intent = Intent(this,ListContactsActivity::class.java)
                startActivity(intent)

            }, { messageResource ->

                Snackbar.make(botaoLogin, messageResource, Snackbar.LENGTH_LONG).show()
                Log.d("TAG","login não deu certo")
            })

        }
    }


}
