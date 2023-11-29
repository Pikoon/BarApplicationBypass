package com.example.barapplication.ui.screens

import android.os.StrictMode
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.barapplication.files.DataBarBean
import com.example.barapplication.files.MainViewModel
import com.example.barapplication.ui.theme.BarApplicationTheme

@Preview (showBackground= true)
@Composable
fun WelcomeScreenPreview() {
    BarApplicationTheme {
        Surface(modifier = Modifier.fillMaxWidth(), color = Color.LightGray) {
            WelcomeScreen()
        }
    }
}

@Composable
fun WelcomeScreen(modifier: Modifier = Modifier,
                  viewModel: MainViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
    ) {
    StrictMode // To be deleted
       .setThreadPolicy(StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build())
    viewModel.loadDataVM()
    Column(modifier) {
        Text(
            text = viewModel.listBar.get(1)?.eq_nom_equipement ?: "Inconnu",
            textAlign = TextAlign.Center,
            modifier = modifier
                .fillMaxWidth())
        Text(
            text = viewModel.listBar.get(1)?.eq_telephone ?: "Tel Inconnu",
            textAlign = TextAlign.Center,
            modifier = modifier
                .fillMaxWidth())
    }

    /*Button(
        onClick = {
            viewModel.loadDataVM()
        },
        contentPadding = ButtonDefaults.ButtonWithIconContentPadding,
        //modifier = Modifier.align(Alignment.CenterHorizontally)
    ) {
        Icon(
            Icons.Filled.Search,
            contentDescription = "Localized description",
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text("Load")
    }*/
}
@Composable
fun showText(test : DataBarBean){
    Text(text = "test.eq_nom_equipement")
}
