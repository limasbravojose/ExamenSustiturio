package pe.idat.appa17144008.data.repository

import pe.idat.appa17144008.data.local.EntityPaciente
import pe.idat.appa17144008.data.local.PacienteDao
import javax.inject.Inject

class PacienteRepositorio @Inject constructor(
    private val pacienteDao: PacienteDao
) {
    suspend fun insertar(paciente: EntityPaciente) {
        pacienteDao.insertar(paciente)
    }

    suspend fun obtenerPaciente(codpaciente: String, password: String): EntityPaciente? {
        return pacienteDao.ObtenerPaciente(codpaciente, password)
    }
}