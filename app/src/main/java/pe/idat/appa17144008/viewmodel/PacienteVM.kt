package pe.idat.appa17144008.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pe.idat.appa17144008.data.local.EntityPaciente
import pe.idat.appa17144008.data.repository.PacienteRepositorio
import pe.idat.appa17144008.data.repository.Repositorio
import javax.inject.Inject

@HiltViewModel
class PacienteVM @Inject constructor(private val repositorio: PacienteRepositorio
) : ViewModel() {

    // Variable para almacenar el resultado del login
    private val _loginResult = MutableLiveData<Boolean>()
    val loginResult: LiveData<Boolean> = _loginResult

    // Función para manejar el login del paciente
    fun login(codpaciente: String, password: String) {
        viewModelScope.launch {
            val paciente = repositorio.obtenerPaciente(codpaciente, password)
            _loginResult.value = paciente != null
        }
    }

    // Función para insertar un paciente en la base de datos
    fun insertarPaciente(paciente: EntityPaciente) {
        viewModelScope.launch {
            repositorio.insertar(paciente)
        }
    }
}