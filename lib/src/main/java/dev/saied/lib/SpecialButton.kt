package dev.saied.lib

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.android.showkase.annotation.ShowkaseComposable
import com.airbnb.android.showkase.models.Showkase

@Composable
fun SpecialButton(color: Color) {
    val context = LocalContext.current
    Button(colors = ButtonDefaults.buttonColors(containerColor = color), onClick = {
        context.startActivity(Showkase.getBrowserIntent(context))
    }) {
        Text("test")
    }
}

@ShowkaseComposable
@Preview
@Composable
fun SpecialButtonPreview(color: Color = Color.Magenta) {
    SpecialButton(color)
}