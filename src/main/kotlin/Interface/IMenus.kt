package Interface

import Models.Cliente
import Models.Sala

interface IMenus {
    fun menu(cliente: Cliente, salas:List<Sala>)
    fun loggin(clientes: List<Cliente>):Cliente
    fun register(noCliente: Int, clientes: List<Cliente>):List<Cliente>
}