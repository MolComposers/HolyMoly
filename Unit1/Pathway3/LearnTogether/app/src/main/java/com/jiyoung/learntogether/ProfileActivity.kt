package com.jiyoung.learntogether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jiyoung.learntogether.ui.theme.LearnTogetherTheme

class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnTogetherTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    MyProfile()
                }
            }
        }
    }
}

@Composable
fun ProfileCard(name: String, title: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val image = painterResource(R.drawable.profile_img)
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .border(2.dp, Color.Gray, CircleShape),
        )
        Text(text = name)
        Text(text = title)
    }
}

@Composable
fun InfoCard(modifier: Modifier = Modifier) {
    val space = 10.dp
    val iconColor = Color.Blue
    Column(
        modifier = modifier.padding(horizontal = 80.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
        ) {
            Icon(imageVector = Icons.Default.Email, contentDescription = null, tint = iconColor)
            Spacer(Modifier.size(space))
            Text(text = "crayon0820@naver.com")
        }
        Spacer(Modifier.size(space))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
        ) {
            Icon(imageVector = Icons.Default.Phone, contentDescription = null, tint = iconColor)
            Spacer(Modifier.size(space))
            Text(text = "000-0000-0000")
        }
        Spacer(Modifier.size(space))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
        ) {
            Icon(imageVector = Icons.Default.Person, contentDescription = null, tint = iconColor)
            Spacer(Modifier.size(space))
            Text(text = "zzi.__.0")
        }
    }
}

@Composable
fun MyProfile() {
    Column {
        ProfileCard("Jiyoung", "Android Developer", modifier = Modifier.weight(1f))
        InfoCard(modifier = Modifier.weight(1f))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    LearnTogetherTheme {
        MyProfile()
    }
}
