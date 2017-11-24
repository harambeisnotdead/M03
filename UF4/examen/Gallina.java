public class Gallina extends Ave implements Herbivoro {
    public Gallina(int v, String n) {
        super(v);
        nombre = n;
        sonido = "CLOCLOCLO";
    }

    public void come() {
        System.out.println("Soy un gallina y he pastado " + pasta() + " calorias");
    }

    public int pasta() {
        return 50;
    }
}
