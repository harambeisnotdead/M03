public class Granja {
    Animal animales[];
    int numObreros, numCrianza, forraje;

    public Granja(
            String tipo, int numObreros,
            int numCrianza, int forraje) {
        if (tipo=="bovino") {
            animales = new Bovino[numObreros + numCrianza];
        } else if (tipo=="equino") {
            animales = new Equino[numObreros + numCrianza];
        }
        this.numObreros = numObreros;
        this.numCrianza = numCrianza;
        this.forraje = forraje;
    }

    public boolean comer() {
        //revisar
        for (Animal animal : animales) {
            if (forraje > 0) {
                forraje -= animal.comer();
            } else return false;
        }
        return true;
    }

    public void recolectar() {
        for (Animal animal : animales) {
            if (animal instanceof Obrero) {
                // revisar
                // animal.recolectar();
            }
        }
    }
}
