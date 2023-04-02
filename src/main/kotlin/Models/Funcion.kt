package Models

class Funcion(
    horario:String,
    precioAsiento:Double
) {
    private var horario = horario
    private var tamFila = 8
    private var tamColumn = 8
    private var asientos = Array(tamFila){CharArray(tamColumn)}
    private var precioAsiento = precioAsiento
    private var NUMEROASIENTOS = 64

    fun getHorario():String{
        return this.horario
    }

    fun inicializarAsientos(){
        var fila = 0
        var columna = 0
        while (fila < tamFila){
            while (columna < tamColumn){
                this.asientos[fila][columna] = 'L'
                columna++
            }
            columna = 0
            fila++
        }
    }
    fun mostrarAsientos(){
        var fila = 0
        var columna = 0
        println("L:Libre\tO:Ocupado\tS:Seleccionado")
        print(" \t")
        for(i in 1..tamColumn) print("$i\t")
        println()
        while (fila < tamFila-1){
            print("${fila+1}\t")
            while (columna < tamColumn){
                print("${this.asientos[fila][columna]}\t")
                columna++
            }
            println()
            columna = 0
            fila++
        }
    }

    fun seleccionarAsientos():List<String>{
        var banderaAsientosDisp:Boolean = false
        var asientosDeseados:Int = 0
        var i :Int = 0
        var columnaDeseada:Int = 0
        var filaDeseada:Int = 0
        var banderaAsientosCorr = false
        var numeroAsiento:Int = 1
        var asientosSeleccionados:MutableList<String> = mutableListOf()
        if (NUMEROASIENTOS == 0){
            println("no hay asientos disponibles")
            return asientosSeleccionados
        }
        while (!banderaAsientosDisp){
            print("Seleccione cuantos asientos desea: ")
            try {
                asientosDeseados = readln().toInt()
                if (NUMEROASIENTOS-asientosDeseados < 0){
                    println("No hay asientos disponibles")
                }else{
                    banderaAsientosDisp = true
                }
            }catch (e: NumberFormatException){
                println("Se necesita una opcion numerica: ${e.message}")
            }
        }
        while (i<asientosDeseados){
            while (!banderaAsientosCorr){
                try {
                    println("Seleccione una columna (1-$tamColumn)")
                    columnaDeseada = readln().toInt()
                    println("Seleccione una fila (A-${(tamFila+64).toChar()})")
                    var filaDeseada = readln().toInt()
                    this.asientos[filaDeseada-1][columnaDeseada-1] = 'S'
                    banderaAsientosCorr=true
                    asientosSeleccionados.add("Boleto ${numeroAsiento++}: Fila: $filaDeseada Columna: $columnaDeseada")
                }catch (e: Exception){
                    println("Se necesita una opcion valida: ${e.message}")
                }
            }
            banderaAsientosCorr=false
            columnaDeseada = 0
            filaDeseada = 0
            i++
            mostrarAsientos()
        }
        return asientosSeleccionados
    }



    override fun toString(): String {
        return "$horario "
    }


}