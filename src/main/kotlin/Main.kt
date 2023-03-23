import Implements.MenusImpl
import Models.Cliente
import java.lang.Exception

var NO_TICKET:Int = 1000
var NO_CLIENTE:Int = 1000

fun main() {
    var clientes = listOf<Cliente>()
    var cliente: Cliente
    var opcion = 0
    val menu = MenusImpl()
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
                    menu.menu()
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