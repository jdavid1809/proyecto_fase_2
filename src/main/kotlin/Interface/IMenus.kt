package Interface

import Models.Cliente

interface IMenus {
    fun menu(cliente: Cliente)
    fun loggin(clientes: List<Cliente>):Cliente
    fun register(noCliente: Int, clientes: List<Cliente>):List<Cliente>
}