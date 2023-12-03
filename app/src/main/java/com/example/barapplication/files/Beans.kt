package com.example.barapplication.files

/*
API Cafes Concert
*/
data class ResultsBean (val results : List<DataBarBean>)
data class DataBarBean(var name: String?,
                       var eq_nom_equipement: String,
                       var eq_telephone : String?,
                       var numero: Int?,
                       var lib_off : String?,
                       var id_secteur_postal : Int?,
                       var eq_ville : String?,
                       var eq_site_web : String? )
