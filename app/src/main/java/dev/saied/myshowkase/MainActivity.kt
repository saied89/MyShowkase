package dev.saied.myshowkase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat.startActivity
import com.airbnb.android.showkase.models.Showkase
import dev.saied.lib.SpecialButton
import dev.saied.lib.getBrowserIntent
import dev.saied.myshowkase.ui.theme.MyShowkaseTheme
import kotlin.concurrent.thread

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyShowkaseTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Text(
        text = "Hello $name!",
        modifier = modifier.clickable {
            context.startActivity(Showkase.getBrowserIntent(context = context))
        }
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyShowkaseTheme {
        Greeting("Android")
    }
}