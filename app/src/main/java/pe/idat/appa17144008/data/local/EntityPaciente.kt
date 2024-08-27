package pe.idat.appa17144008.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pacientes")
data class EntityPaciente(
    @PrimaryKey
    val codpaciente: String,
    val password: String,
    val nombreApellido: String,
    val celular: String
)
