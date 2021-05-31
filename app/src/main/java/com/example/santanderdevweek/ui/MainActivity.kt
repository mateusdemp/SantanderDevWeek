package com.example.santanderdevweek.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.santanderdevweek.R
import com.example.santanderdevweek.data.Account

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        findAccountClient()

    }

    private fun findAccountClient() {
        mainViewModel.buscarContaCliente().observe(this, { result ->
            bindOnView(result)
        })
    }

    private fun bindOnView(account: Account) {
        /**
         *  Passando o valor do objeto diretamente nas váriaves de texto %1$s (nesse caso ele espera uma string)
         *  Agora você pode customizar seu texto estático e passar um valor dinâmico dentro dele ao mesmo tempo.
         *  Neste caso, os caracteres de R$ serão estátitcos e o valor em reais será dinâmico, pois o valor será variado conforme
         *  cada cliente.
         *
         *  link sobre formatação de strings:
         *  https://developer.android.com/guide/topics/resources/string-resource
         */

        findViewById<TextView>(R.id.tv_agency).text =
            String.format(resources.getString(R.string.txt_agency), account.agency)

        findViewById<TextView>(R.id.tv_account_currency).text =
            String.format(resources.getString(R.string.txt_account_currency), account.number)

        findViewById<TextView>(R.id.tv_balance).text =
            String.format(resources.getString(R.string.txt_balance), account.balance)

        findViewById<TextView>(R.id.tv_limit).text =
            String.format(resources.getString(R.string.txt_limit), account.limit)

        findViewById<TextView>(R.id.tv_hello_client).text =
            String.format(resources.getString(R.string.txt_hello_client), account.client.name)

        findViewById<TextView>(R.id.tv_card_number).text =
            String.format(
                resources.getString(R.string.txt_card_final_number),
                account.card.numberCard
            )
    }
}