package Models

class Ticket {
    private var noTicket:Int = 0
    private var cliente: Cliente
    private var peliculaSeleccionada: PeliculaSeleccionada
    private var costoTienda:Double = 0.0

    constructor(noTicket: Int, cliente: Cliente, peliculaSeleccionada: PeliculaSeleccionada) {
        this.noTicket = noTicket
        this.cliente = cliente
        this.peliculaSeleccionada = peliculaSeleccionada
    }

    constructor(noTicket: Int, cliente: Cliente, peliculaSeleccionada: PeliculaSeleccionada, costoTienda:Double) {
        this.noTicket = noTicket
        this.cliente = cliente
        this.peliculaSeleccionada = peliculaSeleccionada
        this.costoTienda = costoTienda
    }

    override fun toString(): String {
        return """
            
            
            ********** TICKET **********
            noTicket: $noTicket
            Cliente: ${cliente.getName()}
            
            **** DETALLE DE SU COMPRA ***
            
            ++++++++++ PELICULA +++++++++
            $peliculaSeleccionada
            Total boletos: ${peliculaSeleccionada.totalPrecioBoletos()}
            
            +++++TIENDA DE PRODUCTOS +++++
            Usted compro
            ${compras}
            Costo de $costoTienda
            Total a pagar: ${(peliculaSeleccionada.totalPrecioBoletos() + costoTienda)}
            """.trimIndent()
    }


}