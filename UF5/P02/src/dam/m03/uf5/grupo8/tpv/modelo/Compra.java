package dam.m03.uf5.grupo8.tpv.modelo;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Compra {

    private List<ArticuloCompra> cesta = new ArrayList<>();
    private LocalDateTime fechaHora;
    private double total;
    private double base;
    private Cliente cliente;

    public Compra(Cliente cliente) {
        this.cliente = cliente;
        fechaHora = LocalDateTime.now();
        base = 0;
        total = 0;
    }

    public void ponArticulo(ArticuloCompra articulo) {
        base += articulo.getTotalSinIVA();
        total += articulo.getTotalConIVA();
        cesta.add(articulo);
    }

    public String getFecha() {
        return fechaHora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    public double getTotal() { return total; }

    public String resumen() {
        return String.format("Fecha: %s, Importe (con IVA): %.2f€\n", getFecha(), getTotal());
    }

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
