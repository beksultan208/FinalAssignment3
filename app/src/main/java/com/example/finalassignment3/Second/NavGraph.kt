package com.example.finalassignment3.Second

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.assignment3.model.Type
import com.example.assignment3.network.RetrofitInstance
import com.example.assignment3.view.MovieViewModel

import com.example.finalassignment3.ThridTask.Details
import com.example.finalassignment3.ThridTask.ThirdScreen
import com.example.finalassignment3.realThirdTask.view.MovieCollectionRow
import com.example.finalassignment3.realThirdTask.view.MoviesByCollectionScreen

@Composable
fun NavGraph(
    navHostController: NavHostController
) {
    val viewModel: MovieViewModel = remember { MovieViewModel(RetrofitInstance.api) }
    NavHost(navController = navHostController, startDestination = "MovieScreen"){
        composable("MovieScreen") { MovieScreen(viewModel, navHostController) }
        composable("MoviesByCollectionScreen/{collectionType}/{collectionTypes}") { backStackEntry ->
            val collectionType = backStackEntry.arguments?.getString("collectionType") ?: ""
            val collectionTypes = backStackEntry.arguments?.getString("collectionTypes") ?: ""
            MoviesByCollectionScreen(collectionTypes, viewModel, collectionType, navHostController)
        }
        composable("screen_2") {
            Screen2()
        }
        composable("screen_3") {
            Screen3()
        }
        composable("NewScreen3"){
            Details()
        }
    }
}
@Composable
fun MovieScreen(viewModel: MovieViewModel, navController: NavController) {
    val collectionTypes = listOf(
        Type(type="TOP_POPULAR_ALL"),
        Type(type="TOP_POPULAR_MOVIES"),
        Type(type="TOP_250_MOVIES"),
        Type(type="TOP_250_TV_SHOWS"),
        Type(type="VAMPIRE_THEME"),
        Type(type="COMICS_THEME")
    )
    val collectionTypess = listOf(
        Type(type="Популярное"),
        Type(type="Популярные фильмы"),
        Type(type="Топ 250 фильмов"),
        Type(type="Топ 250 сериалов"),
        Type(type="Фильмы про вампиров"),
        Type(type="Фильмы про комиксы")
    )


    LazyColumn(verticalArrangement = Arrangement.spacedBy(36.12.dp) , modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(top = 97.dp)) {
        item {
            Image(painter = painterResource(id = com.example.finalassignment3.R.drawable.vector__1_), contentDescription = null, modifier = Modifier.padding(start = 26.dp))
            //Text(text = "Skillcinema", style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold))
        }
        for (index in collectionTypes.indices) {

            item() {
                MovieCollectionRow(
                    title = collectionTypess[index].type,collectionType= collectionTypes[index].type, viewModel=viewModel,
                    onSeeAllClick = { navController.navigate("MoviesByCollectionScreen/"+collectionTypes[index].type+"/"+collectionTypess[index].type) },
                    navController)

            }}
    }
}




@Composable
fun Screen2(){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        Text(text="Screen 2")}}
@Composable
fun Screen3(){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        Text(text="Screen 3")}}



