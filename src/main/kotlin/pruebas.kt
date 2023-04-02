import Models.Funcion
import Models.Pelicula
import Models.PeliculaSeleccionada
import Models.Sala

fun main(){
    var salas = inicializarSalas()
    var peliculaSeleccionada = obtenerBoletos(salas)
}

fun obtenerBoletos(salas: List<Sala>):PeliculaSeleccionada{
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

/*fun inicializarSalas():List<Sala>{

    var pelicula01:Pelicula = Pelicula(
        "CREED III",
        116,
        "Drama, Deporte",
        2023,
        "Michael B. Jordan"
    )
    var funcion01:Funcion = Funcion(
        "15:00",
        60.00
    )
    funcion01.inicializarAsientos()
    var funcion02:Funcion = Funcion(
        "18:30",
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
        "John Wick 4",
        169,
        "Accion, Suspenso",
        2023,
        "Chad Stahelski"
    )
    var funcion03:Funcion = Funcion(
        "12:00",
        60.00
    )
    funcion03.inicializarAsientos()
    var funcion04:Funcion = Funcion(
        "15:30",
        60.00
    )
    funcion04.inicializarAsientos()
    var funciones02 = mutableListOf(funcion01, funcion02)
    var sala02:Sala = Sala(
        2,
        pelicula02,
        funciones02
    )


    var pelicula03:Pelicula = Pelicula(
        "La Ballena",
        117,
        "Drama",
        2023,
        "Darren Aronofsky"
    )
    var funcion05:Funcion = Funcion(
        "13:30",
        60.00
    )
    funcion05.inicializarAsientos()
    var funcion06:Funcion = Funcion(
        "15:30",
        60.00
    )
    funcion04.inicializarAsientos()
    var funciones03 = mutableListOf(funcion01, funcion02)
    var sala03:Sala = Sala(
        3,
        pelicula03,
        funciones03
    )

    var salas = mutableListOf<Sala>(sala01, sala02, sala03)
    return salas

}
 */