package dam.m03.uf5.grupo8.tpv.modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CajaRegistradora {

    private String cif;
    private String nombreEmpresa;
    private String telefono;
    private String direccion;
    private ListadoProductos listaProductos;
    private List<Compra> comprasRealizadas = new ArrayList<>();
    private Map<Integer, Cliente> clientes = new HashMap<>();
    String archivoClientes = "clientes.csv";

    public CajaRegistradora(String cif, String telefono, String nombreEmpresa,
            String direccion) throws ProductoException {
        this.cif = cif;
        this.telefono = telefono;
        this.nombreEmpresa = nombreEmpresa;
        this.direccion = direccion;
        listaProductos = new ListadoProductos();
        leerClientes();
    }

    private Cliente getClienteByCodigo(String codigo) throws ClienteException {
        try {
            if (!clientes.containsKey(Integer.parseInt(codigo))) {
                throw new ClienteException("Cliente no encontrado");
            } else {
                return clientes.get(Integer.parseInt(codigo));
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Codigo cliente mal formado");
        }
    }

    private Cliente getClienteByNif(String nif) throws ClienteException {
        for (Cliente cliente : clientes.values())
            if (cliente.getNif().equals(nif))
                return cliente;
        throw new ClienteException("Cliente no encontrado");
    }

    private String getCabecera() {
        return nombreEmpresa + "\n"
                + direccion + "\n"
                + telefono + "\n";
    }

    public String listarCompras() {
        String resultado = "";
        for (int i=0; i<comprasRealizadas.size(); i++)
            resultado += String.format("%d - %s", i, comprasRealizadas.get(i).resumen()); 
        return resultado;
    }
    
    public void altaCliente(String nombre, String apellidos, String nif)
            throws IllegalArgumentException {
        if (nombre.isEmpty() || apellidos.isEmpty() || nif.isEmpty())
            throw new IllegalArgumentException("Ningun campo puede estar vacio");
        
        Cliente cliente = new Cliente(nombre, apellidos, nif);
        clientes.put(cliente.getCodigoCliente(), cliente);
//        try {
//            escribirCliente(cliente); --> tiene error
//        } catch (IOException e) {}
    }
    
    public Cliente getCliente(String idCliente, String tipoId) throws ClienteException {
        Cliente cliente;
        if (tipoId.equals("NIF"))
            cliente = getClienteByNif(idCliente);
        else
            cliente = getClienteByCodigo(idCliente);
        return cliente;
    }
    
    public Producto getProducto(String codigoProducto) throws ProductoException {
        return listaProductos.getProductoByCodigo(codigoProducto);
    }
    
    public Compra nuevaCompra(Cliente cliente, Producto producto) throws ClienteException {
        Compra compra = new Compra(cliente);
        ArticuloCompra articulo = new ArticuloCompra(producto);
        compra.ponArticulo(articulo);
        comprasRealizadas.add(compra);
        return compra;
    }
    
    public Compra nuevaCompra(Cliente cliente, Producto producto, String peso) {
        Compra compra = new Compra(cliente);
        ArticuloCompra articulo;
        articulo = new ArticuloCompra(producto, peso);
        compra.ponArticulo(articulo); 
        comprasRealizadas.add(compra);
        return compra;
    }

    public String getTicket(Compra compra) throws CompraException {
        if (compra == null)
            throw new CompraException("No hay ninguna compra");
                
        return  String.format("\n\nTicket de compra numero: %d\n", comprasRealizadas.size())
                + "*********************************\n"
                + getCabecera()
                + compra.generaTicket();
    }

    public ListadoProductos getListaProductos() { return listaProductos; }
    
     public void leerClientes() throws ProductoException {
        try (BufferedReader br = new BufferedReader(new FileReader(archivoClientes))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] cliente = line.split(",");
                altaCliente(cliente[0], cliente[1], cliente[2]);
            }
        } catch (IOException e) { throw new ProductoException("Error al leer " + archivoClientes); }   
    }
     
    public void escribirCliente(Cliente cliente) throws IOException {
        try (FileWriter writer = new FileWriter(archivoClientes, true)) {
            writer.write(cliente.toCSVString());
            writer.flush();
        } catch (IOException e) { throw new IOException("Error al escribir producto"); }
    }
}
