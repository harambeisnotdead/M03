package dam.m03.uf5.grupo8.tpv.modelo;

public class Producto {
    private String codigo;
    private String descripcion;
    private double precioSinIVA;
    private int IVA;
    private boolean granel;
    
    public Producto(String codigo, String descripcion, double precioSinIVA
            , int IVA, boolean granel) throws ProductoException {
        if (!esCodigoCorrecto(codigo))
            throw new ProductoException("Codigo mal formado");
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precioSinIVA = precioSinIVA;
        this.IVA = IVA;
        this.granel = granel;
    }

    public String getCodigo() { return codigo; }
    public String getDescripcion() { return descripcion; }
    public double getPrecioSinIVA() { return precioSinIVA; }
    public boolean isGranel() { return granel; }

    public double getPrecioConIVA() {
        return precioSinIVA * (IVA + 100) / 100;
    }

    public String getDescripcionCorta() {
        return descripcion.substring(0, 15);
    }

    public static boolean esCodigoCorrecto(String codigo) {
        return codigo.matches("^84[0-9]{11}$");
    }
    
    public String toString() {
        return String.format("%s,%s,%f,%d,%s\n", codigo, descripcion, 
                precioSinIVA, IVA, granel);
    }
}
