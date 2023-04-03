package Models

class Sala(
    numSala:Int,
    pelicula:Pelicula,
    funcion: List<Funcion>
) {
    private var numSala = numSala
    private var pelicula = pelicula
    private var funcion = funcion

    fun getNumSala():Int{
        return numSala
    }

    fun getPelicula():Pelicula{
        return pelicula
    }

    fun getFuncion():List<Funcion>{
        return funcion
    }

    override fun toString(): String {
        return "SALA: $numSala\n" +
                "$pelicula"+
                "funciones: $funcion"
    }


}