package com.example.santanderdevweek.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.santanderdevweek.R
import com.example.santanderdevweek.data.Conta

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbarMenu))


        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        buscarContaCliente()
    }


    private fun buscarContaCliente(){
        mainViewModel.buscarContaCliente().observe(this, Observer { result ->
            bindOnView(result)
        })
    }
    private fun bindOnView(conta : Conta){
        findViewById<TextView>(R.id.tvAgencia).text = conta.agencia
        findViewById<TextView>(R.id.tvContaC).text = conta.numero
        findViewById<TextView>(R.id.tvSaldo).text = conta.saldo
        findViewById<TextView>(R.id.tvLimite).text = conta.limite
        findViewById<TextView>(R.id.tvUsuario).text = conta.cliente.nome
        findViewById<TextView>(R.id.tvCartaoFinalDados).text = conta.cartao.numeroConta
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.item_1 -> {
                Log.d("CLICK", "Click no item 1")
                true
            }else -> super.onOptionsItemSelected(item)
        }
    }
}