import Models.Funcion
import Models.Pelicula
import Models.Sala

fun main(){
    var salas = inicializarSalas()

    var opcion:Int
    do {
        println("Salas")
        println("SELECCIONE LA SALA")
        println("1. Seleccionar pelicula")
        println("2. Borrar pelicula")
        println("3. Borrar todo")
        println("4. Terminar")
        print("\nOpcion: ")
        try {
            opcion = readln().toInt()
        }catch (e: NumberFormatException){
            println("Se necesita una opcion numerica: ${e.message}")
            opcion = 0
        }
        when(opcion){
            1->{
                for(i in salas){
                    println("$i\n")
                }
                println("Seleccione una SALA:")
                var seleccion = readln().toInt()

                println("Seleccione una funcion:")
                println("${salas[seleccion-1].getFuncion()}")
            }
            4->{
                println("Disfrute su pelicula")
                break
            }
            else-> println("Selecciona una opcion valida")
        }
    }while (opcion != 4)












}

fun inicializarSalas():List<Sala>{

    var pelicula01:Pelicula = Pelicula(
        "nombre",
        120,
        "genero",
        2023,
        "direccion"
    )
    var funcion01:Funcion = Funcion(
        "12:30",
        60.00
    )
    funcion01.inicializarAsientos()
    var funcion02:Funcion = Funcion(
        "15:00",
        60.00
    )
    funcion02.inicializarAsientos()
    var funciones01 = mutableListOf(funcion01, funcion02)
    var sala01:Sala = Sala(
        1,
        pelicula01,
        funciones01
    )


    var pelicula02:Pelicula = Pelicula(
        "nombre",
        120,
        "genero",
        2023,
        "direccion"
    )
    var funcion03:Funcion = Funcion(
        "12:30",
        60.00
    )
    funcion03.inicializarAsientos()
    var funcion04:Funcion = Funcion(
        "15:00",
        60.00
    )
    funcion04.inicializarAsientos()
    var funciones02 = mutableListOf(funcion01, funcion02)
    var sala02:Sala = Sala(
        2,
        pelicula02,
        funciones02
    )

    var salas = mutableListOf<Sala>(sala01, sala02)
    return salas
}