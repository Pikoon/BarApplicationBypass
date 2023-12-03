package com.example.barapplication.ui

sealed class Routes (val route:String) {

    object firstPrez : Routes("homeScreen")

    object detailedScreen : Routes("detailedScreen/{data}") {
        fun addParam(position: Int) = "detailedScreen/$position"
    }
}
