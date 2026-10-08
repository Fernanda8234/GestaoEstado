package com.example.gestaoestado.juros

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gestaoestado.calculos.calcularJuros
import com.example.gestaoestado.calculos.calcularMontante

class JurosScreenViewModel: ViewModel(){
    // o _ é uma boa pratica para variaveis privadas
    private val _capital = MutableLiveData<String>()

    // é redundante, sim, mas serve para alterar ela sem mexer no original, é uma boa pratica
    val capital: LiveData<String> = _capital

    fun onCapitalChaged(novoCapital: String){
        _capital.value = novoCapital
    }

    private val _taxa = MutableLiveData<String>()

    val taxa: LiveData<String> = _taxa

    fun onTaxaChaged(novaTaxa: String){
        _taxa.value = novaTaxa
    }

    private val _tempo = MutableLiveData<String>()

    val tempo: LiveData<String> = _tempo

    fun onTempoChaged(novoTempo: String){
        _tempo.value = novoTempo
    }

    private val _juros = MutableLiveData<Double>()

    val juros: LiveData<Double> = _juros

    private val _montante = MutableLiveData<Double>()

    val montante: LiveData<Double> = _montante

    fun calcularJurosInvestimento(){
        _juros.value = calcularJuros(
            capital = _capital.value!!.toDouble(),
            taxa = _taxa.value!!.toDouble(),
            tempo = _tempo.value!!.toDouble())
    }

    fun calcularMontanteInvestimento(){
        _montante.value = calcularMontante(
            capital = _capital.value!!.toDouble(),
            juros = _juros.value!!
        )
    }
}