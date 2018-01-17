// package dam.m03.uf5.grupo8.tpv;

/**
 * Clase que representa a un producto de un comercio, con sus principales
 * atributos, métodos para acceder a éstos y un método estático para validar
 * códigos de barras
 * @author Juan
 */

public class Producto {
    /** Código de barras del producto */
    private String codigo;
    /** Text descriptivo del producto */
    private String descripcion;
    /** Precio unitario sin IVA */
    private double precioSinIVA;
    /** IVA aplicado al producto en tanto por ciento */
    private int IVA;
    /** Indica si es un producto a granel y por lo tanto pesable */
    private boolean granel;

    /**
     * Devuelve un nuevo objeto Producto con los parámetros proporcionados
     * @param codigo código de barras
     * @param descripcion texto con la descripción
     * @param precioSinIVA precio unitario sin aplicar IVA
     * @param IVA el tanto por ciento de IVA que se aplica al Producto
     * @param granel indica si es un Producto a granel
     * @throws ProductoException en caso de que el código de barras no tenga un
     * formato válido
     */
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

    /*
        Añadir los getters necesarios para los atributos
    */
    public String getCodigo() { return codigo; }
    public String getDescripcion() { return descripcion; }
    public double getPrecioSinIVA() { return precioSinIVA; }
    public boolean isGranel() { return granel; }

    /*
        Métodos adicionales
    */

    /**
     *
     * @return el precio del Producto aplicando el IVA
     */
    public double getPrecioConIVA() {
        return precioSinIVA * (IVA + 100) / 100;
    }

    /**
     *
     * @return los primeros 15 caracteres de la descripción del producto, útil
     * para la generación de tickets
     */
    public String getDescripcionCorta() {
        return descripcion.substring(0, 15);
    }

    /**
     * Verifica si un código es o no correcto. De momento sólo valida que hayan
     * 13 caracteres y los dos primeros sean 84.
     * @param codigo el código de barras a validar
     * @return true si el formato del código es válido
     */
    public static boolean esCodigoCorrecto(String codigo) {
        return codigo.matches("^84[0-9]{11}$");
    }
}
