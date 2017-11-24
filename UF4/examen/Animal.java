public abstract class Animal {
    protected String sonido;
    protected String nombre;
    protected int velocidad;

    public Animal() {
        this.sonido = "";
        this.nombre = "";
        this.velocidad = 0;
    }

    public abstract void come();

    public abstract void desplaza();

    public String toString() {
        return "Me llamo " + nombre + " y hago " + sonido;
    }
}
