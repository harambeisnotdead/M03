package dam.m03.uf5.grupo8.tpv.modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;
import java.io.FileWriter;
import java.io.IOException;

public class ListadoProductos {
    private Map<String, Producto> listado = new TreeMap<>();
    private String archivo = "productos.csv";

    public ListadoProductos() throws ProductoException {
        leerProductos(archivo);
    }

    public Producto getProductoByCodigo(String codigo) throws ProductoException {
        if (!Producto.esCodigoCorrecto(codigo))
            throw new ProductoException("Codigo mal formado");
        if (!listado.containsKey(codigo))
            throw new ProductoException("Producto no encontrado");
        else
            return listado.get(codigo);
    }

    public void addProducto(Producto producto) throws ProductoException {
        if (listado.containsKey(producto.getCodigo()))
            throw new ProductoException("Ese producto ya esta creado");
        listado.put(producto.getCodigo(), producto);
        try {
            escribirProducto(producto, archivo);
        } catch (IOException e) {}
    }

    public void escribirProducto(Producto producto, String archivo) throws IOException {
        try (FileWriter writer = new FileWriter(archivo, true)) {
            writer.write(producto.toString());
            writer.flush();
        } catch (IOException e) { throw new IOException("Error al escribir producto"); }
    }

    public void leerProductos(String archivo) throws ProductoException {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] producto = line.split(",");
                listado.put(producto[0], 
                            new Producto(producto[0], producto[1], 
                                         Double.parseDouble(producto[2]), 
                                         Integer.parseInt(producto[3]), 
                                         Boolean.parseBoolean(producto[4])));
            }
        } catch (IOException e) { throw new ProductoException("Error al leer " + archivo); }   
    }
}
