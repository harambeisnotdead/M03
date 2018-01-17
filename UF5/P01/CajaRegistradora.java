// package dam.m03.uf5.grupo8.tpv;

import java.util.*;
import java.io.Console;

/**
 * Clase principal de la aplicación que implementa una caja registradora
 * @author jmartin
 */
public class CajaRegistradora {
    private String cif;
    private String nombreEmpresa;
    private String telefono;
    private String direccion;
    /** almacena los Productos disponibles en la tienda */
    private ListadoProductos listaProductos;
    /** instancia de tipo COLECCION para guardar las compras finalizadas */
    private List<Compra> comprasRealizadas = new ArrayList<>();
    /** COLECCION de clientes que permita hacer búsquedas a partir del código
     * de cliente
     */
    private Map<Integer, Cliente> clientes = new TreeMap<>();

    /**
     * Devuelve una nueva instancia, inicializada con los datos proporcionados.
     * Inicializa también el resto de atributos.
     * @param cif
     * @param telefono
     * @param nombreEmpresa
     * @param direccion
     */
    public CajaRegistradora(String cif, String telefono, String nombreEmpresa,
            String direccion) {
        this.cif = cif;
        this.telefono = telefono;
        this.nombreEmpresa = nombreEmpresa;
        this.direccion = direccion;
    }
    /**
     * Método principal que arranca la ejecución de la CajaRegistradora.
     * Muestra al usuario cuatro opciones: nueva compra, listar compras, alta
     * cliente y salir. Mientras el usuario no elija salir, procesará las
     * opciones seleccionadas.
     * Si se elige una nueva compra, leerá los códigos de barras de los
     * artículos hasta que se finalice introduciendo una "F". Si el artículo es
     * un Producto a granel, pedirá el peso. En caso de error de introducción
     * de cualquiera de los datos, mostrará un mensaje de error y pasará a pedir
     * de nuevo el código de barras.
     * Al finalizar una compra, mostrará el ticket para el usuario. Dicho ticket
     * se generará usando el método correspondiente de la clase Compra,
     * anteponiendo los datos del comercio (nombre, dirección, etc)
     * Si se elige listar compras, mostrará un resumen de la compras realizadas,
     * una por línea, usando el método de la clase Compra correspondiente.
     */

    private Cliente getClienteByCodigo(String codigo) throws ClienteException {
        try {
            if (!clientes.containsKey(Integer.parseInt(codigo)))
                throw new ClienteException("Cliente no encontrado");
            else
                return clientes.get(Integer.parseInt(codigo));
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Codigo cliente mal formado");
        }
    }

    private String getCabecera() {
        return nombreEmpresa + "\n"
               + direccion + "\n"
               + telefono + "\n";
    }

    public void inicia() {
        Console console = System.console();
        String op;
        console.printf("Hola!\n");
        do {
            op = console.readLine("(1) Nueva compra, (2) Listar Compras, (3) Alta cliente, (4) Salir: ");
            if (op.equals("1")) {
                console.printf("[+] Nueva compra\n");
                nuevaCompra(console);
            } else if (op.equals("2")) {
                console.printf("[+] Listar compras\n");
                listarCompras(console);
            } else if (op.equals("3")) {
                console.printf("[+] Alta cliente\n");
                altaCliente(console);
            } else if (op.equals("4"))
                console.printf("Bye!\n");
            else
                console.printf("Opcion no valida\n");
        } while (!op.equals("4"));
    }

    public void nuevaCompra(Console console) { this.nuevaCompra(console, ""); }

    public void nuevaCompra(Console console, String codigoCliente) {
        codigoCliente = (codigoCliente.isEmpty()) ? console.readLine("Introduce el código del cliente: "):codigoCliente;
        String codigoProducto = "";
        try {
            Cliente cliente = getClienteByCodigo(codigoCliente);
            Compra compra = new Compra(cliente);
            listaProductos = new ListadoProductos();
            do {
                codigoProducto = console.readLine("Introduzca el código del articulo o [F/f] para finalizar: ");
                if (!codigoProducto.toLowerCase().equals("f")) {
                    Producto producto = listaProductos.getProductoByCodigo(codigoProducto);
                    console.printf("%s - %s\n", producto.getDescripcionCorta(), producto.getPrecioSinIVA());
                    ArticuloCompra articulo;
                    if (producto.isGranel()) {
                        String peso = console.readLine("Producto a granel, indique el peso: ");
                        articulo = new ArticuloCompra(producto, peso);
                    } else {
                     articulo = new ArticuloCompra(producto);
                    }
                    compra.ponArticulo(articulo);
                }
            } while (!codigoProducto.toLowerCase().equals("f"));
            comprasRealizadas.add(compra);
            console.printf("\n\nTicket de compra numero: %d\n", comprasRealizadas.size());
            console.printf("*********************************\n");
            console.printf(getCabecera());
            console.printf(compra.generaTicket());
        } catch (ClienteException e) {
            console.printf("[!] Error: %s\n", e.getMessage());
            nuevaCompra(console);
        } catch (ProductoException e) {
            // if (!codigoProducto.toLowerCase().equals("f")) {
                console.printf("[!] Error: %s\n", e.getMessage());
                nuevaCompra(console, codigoCliente);

        } catch (NumberFormatException e) {
            console.printf("[!] Error: %s\n", e.getMessage());
            if (e.getMessage().startsWith("Codigo cliente"))
                nuevaCompra(console);
            if (e.getMessage().startsWith("Peso"))
                nuevaCompra(console, codigoCliente);
        }
    }

    public void listarCompras(Console console) {
        for (int i=0; i<comprasRealizadas.size(); i++)
            console.printf("%d - %s", i, comprasRealizadas.get(i).resumen());
    }

    // wraper de altaCliente para no tener que pasar strings vacias como argumentos
    public void altaCliente(Console console) { this.altaCliente(console, "", "", ""); }

    public void altaCliente(Console console, String nombre, String apellidos, String nif) {
        nombre = (nombre.isEmpty()) ? console.readLine("Introduzca el nombre del cliente: "):nombre;
        apellidos = (apellidos.isEmpty()) ? console.readLine("Introduzca los apellidos del cliente: "):apellidos;
        nif = (nif.isEmpty()) ? console.readLine("Introduzca el nif del cliente: "):nif;
        try {
            Cliente cliente = new Cliente(nombre, apellidos, nif);
            clientes.put(cliente.getCodigoCliente(), cliente);
            console.printf("[+] Cliente dado de alta\n");
            console.printf("%s\n", cliente);
        } catch (IllegalArgumentException e) {
            console.printf("[!] Error: %s\n", e.getMessage());
            if (e.getMessage().startsWith("Nombre"))
                altaCliente(console);
            else if (e.getMessage().startsWith("Apellidos"))
                altaCliente(console, nombre, "", "");
            else if (e.getMessage().startsWith("NIF"))
                altaCliente(console, nombre, apellidos, "");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CajaRegistradora t = new CajaRegistradora("", "974343434", "Empresa S.A", "C/ Tarragona 10");
        t.inicia();
    }
}
