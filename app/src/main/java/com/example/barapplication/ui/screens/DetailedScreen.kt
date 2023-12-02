package com.example.barapplication.ui.screens

import android.os.StrictMode
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.barapplication.files.DataBarBean
import com.example.barapplication.files.MainViewModel
import com.example.barapplication.ui.theme.BarApplicationTheme


@Preview
@Composable
fun previewDetailedScreen() {
    BarApplicationTheme {
        Surface(modifier = Modifier.fillMaxWidth(), color = Color.LightGray) {
            DetailedScreen(position = 1)
        }
    }
}

@Composable
fun DetailedScreen (position : Int,
                   modifier : Modifier = Modifier,
                   viewModel: MainViewModel = androidx.lifecycle.viewmodel.compose.viewModel()){
    testPurposes()//to be deleted
    var barSel : DataBarBean? = viewModel.listBar.get(position)

    Column(verticalArrangement = Arrangement.spacedBy(8.dp),) {
        Row (modifier.weight(1F)){
            Text(
                text = "Nom : ",
                //textAlign = TextAlign.Center,
                //modifier = modifier
                 //   .fillMaxWidth()
            )
            Text(
                text = barSel?.eq_nom_equipement ?: "Inconnu",
                //textAlign = TextAlign.Center,
                //modifier = modifier
                  //  .fillMaxWidth()
            )
        }
        Row (modifier.weight(1F)){
            Text(
                text = "Téléphone : ",
                //textAlign = TextAlign.Center,
              //modifier.weight(1F)
                //    .fillMaxWidth()
            )
            Text(
                text = barSel?.eq_telephone ?: "Inconnu",
              /*  textAlign = TextAlign.Center,
                modifier = modifier
                    .fillMaxWidth()
            */)
        }
        Row (modifier.weight(1F)){
            androidx.compose.material3.Text(
                text = "Adresse : ",
                //textAlign = TextAlign.Center,
                //modifier.weight(1F)
                //    .fillMaxWidth()
            )
            androidx.compose.material3.Text(
                text = barSel?.let { adresse(it) } ?: "Adresse inconnue"
                /*  textAlign = TextAlign.Center,
                  modifier = modifier
                      .fillMaxWidth()
              */
            )
        }
        Row (modifier.weight(1F)){
            androidx.compose.material3.Text(
                text = "Site web : ",
                //textAlign = TextAlign.Center,
                //modifier.weight(1F)
                //    .fillMaxWidth()
            )
            androidx.compose.material3.Text(
                text = barSel?.eq_telephone ?: "Inconnu",
                /*  textAlign = TextAlign.Center,
                  modifier = modifier
                      .fillMaxWidth()
              */
            )
        }
    }
}

// returns the adresse in one string
fun adresse (bar : DataBarBean) : String = StringBuilder()
    ?.append(bar?.numero.toString() ?: "")?.append(" ")
    ?.appendLine(bar?.lib_off ?: "")
    ?.appendLine(bar?.id_secteur_postal.toString() ?: "")
    ?.appendLine(bar?.eq_ville?: "").toString()


@Composable
fun testPurposes(viewModel: MainViewModel = androidx.lifecycle.viewmodel.compose.viewModel()){
    StrictMode // To be deleted allows to force request thread
        .setThreadPolicy(StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build())
    viewModel.loadDataVM()
}