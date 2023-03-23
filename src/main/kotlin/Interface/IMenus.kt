package Interface

import Models.Cliente

interface IMenus {
    fun menu()
    fun loggin(clientes: List<Cliente>):Cliente
    fun register(noCliente: Int, clientes: List<Cliente>):List<Cliente>
}