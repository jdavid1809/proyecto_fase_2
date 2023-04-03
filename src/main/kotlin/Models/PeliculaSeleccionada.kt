package Models

class PeliculaSeleccionada (
    nombre:String,
    sala: Int,
    asientos: List<String>,
    horario:String
){
    private var nombre: String = nombre
    private var sala: Int = sala
    private var asientos: List<String> = asientos
    private var horario: String = horario

    fun getNombre():String{
        return this.nombre
    }
    fun setNombre(nombre:String){
        this.nombre = nombre
    }
    fun getSala():Int{
        return sala
    }
    fun setSala(sala:Int){
        this.sala = sala
    }
    fun getAsientos():List<String>{
        return asientos
    }
    fun setAsientos(asientos: List<String>){
        this.asientos = asientos
    }
    fun getHorario():String{
        return this.horario
    }
    fun setHorario(horario: String){
        this.horario = horario
    }

    fun totalPrecioBoletos():Double{
        var total:Double
        if (sala == 3){
            return 90.00 * asientos.size
        }
        else{
            return 60.00 * asientos.size
        }
    }

    override fun toString(): String {
        return """Pelicula: $nombre, 
            Sala: $sala, 
            Asientos: $asientos, 
            Horario: $horario"""
            .trimMargin()
    }


}