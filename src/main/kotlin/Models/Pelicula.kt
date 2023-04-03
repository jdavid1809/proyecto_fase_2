package Models

class Pelicula(
    nombre:String,
    duracion:Int,
    genero:String,
    año: Int,
    director: String
) {
    private var nombre:String = nombre
    private var duracion:Int = duracion
    private var genero:String = genero
    private var año:Int = año
    private var director:String = director

    fun getNombre():String{
        return nombre
    }

    fun setNombre(nombre: String){
        this.nombre = nombre
    }

    fun getDuracion():Int{
        return duracion
    }

    fun setDuracion(duracion: Int){
        this.duracion = duracion
    }

    fun getGenero():String{
        return genero
    }

    fun setGenero(genero: String){
        this.genero = genero
    }

    fun getAño():Int{
        return año
    }

    fun setAño(año: Int){
        this.año = año
    }

    fun getDirector():String{
        return director
    }

    fun setDirector(director: String){
        this.director = director
    }

    override fun toString(): String {
        return "Titulo: $nombre\n" +
                "Duracion: $duracion minutos\n" +
                "Genero: $genero\n" +
                "Año de lanzamiento: $año\n" +
                "Director: $director\n"
    }


}