package com.example.barapplication.files

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainViewModel : ViewModel() {
    var listBar = mutableStateListOf<DataBarBean>()
        private set

    //Traitement en cours
    var runInProgress by mutableStateOf(false)

    var error by mutableStateOf("")

    fun loadDataVM() {//Simulation de chargement de donnée
        listBar.clear()
        runInProgress = true
        error = ""
        viewModelScope.launch(Dispatchers.Default) {
            try {
                val data: ResultsBean? = BarAPI.loadData()
                if (data != null)
                    listBar.addAll(data.results)
            } catch (e: Exception) {
                e.printStackTrace()
                error = e.message ?: "Erreur"
            }
            // }
            runInProgress = false
        }
    }
}