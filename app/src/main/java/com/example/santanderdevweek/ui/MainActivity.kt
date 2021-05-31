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
        findViewById<TextView>(R.id.tv_agency).text = account.agency
        findViewById<TextView>(R.id.tv_account_currency).text = account.number
        findViewById<TextView>(R.id.tv_balance).text = account.balance
        findViewById<TextView>(R.id.tv_limit).text = account.limit
        findViewById<TextView>(R.id.tv_client).text = account.client.name
        findViewById<TextView>(R.id.tv_card_number).text = account.card.numberCard
    }
}