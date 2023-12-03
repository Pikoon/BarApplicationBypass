package com.example.barapplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.barapplication.R
import com.example.barapplication.files.MainViewModel
import com.example.barapplication.ui.Routes
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
/*@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = viewModel(),
    navHostController: NavHostController? = null
) {
    Column(modifier) {

        // Header Image
        Image(
            painter = painterResource(R.drawable.cheers),
            contentDescription = "Fiesta",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.5F)
        )

        Spacer(Modifier.size(8.dp))

        // Title
        Text(
            text = "Liste des cafés concerts de Toulouse",
            textAlign = TextAlign.Center,
            modifier = modifier
                .fillMaxWidth()
        )

        Spacer(Modifier.size(8.dp))

        // Café Names List
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(viewModel.listBar.size) { index ->
                val caféName = viewModel.listBar[index].eq_nom_equipement
                Text(
                    text = caféName,
                    textAlign = TextAlign.Center,
                    modifier = modifier
                        .fillMaxWidth()
                        .weight(1.5F)
                        .clickable(onClick = {
                            navHostController?.navigate(Routes.detailedScreen.addParam(index))
                        })
                )
            }
        }

        Spacer(Modifier.size(8.dp))

        // Load Data Button
        Button(
            onClick = { viewModel.loadDataVM() },
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
}*/

@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    navHostController: NavHostController? = null
) {
    // Background Color
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.DarkGray)
            .padding(16.dp)
    ) {

        // Header Image
        Image(
            painter = painterResource(R.drawable.cheers),
            contentDescription = "Fiesta",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.75F)
                .clip(shape = RoundedCornerShape(8.dp))
        )

        Spacer(Modifier.size(16.dp))

        // Title
        Text(
            text = "Liste des cafés concerts de Toulouse",
            textAlign = TextAlign.Center,
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.White
            )
        )

        Spacer(Modifier.size(16.dp))

        // Liste des cafes
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            items(viewModel.listBar.size) { index ->
                val bar = viewModel.listBar[index].eq_nom_equipement
                Text(
                    text = bar,
                    textAlign = TextAlign.Center,
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable(onClick = {
                            navHostController?.navigate(Routes.detailedScreen.addParam(index))
                        }),
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = Color.White
                    )
                )
            }
        }

        Spacer(Modifier.size(16.dp))

        // Bouton chargement
        Button(
            onClick = { viewModel.loadDataVM() },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White
            )
        ) {
            Icon(
                Icons.Filled.Search,
                contentDescription = "Localized description",
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
            Text(
                "Charger liste de bars",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}