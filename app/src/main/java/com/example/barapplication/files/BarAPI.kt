package com.example.barapplication.files

import com.example.barapplication.files.BarAPI.loadData
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request

fun main() {
    for (bar : DataBarBean in loadData()?.results!!){
        println(bar.eq_nom_equipement)
        println(bar.eq_telephone?: "inconnu")
    }
}

object BarAPI {
    private val bar = OkHttpClient()
    val gson = Gson()

    fun loadData(): ResultsBean? = gson.fromJson(sendGet("https://data.toulouse-metropole.fr/api/explore/v2.1/catalog/datasets/cafes-concerts/records?limit=50"), ResultsBean::class.java)


    fun sendGet(url: String): String {
        //Création de la requête
        val request = Request.Builder().url(url).build()
        //Execution de la requête
        return bar.newCall(request).execute().use {
            //Analyse du code retour
            if (!it.isSuccessful) {
                throw Exception("Réponse du serveur incorrect :${it.code}")
            }
            //Résultat de la requête
            it.body.string()
        }
    }


}