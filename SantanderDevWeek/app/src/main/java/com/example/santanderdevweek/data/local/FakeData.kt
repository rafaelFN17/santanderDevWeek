package com.example.santanderdevweek.data.local

import com.example.santanderdevweek.data.Cartao
import com.example.santanderdevweek.data.Cliente
import com.example.santanderdevweek.data.Conta

class FakeData {
    fun getLocalData() : Conta {
        val cliente = Cliente("Igor")
        val cartao = Cartao("411111111")
        return Conta("444655-4", "6552-4"
        ,"R$2450,80", "R$4.120,00", cliente,cartao)
    }
}