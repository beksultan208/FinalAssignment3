package com.example.finalassignment3
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.assignment3.model.Type
import com.example.assignment3.view.MovieViewModel
import com.example.finalassignment3.realThirdTask.view.MovieCollectionRow
import androidx.compose.ui.text.TextStyle as TextStyle1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NavigationClass()
        }
    }
}


@Composable
fun MainScreen(navController: NavController, doText: Int, imagename: Int, des: String) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Row(
            modifier = Modifier
                .padding(top = 80.dp, start = 26.dp)
                .width(308.dp)
                .height(18.24.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier
                    .width(120.dp)
                    .height(18.24.dp)
                    .fillMaxSize(), horizontalArrangement = Arrangement.Start
            ) {
                Image(
                    painter = painterResource(R.drawable.vector__1_),
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize()
                )

            }
            Image(
                painter = painterResource(id = R.drawable.frame_7299),
                contentDescription = "",
                modifier = Modifier
                    .padding(start = 99.dp)
                    .fillMaxSize()
                    .clickable {
                        navController.navigate("newScreen")
                    }
            )
        }

        Row(
            modifier = Modifier
                .padding(top = 166.76.dp)
                .fillMaxWidth()
                .height(270.dp)
        ) {
            Image(
                painter = painterResource(id = imagename),
                contentDescription = "",
                modifier = Modifier.fillMaxSize()
            )


        }
        Row(
            modifier = Modifier
                .padding(top = 67.24.dp, start = 26.dp)
                .width(201.dp)
                .height(70.dp)
        ) {
            Image(
                painter = painterResource(id = doText),
                contentDescription = "",
                modifier = Modifier.fillMaxSize()
            )

        }

    }


}



