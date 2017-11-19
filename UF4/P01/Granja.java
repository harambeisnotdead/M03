public class Granja {
    Animal[] animales;
    int numObreros, numCrianza, forraje;

    public Granja(String tipo, int numObreros, int numCrianza, int forraje) {
        if (tipo.toLowerCase().equals("bovinos")) {
            animales = new Bovino[numObreros + numCrianza];
            for (int i=0; i<numObreros; i++)
                animales[i] = new BovinoObrero();
            for (int i=numObreros; i<animales.length; i++)
                animales[i] = new BovinoCrianza();
        } else if (tipo.toLowerCase().equals("equinos")) {
            animales = new Equino[numObreros + numCrianza];
            for (int i=0; i<numObreros; i++)
                animales[i] = new EquinoObrero();
            for (int i=numObreros; i<animales.length; i++)
                animales[i] = new EquinoCrianza();
        }
        this.numObreros = numObreros;
        this.numCrianza = numCrianza;
        this.forraje = forraje;
        System.out.format("Granja de %d %s y forraje %d creada\n",
                          animales.length, tipo, forraje);
    }

    public boolean comer() {
        for (Animal animal : animales) {
            if (forraje > 0) {
                forraje -= animal.comer();
                System.out.format("Un animal come %d de forraje, queda %d de "
                                  + "forraje \n", animal.hambre, forraje);
            } else {
                System.out.println("[!] La granja se ha quedado sin comida");
                return false;
            }
        }
        return true;
    }

    public void recolectar() {
        for (Animal animal : animales) {
            if (animal instanceof Obrero) {
                int recolecta = ((Obrero)animal).recolectar();
                forraje += recolecta;
                System.out.format("Un obrero recolecta %d de forraje, el "
                                  + "forraje sube a %d\n", recolecta, forraje);
            }
        }
    }
}
