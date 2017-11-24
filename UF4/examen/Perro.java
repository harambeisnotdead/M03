public class Perro extends Mamifero implements Carnivoro {
    public Perro(int v, String n) {
        super(v);
        nombre = n;
        sonido = "GUAU";
    }

    public void come() {
        System.out.println("Soy un perro y he cazado " + caza() + " calorias");
    }

    public int caza() {
        return 500;
    }
}
