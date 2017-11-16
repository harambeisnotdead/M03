public class Granja {
    Animal[] animales;
    int numObreros, numCrianza, forraje;

    public Granja(String tipo, int numObreros, int numCrianza, int forraje) {
        // TODO instanciar animales
        if (tipo.toLowerCase().equals("bovino")) {
            animales = new Bovino[numObreros + numCrianza];
        } else if (tipo.toLowerCase().equals("equino")) {
            animales = new Equino[numObreros + numCrianza];
        }
        this.numObreros = numObreros;
        this.numCrianza = numCrianza;
        this.forraje = forraje;
    }

    private void instanciarAnimales() {
        // TODO
        for (int i=0; i<animales.length; i++) {
            for (int o=0; o<numObreros; o++) {

            }
            for (int c=0; c<numCrianza; c++) {

            }
        }
    }

    public boolean comer() {
        // TODO revisar
        for (Animal animal : animales) {
            if (forraje > 0) {
                forraje -= animal.comer();
            } else return false;
        }
        return true;
    }

    public void recolectar() {
        // TODO
        for (Animal animal : animales) {
            if (animal instanceof Obrero) {
                // animal.recolectar();
            }
        }
    }
}
