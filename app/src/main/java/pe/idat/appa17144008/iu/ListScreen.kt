package pe.idat.appa17144008.iu


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import pe.idat.appa17144008.viewmodel.SetupViewModel

@Composable
fun ListScreen(viewModel: SetupViewModel = hiltViewModel()) {
    val pacientes by viewModel.pacientes.observeAsState(initial = emptyList())

    LaunchedEffect(Unit) {
        viewModel.fetchPacientes()
    }

    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        items(pacientes) { paciente ->
            Text(text = "${paciente.id}: ${paciente.title} (Completed: ${paciente.completed})")
        }
    }
}
