public abstract class Mamifero extends Animal {
    public Mamifero(int v) {
        velocidad = v;
    }

    public void desplaza() {
        System.out.println("Soy un mamifero y camino a "+ velocidad + " km/h");
    }
}
