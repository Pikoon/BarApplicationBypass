package com.example.barapplication.files

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class MainViewModel : ViewModel() {
    //_myList modifiable à l'intérieur de la classe, myList non modifiable à l'exterieur
    var listBar = mutableStateListOf<DataBarBean?>(null)
        private set

    //Traitement en cours
    var runInProgress by mutableStateOf(false)

    var error by mutableStateOf("")
    /*var searchText by mutableStateOf("")
        private set

    fun uploadSearchText(newText: String) {
        searchText = newText
    }*/

    fun loadDataVM() {//Simulation de chargement de donnée
        runInProgress = true
        var data: ResultsBean? = null
        viewModelScope.launch {
            data = BarAPI.loadData()
            if (data != null)
                listBar.addAll(data!!.results)
        runInProgress=false
        }


    }
}

fun main() {
    var viewModel = MainViewModel()
    viewModel.loadDataVM()
    println(viewModel.listBar.get(1)?.eq_nom_equipement)
    println(viewModel.listBar.get(2)?.eq_nom_equipement)
}
