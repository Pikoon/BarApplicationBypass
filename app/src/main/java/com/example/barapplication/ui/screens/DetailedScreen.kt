package com.example.barapplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.barapplication.R
import com.example.barapplication.files.DataBarBean
import com.example.barapplication.files.MainViewModel
import com.example.barapplication.ui.theme.BarApplicationTheme


@Preview
@Composable
fun PreviewDetailedScreen() {
    BarApplicationTheme {
        Surface(modifier = Modifier.fillMaxWidth(), color = Color.LightGray) {
            DetailedScreen(position = 1)
        }
    }
}


@Composable
fun DetailedScreen(
    position: Int,
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    navHostController: NavHostController? = null
) {
    LaunchedEffect(Unit) {
        viewModel.loadDataVM()
    }

    val barSel: DataBarBean? = viewModel.listBar.getOrNull(position)

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.DarkGray) // Set your preferred background color
    ) {
        // Header Image and Back Button
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp) // Set your preferred image height
                .clip(shape = RoundedCornerShape(8.dp)) // Add rounded corners to the image
        ) {
            Image(
                painter = painterResource(R.drawable.dark),
                contentDescription = "Cafe",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            IconButton(
                onClick = { navHostController?.popBackStack() },
                modifier = Modifier
                    .padding(16.dp)
                    .clip(CircleShape)
            ) {
                Icon(
                    imageVector = Icons.Rounded.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                        .background(Color.Black.copy(alpha = 0.5f))
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Display Information
        Info("Nom", barSel?.eq_nom_equipement ?: "Inconnu")
        Info("Téléphone", barSel?.eq_telephone ?: "Inconnu")
        Info("Adresse", barSel?.let { adresse(it) } ?: "Adresse inconnue")
        Info("Site web", barSel?.eq_site_web ?: "Inconnu")
    }
}

@Composable
fun Info(label: String, value: Any) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            fontWeight = FontWeight.Bold,
            color = Color.White, // Set your preferred text color
            fontSize = 16.sp,
            modifier = Modifier.weight(1f)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = value.toString(),
            fontSize = 16.sp,
            color = Color.White, // Set your preferred text color
            modifier = Modifier.weight(2f)
        )
    }
}

// returns the adresse in one string
fun adresse (bar : DataBarBean) : String = StringBuilder()
    .append(bar?.numero ?: "").append(" ")
    .appendLine(bar?.lib_off ?: "")
    .appendLine(bar?.id_secteur_postal ?: "")
    .appendLine(bar?.eq_ville ?: "").toString()
