// package dam.m03.uf5.grupo8.tpv;

/**
 * Clase contenedora que representa a un articulo adquirido por un cliente y
 * que se añadirá a la cesta de la compra.
 * Se usa básicamente para poder almacenar el peso en caso de que un Producto
 * sea a granel.
 * También incluye algunos métodos auxiliares para calcular precios totales a
 * partir de precios unitarios, con y sih IVA.
 * También incluye los métodos getters necesarios.
 * @author Juan
 */
public class ArticuloCompra {
    /** el Producto correspondiente */
    private Producto producto;
    /** peso del producto si es granel. En caso de no serlo, el valor no tiene
     * ningún significado
     */
    private double peso;
    /** precio total del artículo en cesta, con el IVA aplicado y multiplicado
     * por el peso si es a granel
     */
    private double totalConIVA;

    /**
     * Constructor para Productos que no sean a granel
     * @param producto el Producto comprado
     */
    public ArticuloCompra(Producto producto) {
        this.producto = producto;
        totalConIVA = producto.getPrecioConIVA();
    }
    /**
     * Constructor para Productos a granel
     * @param producto el Producto comprado
     * @param peso el peso en Kg
     */

    // He pasado peso a string para poder comprobar con un regex el formato
    // y lanzar una excepcion si es necesario
    public ArticuloCompra(Producto producto, String peso) {
        this.producto = producto;
        if (peso.matches("^[0-9]+[\\.,]?[0-9]*$")) {
            this.peso = Double.parseDouble(peso.replace(",", "."));
            totalConIVA = producto.getPrecioConIVA() * this.peso;
        } else
            throw new NumberFormatException("Peso del producto mal formado");
    }

    /**
     * Añadir los getters necesarios
     */
    public Producto getProducto() { return producto; }
    public double getPeso() { return peso; }
    public double getTotalConIVA() { return totalConIVA; }

    /**
     * Devuelve un String representando los datos principales del artículo en
     * una sóla línea, separados por tabuladores.
     * @return un objeto String, con el formato siguiente:
     * "Descripción corta <TAB> Peso(o <TAB>) <TAB> Precio unitario con IVA <TAB> Total con IVA"
     */
    public String toString() {
        if (producto.isGranel())
            return String.format("%s\t%.2fKg\t%.2f€\t%.2f€", producto.getDescripcionCorta()
                                , peso, producto.getPrecioConIVA(), totalConIVA);
        return String.format("%s\t\t%.2f€\t%.2f€", producto.getDescripcionCorta()
                            , producto.getPrecioConIVA(), totalConIVA);
    }
}
