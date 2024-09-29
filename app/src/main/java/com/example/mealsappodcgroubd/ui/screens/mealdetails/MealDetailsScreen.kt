package com.example.mealsappodcgroubd.ui.screens.mainscreen
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
@Composable
fun MealDetailsScreen(viewModel: MealDetailsViewModel = hiltViewModel()) {
    val category by viewModel.category.collectAsState()
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 20.dp, vertical = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(0.dp,
        Alignment.CenterVertically)){
        AsyncImage(
            model =category.strCategoryThumb ,
            contentDescription ="Category Meal",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(250.dp)
                .clip(RectangleShape)
                .border(2.5.dp, Color.Red, RectangleShape)
        )
        Text(text = category.strCategory ?: "", textAlign = TextAlign.Center, fontStyle = androidx.compose.ui.text.font.FontStyle.Italic, fontSize = 30.sp, fontWeight = FontWeight.W900)
        Spacer(modifier = Modifier.height(20.dp))
        Text(category.strCategoryDescription?:"",textAlign = TextAlign.Center, fontStyle = androidx.compose.ui.text.font.FontStyle.Normal, fontSize = 15.sp, fontWeight = FontWeight.ExtraBold)
    }
}