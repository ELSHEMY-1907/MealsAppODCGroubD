package com.example.mealsappodcgroubd.ui.screens.mainscreen
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.domain.entity.mainscreen.Category
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.net.URLDecoder
import java.nio.charset.StandardCharsets
import javax.inject.Inject

@HiltViewModel
class MealDetailsViewModel @Inject constructor(savedStateHandle: SavedStateHandle) : ViewModel() {

    private val _category = MutableStateFlow<Category>(Category())
    val category = _category.asStateFlow()
    private val argsCurrent : String? = savedStateHandle["Category"]


    init {
        argsCurrent?.let {
            // Decode the URL-encoded string
            val decodedCategoryData = URLDecoder.decode(it, StandardCharsets.UTF_8.toString())

            // Deserialize the JSON string back into a Category object
            val gson = Gson()
            val categoryData = gson.fromJson(decodedCategoryData, Category::class.java)
            _category.value = categoryData
        }


    }
}