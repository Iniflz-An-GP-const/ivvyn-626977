package gnscinternational.ivvyn.digital

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import gnscinternational.ivvyn.digital.ui.composable.approot.AppRoot
import gnscinternational.ivvyn.digital.ui.theme.GENNLAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GENNLAppTheme {
                AppRoot()
            }
        }
    }
}
