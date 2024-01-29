package dev.saied.lib

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.android.showkase.annotation.ShowkaseComposable
import com.airbnb.android.showkase.models.Showkase

@Composable
fun SpecialButton(number: Int) {
    Button(onClick = {}) {
        Text("test $number")
    }
}

@ShowkaseComposable
@Preview
@Composable
fun SpecialButtonPreview(number: Int = 5) {
    SpecialButton(number)
}

sealed class PreviewParameter {
    data class IntPreviewParameter(val defaultVal: Int, val rangeFrom: Int, val rangeTo: Int)
}

@Composable
fun PreviewSettingsOverlay(parameters: List<PreviewParameter>, onValueUpdate: (List<Any>) -> Unit) {

}

// To be generated
@Composable
fun Example() {
    var number: Int by remember {
        mutableIntStateOf(0)
    }
    SpecialButtonPreview(number)

}
