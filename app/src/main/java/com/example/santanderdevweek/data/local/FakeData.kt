package com.example.santanderdevweek.data.local

import com.example.santanderdevweek.data.Account
import com.example.santanderdevweek.data.Card
import com.example.santanderdevweek.data.Client

class FakeData {
    fun getLocalData(): Account {

        val client = Client("Mateus")
        val card = Card("0033")

        return Account(
            "4312452-1",
            "5242",
            "2.450,00",
            "4.000,00",
            client,
            card
        )
    }
}