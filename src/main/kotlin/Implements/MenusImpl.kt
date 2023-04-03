package Implements

import Interface.IMenus
import Models.*

class MenusImpl:IMenus {
    override fun menu(cliente: Cliente, salas: List<Sala>) {
        var opcion:Int
        var peliculaSeleccionada:PeliculaSeleccionada
        var consumibles:Consumibles
        do {
            println("BIENVENIDO ${cliente.getName().uppercase()}")
            println("SELECCIONE LA OPCION DESEADA")
            println("1. Seleccionar pelicula")
            println("2. Seleccionar alimentos")
            println("3. Generar ticket")
            println("4. Cerrar sesion")
            print("\nOpcion: ")
            try {
                opcion = readln().toInt()
            }catch (e: NumberFormatException){
                println("Se necesita una opcion numerica: ${e.message}")
                opcion = 0
            }
            when(opcion){
                1->{
                    peliculaSeleccionada = obtenerBoletos(salas)
                    println("Usted seleciono la pelicula\n${peliculaSeleccionada}")
                }
                2-> {
                    store()
                    var costoTienda = total
                    println("""
                        Usted compro
                        ${compras}
                        Costo de $costoTienda
                    """.trimIndent())
                }
                3->{
                    //TODO: Comportamiento con la clase ticket
                }
                4->{
                    println("Gracias por su visita")
                    break
                }
                else-> println("Selecciona una opcion valida")
            }

        }while (opcion != 4)
    }

    override fun loggin(clientes: List<Cliente>):Cliente {
        var noCliente:Int
        var contraseña:String
        println("\nINICIO DE SESION")
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

    fun obtenerBoletos(salas: List<Sala>): PeliculaSeleccionada {
        var opcion:Int
        var seleccionPelicula:Int
        var seleccionFuncion: Int = -1
        var funcionCorrecta:Int = 0
        var asientosSeleccionados:List<String>
        var peliculaSeleccionada: PeliculaSeleccionada
        for(i in salas) println("$i\n")
        println("Seleccione una SALA:\nsolo se puede seleccionar una sala")
        seleccionPelicula = readln().toInt()
        while (funcionCorrecta == 0){
            if (seleccionFuncion != -1) funcionCorrecta = 1
            else seleccionFuncion = buscarFuncion(salas[seleccionPelicula-1])
        }
        println("Selecciono la funcion ${salas[seleccionPelicula-1].getFuncion()[seleccionFuncion]}")
        println("Seleccione sus asientos")
        salas[seleccionPelicula-1].getFuncion()[seleccionFuncion].mostrarAsientos()
        asientosSeleccionados = salas[seleccionPelicula-1].getFuncion()[seleccionFuncion].seleccionarAsientos()
        peliculaSeleccionada = PeliculaSeleccionada(
            salas[seleccionPelicula-1].getPelicula().getNombre(),
            seleccionPelicula,
            asientosSeleccionados,
            salas[seleccionPelicula-1].getFuncion()[seleccionFuncion].getHorario()
        )
        println("Detalle de sus boletos:\n$peliculaSeleccionada")
        return peliculaSeleccionada
    }
    fun buscarFuncion(sala: Sala):Int{
        var seleccionFuncion:Int
        var i:Int = 0
        println("Seleccione una funcion:")
        while (i < sala.getFuncion().size){
            println("${i+1}. ${sala.getFuncion()[i]}")
            i++
        }
        try {
            seleccionFuncion = readln().toInt()
            if (seleccionFuncion == 1 ||seleccionFuncion == 2||seleccionFuncion == 3) return (seleccionFuncion-1)
            else return -1
        }catch (e: NumberFormatException) {
            println("Se necesita una opcion numerica: ${e.message}")
            return -1
        }

    }


}