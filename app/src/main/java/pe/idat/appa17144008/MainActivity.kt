package pe.idat.appa17144008

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import pe.idat.appa17144008.iu.PantallaLogin
import pe.idat.appa17144008.iu.PantallaPrincipal
import pe.idat.appa17144008.rutas.Rutas
import pe.idat.appa17144008.ui.theme.AppA17144008Theme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppA17144008Theme {

                val navController = rememberNavController()


                NavHost(navController = navController, startDestination = Rutas.Login.ruta) {
                    composable(Rutas.Login.ruta) {
                        PantallaLogin(controladorNavegacion = navController)
                    }
                    composable(Rutas.Home.ruta) {
                        PantallaPrincipal(controladorNavegacion = navController)
                    }
                }
            }
        }
    }
}
