package com.example.mealsappodcgroubd.ui.screens.mainscreen

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.mainscreen.Category
import com.example.domain.entity.mainscreen.MealModelItems
import com.example.domain.usecase.mainscreen.GetMealsFromRemote
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.net.URLDecoder
import java.nio.charset.StandardCharsets
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getMealsFromRemote: GetMealsFromRemote) : ViewModel() {

    private val _meals = MutableStateFlow<MealModelItems>(MealModelItems(emptyList()))
    val meals = _meals.asStateFlow()
    init {
        getMeals()

        }
    private fun getMeals() {
        viewModelScope.launch {
            try {
                _meals.value=getMealsFromRemote()

            }
            catch (e:Exception){
                if (e is HttpException){
                    Log.d(TAG, "HttpException: ${e.message()}")
                }
                else
                    Log.d(TAG, "Exception: ${e.message}")
            }
        }
    }

}