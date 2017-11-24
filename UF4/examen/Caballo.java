public class Caballo extends Mamifero implements Herbivoro {
    public Caballo(int v, String n) {
        super(v);
        nombre = n;
        sonido = "HIIIII";
    }

    public void come() {
        System.out.println("Soy un caballo y he pastado " + pasta() + " calorias");
    }

    public int pasta() {
        return 2000;
    }
}
