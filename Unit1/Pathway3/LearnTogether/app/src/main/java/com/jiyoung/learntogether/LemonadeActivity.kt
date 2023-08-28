package com.jiyoung.learntogether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jiyoung.learntogether.ui.theme.LearnTogetherTheme

class LemonadeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnTogetherTheme {
                ShowLemonApp()
            }
        }
    }
}

@Composable
fun ShowLemonCard() {
    var requiredTapResult by remember { mutableStateOf(2) }
    var step by remember {
        mutableStateOf(1)
    }
    val imageResource = when (step) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    val randomContent = when (step) {
        1 -> R.string.lemonade_1
        2 -> R.string.lemonade_2
        3 -> R.string.lemonade_3
        else -> R.string.lemonade_4
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        when (step) {
            1 -> {
                Image(
                    painter = painterResource(id = imageResource),
                    contentDescription = requiredTapResult.toString(),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Gray)
                        .clickable {
                            step = 2
                            requiredTapResult = (2..4).random()
                        },
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(stringResource(id = randomContent))
            }
            2 -> {
                Image(
                    painter = painterResource(id = imageResource),
                    contentDescription = requiredTapResult.toString(),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Gray)
                        .clickable {
                            requiredTapResult--
                            if (requiredTapResult == 0) {
                                step = 3
                            }
                        },
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(stringResource(id = randomContent))
            }
            3 -> {
                Image(
                    painter = painterResource(id = imageResource),
                    contentDescription = requiredTapResult.toString(),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Gray)
                        .clickable {
                            step = 4
                        },
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(stringResource(id = randomContent))
            }
            else -> {
                Image(
                    painter = painterResource(id = imageResource),
                    contentDescription = requiredTapResult.toString(),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Gray)
                        .clickable {
                            step = 1
                        },
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(stringResource(id = randomContent))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowLemonApp() {
    LearnTogetherTheme {
        ShowLemonCard()
    }
}
