package com.example.finalassignment3


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.finalassignment3.Second.Main_Screen
import com.example.finalassignment3.ThridTask.Details


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NavigationClass() {
    val navController = rememberNavController()

    androidx.compose.material3.Scaffold(
        content = {
            NavHost(
                navController = navController,
                startDestination = "pagerScreen"
            ) {
                composable("pagerScreen") {
                    ScreenPager(navController)
                }
                composable("newScreen") {
                    Main_Screen()
                }
                composable(route = "NewScreen3"){
                    Details()

                }
            }
        }
    )
}

