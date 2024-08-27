package pe.idat.appa17144008.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pe.idat.appa17144008.data.network.response.Imagen
import pe.idat.appa17144008.data.network.response.Paciente
import pe.idat.appa17144008.domain.GetUseCase
import javax.inject.Inject

@HiltViewModel
class SetupViewModel @Inject constructor(private val getUseCase: GetUseCase) : ViewModel() {

    private val _pacientes = MutableLiveData<List<Paciente>>()
    val pacientes: LiveData<List<Paciente>> = _pacientes

    private val _imagenes = MutableLiveData<List<Imagen>>()
    val imagenes: LiveData<List<Imagen>> = _imagenes

    fun fetchPacientes() {
        viewModelScope.launch {
            val pacientesList = getUseCase.getPaciente()
            _pacientes.value = pacientesList
        }
    }

    fun fetchImagenes() {
        viewModelScope.launch {
            val imagenesList = getUseCase.obtenerImagen()
            _imagenes.value = imagenesList
        }
    }
}
