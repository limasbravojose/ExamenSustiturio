package pe.idat.appa17144008.data.network.servicio

import pe.idat.appa17144008.data.network.response.Imagen
import pe.idat.appa17144008.data.network.response.Paciente
import pe.idat.appa17144008.data.network.retrofitCliente.RCliente
import javax.inject.Inject

class Servicio @Inject constructor(private val rCliente: RCliente) {
    suspend fun getPacientes(): List<Paciente> {
        return rCliente.getPacientes()
    }
    suspend fun getImagenes(): List<Imagen> {
        return rCliente.getImagenes()
    }
}