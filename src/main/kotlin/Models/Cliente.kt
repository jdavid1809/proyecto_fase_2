package Models

class Cliente(
    noCliente:Int,
    nombre:String,
    edad:Int,
    correo:String,
    contraseña:String
): Persona(nombre,edad) {
    private var noCliente:Int = noCliente
    private var correo:String = correo
    private var contraseña:String = contraseña
    private var membresia:String = "Bronce"
    private var visitas:Int = 0

    fun getNoCliente():Int{
        return noCliente
    }

    fun getCorreo():String{
        return correo
    }

    fun setCorreo(correo: String){
        this.correo = correo
    }

    fun getContraseña():String{
        return contraseña
    }

    fun setContraseña(contraseña: String){
        this.contraseña = contraseña
    }

    fun getMembresia():String{
        return membresia
    }

    fun setMembresia(membresia: String){
        this.membresia = membresia
    }

    fun getVisitas():Int{
        return visitas
    }

    fun setVisitas(visitas: Int){
        this.visitas = visitas
    }

    override fun toString(): String {

        return "Cliente(noCliente=$noCliente, nombre=${getName()}, edad=${getAge()}, correo='$correo', contraseña='$contraseña')"
    }


}