package com.jiyoung.learntogether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jiyoung.learntogether.ui.theme.LearnTogetherTheme

class ArtSpaceActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnTogetherTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    GalleryLayout()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview6() {
    LearnTogetherTheme {
        GalleryLayout()
    }
}

@Composable
fun GalleryLayout(modifier: Modifier = Modifier) {
    var currentStep by remember { mutableStateOf(1) }
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        when (currentStep) {
            1 -> {
                Column(modifier = Modifier) {
                    ArtImage(R.drawable.img_art1)
                    Spacer(modifier = Modifier.height(10.dp))
                    ArtContent("1번", "1번작가")
                }
            }
            2 -> {
                Column(modifier = Modifier) {
                    ArtImage(R.drawable.img_art2)
                    Spacer(modifier = Modifier.height(10.dp))
                    ArtContent("2번", "2번작가")
                }
            }
            else -> {
                Column(modifier = Modifier) {
                    ArtImage(R.drawable.img_art3)
                    Spacer(modifier = Modifier.height(10.dp))
                    ArtContent("3번", "3번작가")
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = Modifier) {
            Button(onClick = { currentStep-- }) {
                Text("BACK")
            }
            Spacer(modifier = Modifier.width(20.dp))
            Button(onClick = { currentStep++ }) {
                Text("NEXT")
            }
        }
    }
}

@Composable
fun ArtContent(title: String, author: String) {
    Surface(
        modifier = Modifier
            .background(Color.LightGray)
            .padding(20.dp),
    ) {
        Column(
            modifier = Modifier.background(Color.LightGray),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = title, color = Color.White)
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = author, color = Color.White)
        }
    }
}

@Composable
fun ArtImage(
    @DrawableRes image: Int,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Surface(
            modifier = Modifier
                .shadow(10.dp) // 이거 shadow보다 border를 먼저 적으면 이미지 근처로 그림자 생김;; 뭐지
                .padding(20.dp),
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(200.dp),
            )
        }
    }
}
