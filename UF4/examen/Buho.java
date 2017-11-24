public class Buho extends Ave implements Carnivoro {
    public Buho(int v, String n) {
        super(v);
        nombre = n;
        this.sonido = "HUUHUU";
    }

    public void come() {
        System.out.println("Soy un buho y he cazado " + caza() + " calorias");
    }

    public int caza() {
        return 100;
    }
}
