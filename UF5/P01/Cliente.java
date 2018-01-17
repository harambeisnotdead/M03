// package dam.m03.uf5.grupo8.tpv;

import java.util.regex.Pattern;

/**
 * Clase que representa a un cliente, con sus principales atributos
 *
 * @author jmartin
 */
public class Cliente {
    /** nombre del cliente */
    private String nombre;
    /** apellidos del cliente */
    private String apellidos;
    /** nif del cliente */
    private String nif;
    /** codigo de cliente */
    private int codigoCliente;
    // Añado una variable estatica para poder asignar codigoCliente de manera incremental
    private static int numClientes;

    /**
     * Crea una nueva instancia, inicializada con los datos proporcionados.
     * Debe verificar que tanto el nombre como los apellidos sólo contengan
     * caracteres alfabéticos y que el nif tenga el formato correcto. En caso
     * contrario, debe lanzar una Excepción de tipo IllegalArgumentException.
     * El código de cliente es un número autoincremental diferente para cada
     * instancia que debe generarse en el constructor
     * @param nombre
     * @param apellidos
     * @param nif
     * @throws  IllegalArgumentException
     *          Si los parámetros no tienen el formato adecuado
     */
    public Cliente(String nombre, String apellidos, String nif)
            throws IllegalArgumentException {
        String alfaAndSpace = "^[a-zA-Z ]+$";
        this.nombre = (nombre.matches(alfaAndSpace)) ? nombre:"";
        this.apellidos = (apellidos.matches(alfaAndSpace)) ? apellidos:"";
        this.nif = (nif.matches("^[0-9]{8}[A-Z]$") && nifValido(nif)) ? nif:"";
        if (this.nombre.isEmpty())
            throw new IllegalArgumentException("Nombre mal formado");
        if (this.apellidos.isEmpty())
            throw new IllegalArgumentException("Apellidos mal formados");
        if (this.nif.isEmpty())
            throw new IllegalArgumentException("NIF mal formado");
        codigoCliente = ++numClientes;
    }

    /* Añadir los getters necesarios para cada atributo de un Cliente
       ! No añadir setters !
    */
    public int getCodigoCliente() { return codigoCliente; }

    /**
     *
     * @return una representación de los datos del cliente
     */
    public String toString(){
        return String.format("%s, %s    Código cliente: %d    NIF: %s"
                            , apellidos, nombre, codigoCliente, nif);
    }

    /**
     * Comprueba si un nif tiene un formato correcto
     * @param nif
     * @return true si el formato del nif es vàlido y false en caso contrario
     */
    private boolean nifValido(String nif){
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        char digito = nif.charAt(8);
        int numeros = Integer.parseInt(nif.substring(0, 8));
        return digito == letras.charAt(numeros % letras.length());
    }

}
