package com.jiyoung.learntogether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jiyoung.learntogether.ui.theme.LearnTogetherTheme

class QuadrantActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnTogetherTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    ShowQuadrant()
                }
            }
        }
    }
}

// TODO 근데 왜 각 카드 텍스트 높이가 다르지?
@Composable
fun QuadrantCard(title: String, content: String, color: Long, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize().background(Color(color)).padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp),
        )
        Text(text = content, textAlign = TextAlign.Justify)
    }
}

/*
@Composable
fun ShowQuadrant(
    firstTitle: String,
    firstContent: String,
    secondTitle: String,
    secondContent: String,
    thirdTitle: String,
    thirdContent: String,
    fourthTitle: String,
    fourthContent: String,
) {
    Column(modifier = Modifier) {
        Row {
            QuadrantCard(firstTitle, firstContent, 0xFFEADDFF)
            QuadrantCard(secondTitle, secondContent, 0xFFD0BCFF)
        }
        Row {
            QuadrantCard(thirdTitle, thirdContent, 0xFFB69DF8)
            QuadrantCard(fourthTitle, fourthContent, 0xFFF6EDFF)
        }
    }
}
 */
@Composable
fun ShowQuadrant() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
            // Row(Modifier.weight(1f)) : Row 내에서 동등한 비율로 나눠가짐
            QuadrantCard(
                stringResource(R.string.quadrant_first_title),
                stringResource(R.string.quadrant_first_content),
                0xFFEADDFF,
                modifier = Modifier.weight(1f),
            )
            QuadrantCard(
                stringResource(R.string.quadrant_second_title),
                stringResource(R.string.quadrant_second_content),
                0xFFD0BCFF,
                modifier = Modifier.weight(1f),
            )
        }
        Row(Modifier.weight(1f)) {
            QuadrantCard(
                stringResource(R.string.quadrant_third_title),
                stringResource(R.string.quadrant_third_content),
                0xFFB69DF8,
                modifier = Modifier.weight(1f),
            )
            QuadrantCard(
                stringResource(R.string.quadrant_fourth_title),
                stringResource(R.string.quadrant_fourth_content),
                0xFFF6EDFF,
                modifier = Modifier.weight(1f),
            )
        }
    }
}

// 여기서 Column으로 묶는건 별로인가?
@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    LearnTogetherTheme {
        ShowQuadrant()
    }
}
