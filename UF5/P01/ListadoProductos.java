// package dam.m03.uf5.grupo8.tpv;

import java.util.Map;
import java.util.TreeMap;

/** Modelo de datos para almacenar el listado de productos de una tienda, que
 * esconde el soporte utilizado para su almacenamiento.
 * Se deberá escoger el mejor tipo de colección que permita buscar
 * un producto a partir de su código de barras
 * @author Juan
 */
public class ListadoProductos {
    /** referencia a una colección usada para almacenar la relación
     * de productos disponibles.
     */
    private Map<String, Producto> listado = new TreeMap<>();

    /** Crea y devuelve una instancia de la clase. Se debe inicializar con unos
     * cuantos productos de prueba como los del enunciado
     */
    public ListadoProductos() throws ProductoException {
        Producto a = new Producto("8400000000000", "Papel WC Doble Capa", 4.55, 21, false);
        Producto b = new Producto("8400000000001", "Pasta de dientes Dentifrix", 3.22, 21, false);
        Producto c = new Producto("8400000000002", "Naranjas Sevillanas", 0.79, 10, true);
        Producto d = new Producto("8400000000003", "Tomates Ensalada", 1.99, 10, true);
        listado.put(a.getCodigo(), a);
        listado.put(b.getCodigo(), b);
        listado.put(c.getCodigo(), c);
        listado.put(d.getCodigo(), d);
    }

    /**
     * Método que devuelve el Producto correspondiente a un codigo de barras
     * @param codigo el código de barras a buscar
     * @return la instancia de Producto correspondiente al código
     * @throws ProductoException en caso de que el producto no exista o si el
     * formato no es correcto (en el constructor de la excepción se indicará
     * cuál de los dos motivos).
     */
    public Producto getProductoByCodigo(String codigo) throws ProductoException {
        if (!Producto.esCodigoCorrecto(codigo))
            throw new ProductoException("Codigo mal formado");
        if (!listado.containsKey(codigo))
            throw new ProductoException("Producto no encontrado");
        else
            return listado.get(codigo);
    }
}
