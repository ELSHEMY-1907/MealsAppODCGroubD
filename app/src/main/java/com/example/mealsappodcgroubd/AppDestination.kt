package com.example.mealsappodcgroubd

sealed class Screen(val route: String){
    object MainScreen : Screen("mainScreen")
    object MealDetailsScreen : Screen("mealDetailsScreen")
}