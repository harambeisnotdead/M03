package dam.m03.uf5.grupo8.tpv.modelo;

public class ArticuloCompra {
    private Producto producto;
    private double peso;
    private double totalConIVA;

    public ArticuloCompra(Producto producto) {
        this.producto = producto;
        totalConIVA = producto.getPrecioConIVA();
    }

    public ArticuloCompra(Producto producto, String peso) {
        this.producto = producto;
        if (peso.matches("^[0-9]+[\\.,]?[0-9]*$")) {
            this.peso = Double.parseDouble(peso.replace(",", "."));
            totalConIVA = producto.getPrecioConIVA() * this.peso;
        } else
            throw new NumberFormatException("Peso del producto mal formado");
    }

    public Producto getProducto() { return producto; }
    public double getPeso() { return peso; }
    public double getTotalConIVA() { return totalConIVA; }
    public double getTotalSinIVA() { 
        if (producto.isGranel())
            return producto.getPrecioSinIVA() * peso;
        return producto.getPrecioSinIVA();
    }

    public String toString() {
        if (producto.isGranel())
            return String.format("%s\t%.2fKg\t%.2f€\t%.2f€", producto.getDescripcionCorta()
                                , peso, this.getTotalSinIVA(), totalConIVA);
        return String.format("%s\t\t%.2f€\t%.2f€", producto.getDescripcionCorta()
                            , this.getTotalSinIVA(), totalConIVA);
    }
}
