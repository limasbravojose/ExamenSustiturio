package pe.idat.appa17144008.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PacienteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(paciente: EntityPaciente)

    @Query("SELECT * FROM pacientes WHERE codpaciente = :codpaciente AND password = :password LIMIT 1")
    suspend fun ObtenerPaciente(codpaciente: String, password: String): EntityPaciente?
}