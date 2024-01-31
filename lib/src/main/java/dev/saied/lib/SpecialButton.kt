package dev.saied.lib

import android.app.Dialog
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.android.showkase.annotation.ShowkaseComposable
import dev.saied.annotations.NumberParameter

@Composable
fun SpecialButton(number: Int) {
    Button(onClick = {}) {
        Text("test $number")
    }
}

@Preview
@Composable
fun SpecialButtonPreview(
    @NumberParameter(
        defaultValue = 6,
        rangeFrom = 0,
        rangeTo = 10
    ) number: Int = 5
) {
    SpecialButton(number)
}

sealed class PreviewParameter {
    data class IntPreviewParameter(val defaultVal: Int = 5, val rangeFrom: Int, val rangeTo: Int) :
        PreviewParameter()
}

@Composable
fun PreviewSettingsOverlay(
    parameters: List<PreviewParameter>,
    values: List<Any>,
    onValueUpdate: (List<Any>) -> Unit
) {
    Column {
        parameters.forEachIndexed { index, previewParameter ->
            when (previewParameter) {
                is PreviewParameter.IntPreviewParameter -> {
                    Slider(
                        value = values[index] as Float,
                        onValueChange = { values.mutate(index, it) }
                    )
                }
                else -> {}
            }
        }
    }
}

fun List<Any>.mutate(index: Int, value: Any): List<Any> = toMutableList().apply {
    set(index, value)
}


// To be generated
@Composable
fun Example(parameters: List<Any>) {
    SpecialButtonPreview(
        parameters[0] as Int
    )
}
