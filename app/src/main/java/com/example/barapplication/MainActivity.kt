package com.example.barapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.barapplication.files.MainViewModel
import com.example.barapplication.ui.Routes
import com.example.barapplication.ui.screens.DetailedScreen
import com.example.barapplication.ui.screens.WelcomeScreen
import com.example.barapplication.ui.theme.BarApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BarApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController: NavHostController = rememberNavController()
    val viewModel: MainViewModel = androidx.lifecycle.viewmodel.compose.viewModel()

    NavHost(navController = navController, startDestination = Routes.firstPrez.route) {
        //Route 1 vers notre SearchScreen
        composable(Routes.firstPrez.route) {
            //on peut passer le navController à un écran s'il déclenche des navigations
            WelcomeScreen(navHostController = navController,
                viewModel = viewModel)
        }

        //Route 2 vers un écran de détail
        composable(
            route = Routes.detailedScreen.route,
            arguments = listOf(navArgument("data") { type = NavType.IntType })
        ) {
            val position = it.arguments?.getInt("data", 0) ?: 0
            DetailedScreen(
                position = position,
                navHostController = navController,
                viewModel = viewModel
            )
        }
    }
}