package com.example.barapplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.barapplication.R
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
    Column(modifier) {
        Image( painter= painterResource(R.drawable.cheers),
            contentDescription = "Fiesta",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.5F)
        )
        Spacer(Modifier.size(8.dp))
        Text(
            text = "Liste des cafés concerts de Toulouse",
            textAlign = TextAlign.Center,
            modifier = modifier
                .fillMaxWidth()
        )
        Spacer(Modifier.size(8.dp))
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(viewModel.listBar.size) {
                Text(
                    text = viewModel.listBar[it].eq_nom_equipement,
                    textAlign = TextAlign.Center,
                    modifier = modifier
                        .fillMaxWidth().weight(1.5F)
                        .clickable {
                            viewModel.listBar[it].eq_telephone
                        }
                )
          //      Spacer(Modifier.size(5.dp))
            }
        }
        Spacer(Modifier.size(8.dp))
        Button(
            onClick = {
                viewModel.loadDataVM()
            },
            contentPadding = ButtonDefaults.ButtonWithIconContentPadding,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Icon(
                Icons.Filled.Search,
                contentDescription = "Localized description",
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
            Text("Charger liste de bars")
        }
    }
}
