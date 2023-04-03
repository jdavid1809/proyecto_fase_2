import Implements.MenusImpl
import Models.Cliente
import Models.Funcion
import Models.Pelicula
import Models.Sala
import java.lang.Exception

var NO_CLIENTE:Int = 1000
var clientes = listOf<Cliente>()
var salas = listOf<Sala>()

fun main() {
    salas = inicializarSalas()
    clientes = inicializarClientes()
    menuLogging()
}

fun menuLogging(){
    var cliente: Cliente
    val menu = MenusImpl()
    var opcion = 0
    do {
        println("""
            ***** Complejo CInematográfico BEDU *****
            *****       	Bienvenido	    	*****
            
            1. Iniciar sesion
            2. Registrar usuario
            3. Salir
        """.trimIndent())
        print("Ingrese la opcion deseada: ")
        opcion = readln().toInt()
        when(opcion){
            1->{
                try {
                    cliente = menu.loggin(clientes)
                    menu.menu(cliente, salas)
                }catch (e: Exception){
                    println("Error al iniciar sesion: ${e.message}")
                }
            }
            2->{
                clientes = menu.register(NO_CLIENTE++,clientes)
            }
            3->break
            else-> println("Opcion no valida")
        }
    }while (opcion != 3)

}

fun inicializarClientes():List<Cliente>{
    var clientesAux = mutableListOf<Cliente>()
    var cliente1:Cliente = Cliente(NO_CLIENTE++,"Javier",27,"javier@gmail.com","contra1000")
    clientesAux.add(cliente1)
    var cliente2:Cliente = Cliente(NO_CLIENTE++,"David",28,"david@gmail.com","contra1001")
    clientesAux.add(cliente2)
    var cliente3:Cliente = Cliente(NO_CLIENTE++,"Flor",24,"flor@gmail.com","contra1002")
    clientesAux.add(cliente3)
    var cliente4:Cliente = Cliente(NO_CLIENTE++,"Areli",25,"areli@gmail.com","contra1003")
    clientesAux.add(cliente4)
    return clientesAux
}

fun inicializarSalas():List<Sala>{

    var pelicula01: Pelicula = Pelicula(
        "CREED III",
        116,
        "Drama, Deporte",
        2023,
        "Michael B. Jordan"
    )
    var funcion01: Funcion = Funcion(
        "15:00",
        60.00
    )
    funcion01.inicializarAsientos()
    var funcion02: Funcion = Funcion(
        "18:30",
        60.00
    )
    funcion02.inicializarAsientos()
    var funciones01 = mutableListOf(funcion01, funcion02)
    var sala01: Sala = Sala(
        1,
        pelicula01,
        funciones01
    )


    var pelicula02: Pelicula = Pelicula(
        "John Wick 4",
        169,
        "Accion, Suspenso",
        2023,
        "Chad Stahelski"
    )
    var funcion03: Funcion = Funcion(
        "12:00",
        60.00
    )
    funcion03.inicializarAsientos()
    var funcion04: Funcion = Funcion(
        "15:30",
        60.00
    )
    funcion04.inicializarAsientos()
    var funciones02 = mutableListOf(funcion01, funcion02)
    var sala02: Sala = Sala(
        2,
        pelicula02,
        funciones02
    )


    var pelicula03: Pelicula = Pelicula(
        "La Ballena",
        117,
        "Drama",
        2023,
        "Darren Aronofsky"
    )
    var funcion05: Funcion = Funcion(
        "13:30",
        60.00
    )
    funcion05.inicializarAsientos()
    var funcion06: Funcion = Funcion(
        "15:30",
        60.00
    )
    funcion04.inicializarAsientos()
    var funciones03 = mutableListOf(funcion01, funcion02)
    var sala03: Sala = Sala(
        3,
        pelicula03,
        funciones03
    )

    var salas = mutableListOf<Sala>(sala01, sala02, sala03)
    return salas
}


/*
    println(" ")
    println("***** Complejo CInematográfico BEDU *****")
    println(" ")
    println("Hola, dime tu nombre:")
    val nombre = readln()!!
    val nuevo = "N"
    val edad = 18
    val registrado = "R"
    println("Bienvenido $nombre al Cine")
    println(" ")
    println("¿Eres Usuario Nuevo (N) o Usuario Registrado (R)? ")
    val usuario = readln()!!
        if (usuario == nuevo) {
            verifyAge(nombre)

        } else if (usuario == registrado){
            println("Bienvenido Usuario $nombre.")
            println("¿Qué membresia tienes?")
            println("1 = Bronce")
            println("2 = Plata")
            println("3 = Oro")
            println("4 = Platino")

            val membresia = readln()?.toInt()
            when (membresia){
                1 -> print ("El usuario tiene membresia Bronce con descuento del 5%")
                2 -> print ("El usuario tiene membresia Plata con descuento del 10%")
                3 -> print ("El usuario tiene membresia Oro con descuento del 15%")
                4 -> print ("El usuario tiene membresia Platino con descuento del 20%")
            }
        } else {
            println("Tienes que elegir (N) o (R) solamente.")
        }


}

fun verifyAge(nombre: Any){
    println("$nombre introduce tu edad y presiona Enter (escribe sólo el número):")
    val age = readLine()?.toInt()

    if(age!! >= 18){
        println("El usuario $nombre es mayor de edad.")
    } else {
        println("El usuario $nombre es menor de edad y no podemos venderle boletos.")
    }
}*/