// package dam.m03.uf5.grupo8.tpv;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Clase que representa una compra realizada por un cliente con la relació
 * de artículos y métodos para generar diversa información
 * @author Juan
 */
public class Compra {

    /** COLECCION donde se iran añadiendo los ArticuloCompra escaneados
     */
    private List<ArticuloCompra> cesta = new ArrayList<>();
    /** fecha y hora de la compra */
    private LocalDateTime fechaHora;
    /** el precio total (con IVA) */
    private double total;
    /** el precio total (sin IVA) */
    private double base;
    /** cliente asociado a la compra */
    private Cliente cliente;

    /**
     * Devuelve una instancia de Compra, inicializando sus atributos
     * @param cliente
     */
    public Compra(Cliente cliente) {
        this.cliente = cliente;
        fechaHora = LocalDateTime.now();
        base = 0;
        total = 0;
    }

    /**
     * Añade un artículo escaneado a la cesta
     * @param articulo el ArticuloCompra a añadir
     */
    public void ponArticulo(ArticuloCompra articulo) {
        base += articulo.getProducto().getPrecioSinIVA();
        total += articulo.getTotalConIVA();
        cesta.add(articulo);
    }

    /** Devuelve una representación de la fecha de la compra
     *
     * @return un String con el formato: dia/mes/año hora:minutos:segundos
     */
    public String getFecha() {
        return fechaHora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    /**
     *
     * @return el precio total de la compra, con el IVA incluido
     */
    public double getTotal() { return total; }

    /**
     * Devuelve un resumen de una Compra, útil a la hora de mostrar un listado
     * de todas las compras realizadas.
     * @return un String con el formato: "Fecha: la_fecha, Importe (con IVA): el_importe"
     */
    public String resumen() {
        return String.format("Fecha: %s, Importe (con IVA): %.2f\n", getFecha(), getTotal());
    }

    /**
     * Método que genera un ticket con el listado de artículos adquiridos.
     * Hace uso del método toString de ArticuloCompra para mostrar cada línea.
     * @return un String con el ticket de compra
     */
    public String generaTicket() {
        String articulos = "";
        for (int i=0; i<cesta.size(); i++)
            articulos += String.format("%d\t%s\n", i+1, cesta.get(i));
        return String.format(
            "%s\n"
            + "---------------------------\n"
            + "#\tDESCRIPCIÓN\tPESO\tPVP\tTOTAL\n"
            + "%s"
            + "---------------------------\n"
            + "Cliente número: %s\n"
            + "BASE:\t\t\t%.2f€\n"
            + "TOTAL:\t\t\t%.2f€\n"
            , getFecha(), articulos, cliente.getCodigoCliente(), base, total
        );
    }
}
