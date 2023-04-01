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

    override fun toString(): String {
        return "$horario "
    }


}