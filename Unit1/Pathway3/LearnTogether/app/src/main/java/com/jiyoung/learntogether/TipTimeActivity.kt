package com.jiyoung.learntogether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jiyoung.learntogether.ui.theme.LearnTogetherTheme
import java.text.NumberFormat

class TipTimeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnTogetherTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    TipTimeLayout()
                }
            }
        }
    }
}

// 상태 호이스팅을 위해 매개변수를 추가함
// amountInput 상태를 EditNumberField()에서 TipTimeLayout() 컴포저블로 호이스팅함
@Composable
fun EditNumberField(
    @StringRes label: Int,
    @DrawableRes leadingIcon: Int,
    keyboardOptions: KeyboardOptions,
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
) {
    /*
    사용자가 텍스트 상자에 텍스트를 입력하면 onValueChange 콜백이 호출되고
    amountInput 변수가 새 값으로 업데이트됨
     */
    TextField(
        value = value,
        leadingIcon = { Icon(painter = painterResource(id = leadingIcon), null) },
        onValueChange = onValueChange, // 사용자가 텍스트 상자에 텍스트를 입력할 때 트리거되는 람다 콜백
        singleLine = true,
        label = { Text(stringResource(label)) },
        keyboardOptions = keyboardOptions,
        modifier = modifier,
    )
}

@Composable
fun RoundTheTipRow(
    roundUp: Boolean,
    onRoundUpChanged: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .size(48.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(text = stringResource(R.string.round_up_tip))
        Switch(
            checked = roundUp,
            onCheckedChange = onRoundUpChanged,
            modifier = modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.End),
        )
    }
}

private fun calculateTip(amount: Double, tipPercent: Double = 15.0, roundUp: Boolean): String {
    var tip = tipPercent / 100 * amount
    if (roundUp) {
        tip = kotlin.math.ceil(tip) // 정수값을 반올림해줌
    }
    return NumberFormat.getCurrencyInstance().format(tip)
}

@Composable
fun TipTimeLayout() {
    var amountInput by remember { mutableStateOf("") }
    var tipInput by remember { mutableStateOf("") }
    var roundUp by remember { mutableStateOf(false) }

    val amount = amountInput.toDoubleOrNull() ?: 0.0
    val tipPercent = tipInput.toDoubleOrNull() ?: 0.0
    val tip = calculateTip(amount, tipPercent, roundUp)

    Column(
        modifier = Modifier.padding(40.dp).verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text("calculate Tip")
        /*
        EditNumberField -> Stateless 상태
         */
        EditNumberField(
            label = R.string.bill_amount,
            value = amountInput,
            leadingIcon = R.drawable.ic_money,
            onValueChange = { amountInput = it },
            modifier = Modifier.padding(bottom = 32.dp).fillMaxWidth(),
            // 키보드 다음 버튼으로 실행하게 함
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next,
            ),
        )
        EditNumberField(
            label = R.string.how_was_the_service,
            value = tipInput,
            onValueChange = { tipInput = it },
            leadingIcon = R.drawable.ic_money,
            modifier = Modifier.padding(bottom = 32.dp).fillMaxWidth(),
            // 키보드 완료 버튼으로 실행하게 함
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done,
            ),
        )
        RoundTheTipRow(
            roundUp = roundUp,
            onRoundUpChanged = { roundUp = it },
            modifier = Modifier.padding(bottom = 32.dp),
        )
        Text(stringResource(R.string.tip_amount, tip))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview5() {
    LearnTogetherTheme {
        TipTimeLayout()
    }
}
