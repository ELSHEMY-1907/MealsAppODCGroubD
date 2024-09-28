package com.example.mealsappodcgroubd

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mealsappodcgroubd.ui.screens.mainscreen.MainScreen
import com.example.mealsappodcgroubd.ui.screens.mainscreen.MealDetailsScreen
import com.example.mealsappodcgroubd.ui.theme.MealsAppODCGroubDTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MealsAppODCGroubDTheme {
                MealsAppCompose()

            }
        }
    }
}
@Composable
fun MealsAppCompose() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(Screen.MainScreen.route) { MainScreen(navController) }
        composable(
            "${Screen.MealDetailsScreen.route}/{Category}",
            arguments = listOf(navArgument("mealName") { type = NavType.StringType })
        ) { MealDetailsScreen()}
        }
}


