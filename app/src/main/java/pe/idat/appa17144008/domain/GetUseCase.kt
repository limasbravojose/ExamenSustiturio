package pe.idat.appa17144008.domain

import pe.idat.appa17144008.data.network.response.Imagen
import pe.idat.appa17144008.data.network.response.Paciente
import pe.idat.appa17144008.data.repository.Repositorio
import javax.inject.Inject

class GetUseCase @Inject constructor(private val repositorio: Repositorio) {
    suspend fun getPaciente(): List<Paciente> {
        return repositorio.getPacientes()
    }

    suspend fun obtenerImagen(): List<Imagen> {
        return repositorio.obternerImagenes()
    }
}