package pe.idat.appa17144008.data.network.retrofitCliente

import pe.idat.appa17144008.data.network.response.Imagen
import pe.idat.appa17144008.data.network.response.Paciente
import retrofit2.http.GET

interface RCliente {
    @GET("todos")
    suspend fun getPacientes(): List<Paciente>

    @GET("photos")
    suspend fun getImagenes(): List<Imagen>
}