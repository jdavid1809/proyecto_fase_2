package Implements

import Interface.IMenus
import Models.Cliente

class MenusImpl:IMenus {
    override fun menu(cliente: Cliente) {
        var opcion:Int
        do {
            println("SELECCIONE LA OPCION DESEADA")
            println("1. Seleccionar pelicula")
            println("2. Seleccionar alimentos")
            println("3. Seleccionar combos")
            println("4. Generar ticket")
            println("5. Cerrar sesion")
            print("\nOpcion: ")
            try {
                opcion = readln().toInt()
            }catch (e: NumberFormatException){
                println("Se necesita una opcion numerica: ${e.message}")
                opcion = 0
            }
            when(opcion){
                1->{
                    //TODO: Comportamiento con la calse peliculas
                }
                2-> {
                    //TODO: Comportamiento con la clase alimentos
                }
                3->{
                    //TODO: Comportamiento con la clase combo
                }
                4->{
                    //TODO: Comportamiento con la clase ticket
                }
                5->{
                    println("Gracias por su visita")
                    break
                }
                else-> println("Selecciona una opcion valida")
            }

        }while (opcion != 5)
    }

    override fun loggin(clientes: List<Cliente>):Cliente {
        var noCliente:Int
        var contraseña:String
        println("INICIO DE SESION")
        print("Numero Cliente: ")
        noCliente = readln().toInt()
        print("Contraseña: ")
        contraseña = readln()
        for (i in clientes) {
            if (i.getNoCliente() == noCliente){
                if (i.getContraseña().equals(contraseña)){
                    return i
                }
                else throw Exception("Contraseña incorrecta")
            }
            else{
                continue
            }
        }
        throw Exception("No existe el usuario")
    }


    override fun register(noCliente:Int, clientes: List<Cliente>): List<Cliente> {
        var nombre: String
        var edad: Int
        var correo: String
        var contraseña: String
        val cliente: Cliente
        var clientesAux = mutableListOf<Cliente>()

        println("REGISTRO")
        println("Proporciona los siguientes datos")
        print("Nombre: ")
        nombre = readln()
        print("Edad: ")
        edad = readln().toInt()
        print("Correo: ")
        correo = readln()
        print("Contraseña: ")
        contraseña = readln()

        cliente = Cliente(noCliente,nombre,edad,correo,contraseña)
        for (i in clientes){
            clientesAux.add(i)
        }
        clientesAux.add(cliente)
        println("Registro correcto, le mostramos sus datos:")
        println(cliente)
        return clientesAux
    }
}