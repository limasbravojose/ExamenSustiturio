package pe.idat.appa17144008.rutas

sealed class Rutas(val ruta: String) {
    object Login : Rutas("login")
    object Home : Rutas("home")
    object TodoList : Rutas("todoList")
    object PhotoList : Rutas("photoList")
}