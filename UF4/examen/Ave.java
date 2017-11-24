public abstract class Ave extends Animal {
    public Ave(int v) {
        velocidad = v;
    }

    public void desplaza() {
        System.out.println("Soy un ave y vuelo a "+ velocidad + " km/h");
    }
}
