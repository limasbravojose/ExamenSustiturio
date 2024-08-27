package pe.idat.appa17144008.iu


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import pe.idat.appa17144008.data.network.response.ItemMenu
import pe.idat.appa17144008.rutas.Rutas

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaPrincipal(controladorNavegacion: NavHostController) {  // Cambia a NavHostController
    val estadoDrawer = rememberDrawerState(initialValue = DrawerValue.Closed)
    val alcanceCorrutina = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = estadoDrawer,
        drawerContent = {
            ContenidoDrawer(items = opcionesMenu(), onItemClick = { item ->
                alcanceCorrutina.launch {
                    estadoDrawer.close()
                }
                when (item.titulo) {
                    "Primera Opción" -> controladorNavegacion.navigate(Rutas.TodoList.ruta)
                    "Segunda Opción" -> controladorNavegacion.navigate(Rutas.PhotoList.ruta)
                }
            })
        },
        content = {
            Column {
                TopAppBar(
                    title = { Text(text = "Mi Aplicación") },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.White,
                        titleContentColor = Color.Black
                    ),
                    navigationIcon = {
                        IconButton(onClick = {
                            alcanceCorrutina.launch {
                                estadoDrawer.open()
                            }
                        }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                    }
                )

                NavHost(navController = controladorNavegacion, startDestination = Rutas.Home.ruta) {
                    composable(Rutas.Home.ruta) {
                        Text("Bienvenido a la Pantalla Principal")
                    }
                    composable(Rutas.TodoList.ruta) {
                        ListScreen()
                    }
                    composable(Rutas.PhotoList.ruta) {
                        ImageScreen()
                    }
                }
            }
        }
    )
}
@Composable
fun ContenidoDrawer(items: List<ItemMenu>, onItemClick: (ItemMenu) -> Unit){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        .systemBarsPadding()) {
        items.forEach { item ->
            ElementoMenuDrawer(item = item, onItemClick = onItemClick)
        }
    }
}

@Composable
fun ElementoMenuDrawer(
    item: ItemMenu,
    onItemClick: (ItemMenu) -> Unit
){
    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable { onItemClick(item) }
        .padding(16.dp), verticalAlignment = Alignment.CenterVertically){
        Text(text = item.titulo)
    }
}

fun opcionesMenu(): List<ItemMenu> {
    return listOf(
        ItemMenu("Primera Opción"),
        ItemMenu("Segunda Opción")
    )
}
