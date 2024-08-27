package pe.idat.appa17144008.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [EntityPaciente::class], version = 1, exportSchema = false)
abstract class AppDataB: RoomDatabase() {
    abstract fun pacienteDao(): PacienteDao
}