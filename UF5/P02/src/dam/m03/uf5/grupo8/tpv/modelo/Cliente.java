package dam.m03.uf5.grupo8.tpv.modelo;

public class Cliente {
    private String nombre;
    private String apellidos;
    private String nif;
    private int codigoCliente;

    private static int numClientes;

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

    public int getCodigoCliente() { return codigoCliente; }
    public String getNif() { return nif; }

    public String toString(){
        return String.format("%s, %s    Código cliente: %d    NIF: %s"
                            , apellidos, nombre, codigoCliente, nif);
    }
    
    public String toCSVString() {
        return String.format("%s,%s,%s\n", nombre, apellidos, nif);
    }

    private boolean nifValido(String nif){
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        char digito = nif.charAt(8);
        int numeros = Integer.parseInt(nif.substring(0, 8));
        return digito == letras.charAt(numeros % letras.length());
    }
}
