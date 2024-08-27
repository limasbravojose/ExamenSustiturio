package pe.idat.appa17144008.iu


import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import pe.idat.appa17144008.data.local.EntityPaciente
import pe.idat.appa17144008.viewmodel.PacienteVM

// Definición de variables fuera del composable
val listaPacientes = listOf(
    EntityPaciente("101", "pass123", "Carlos Ramírez", "987654321"),
    EntityPaciente("102", "abc456", "María López", "876543210"),
    EntityPaciente("103", "xyz789", "Fernando Castillo", "765432109")
)

val espacioPadding = Modifier.padding(20.dp)

@Composable
fun PantallaLogin(
    modeloVista: PacienteVM = hiltViewModel(),
    controladorNavegacion: NavController,
    listaUsuarios: List<EntityPaciente> = listaPacientes // Usando la lista por defecto si no se pasa otra
) {
    var codigoPaciente by remember { mutableStateOf("") }
    var contrasena by remember { mutableStateOf("") }
    val contexto = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = codigoPaciente,
            onValueChange = { codigoPaciente = it },
            label = { Text("Código de Usuario") },
            modifier = espacioPadding
        )
        TextField(
            value = contrasena,
            onValueChange = { contrasena = it },
            label = { Text("Contraseña") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = espacioPadding
        )
        Button(
            onClick = {
                val usuario = listaUsuarios.find { it.codpaciente == codigoPaciente && it.password == contrasena }
                if (usuario != null) {
                    modeloVista.insertarPaciente(usuario)
                    Toast.makeText(contexto, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
                    controladorNavegacion.navigate("home") // Navega a la pantalla Home
                } else {
                    Toast.makeText(contexto, "Datos incorrectos", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = espacioPadding
        ) {
            Text("Ingresar")
        }
    }
}
