package pe.idat.appa17144008.data.repository

import pe.idat.appa17144008.data.network.response.Imagen
import pe.idat.appa17144008.data.network.response.Paciente
import pe.idat.appa17144008.data.network.servicio.Servicio
import javax.inject.Inject

class Repositorio @Inject constructor(private val servicio: Servicio){
    suspend fun getPacientes(): List<Paciente> {
        return servicio.getPacientes()
    }
    suspend fun obternerImagenes(): List<Imagen> {
        return servicio.getImagenes().filter { it.albumId % 2 == 0 }
    }
}