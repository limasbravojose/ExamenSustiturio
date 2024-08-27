package pe.idat.appa17144008.core

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import pe.idat.appa17144008.data.local.AppDataB
import pe.idat.appa17144008.data.local.PacienteDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AppDataB {
        return Room.databaseBuilder(
            appContext,
            AppDataB::class.java,
            "database_paciente"
        ).build()
    }

    @Provides
    fun providePacienteDao(db: AppDataB): PacienteDao {
        return db.pacienteDao()
    }
}