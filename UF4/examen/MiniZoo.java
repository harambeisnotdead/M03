import java.util.Scanner;

public class MiniZoo {
    Animal[] todosLosAnimales;
    int numCaballos, numPerros, numGallinas, numBuhos;

    public MiniZoo(){
        String nom; // Aquí guardarem el nom dels animals

        Scanner teclado = new Scanner(System.in);

        // Obtenim la quantitat d'animals de cada tipus:
        System.out.print("Cuantos caballos quieres? ");
        numCaballos = teclado.nextInt();
        if(numCaballos < 0) numCaballos = 0; // ens assegurem que sigui un nombre no negatiu

        System.out.print("Cuantos perros quieres? ");
        numPerros = teclado.nextInt();
        if(numPerros < 0) numPerros = 0; // ens assegurem que sigui un nombre no negatiu

        System.out.print("Cuantas gallinas quieres? ");
        numGallinas = teclado.nextInt();
        if(numGallinas < 0) numGallinas = 0; // ens assegurem que sigui un nombre no negatiu

        System.out.print("Cuantos buhos quieres? ");
        numBuhos = teclado.nextInt();
        if(numBuhos < 0) numBuhos = 0; // ens assegurem que sigui un nombre no negatiu

        // Generem l'array per poder emmagatzemar tots els animals junts:
        todosLosAnimales = new Animal[numCaballos+numPerros+numGallinas+numBuhos];

        teclado.nextLine(); // Hi ha problemes amb l'Scanner. Fent nextLine() no se salta el primer nom d'animal

        // Anem tipus d'animal per tipus d'animal
        // Per cada animal, demanem el seu nom.
        // Generem l'animal i el guardem en l'array d'animals, en la seva posició.
        // La velocitat és sempre la mateixa per tots els animals d'aquell tipus.
        if (numCaballos > 0) {
            System.out.println("Introduciremos " + numCaballos + " caballo" + (numCaballos==1?"":"s") + ".");
            for(int i=0; i<numCaballos; i++){
                System.out.print("Como quieres que se llame el caballo" + (numCaballos==1?"":" "+(i+1)) + " ? ");
                nom = teclado.nextLine();
                todosLosAnimales[i] = new Caballo(70, nom);
            }
        } else {
            System.out.println("No hay caballos.");
        }

        if (numPerros > 0) {
            System.out.println("Introduciremos " + numPerros + " perro" + (numPerros==1?"":"s") + ".");
            for(int i=0; i<numPerros; i++){
                System.out.print("Como quieres que se llame el perro" + (numPerros==1?"":" "+(i+1)) + " ? ");
                nom = teclado.nextLine();
                todosLosAnimales[numCaballos+i] = new Perro(70, nom);
            }
        } else {
            System.out.println("No hay perros.");
        }

        if (numGallinas > 0) {
            System.out.println("Introduciremos " + numGallinas + " gallina" + (numGallinas==1?"":"s") + ".");
            for (int i=0; i<numGallinas; i++) {
                System.out.print("Como quieres que se llame la gallina" + (numGallinas==1?"":" "+(i+1)) + " ? ");
                nom = teclado.nextLine();
                todosLosAnimales[numCaballos+numPerros+i] = new Gallina(5, nom);
            }
        } else {
            System.out.println("No hay galllinas.");
        }

        if (numBuhos > 0 ) {
            System.out.println("Introduciremos " + numBuhos + " buho" + (numBuhos==1?"":"s") + ".");
            for (int i=0; i<numBuhos; i++) {
                System.out.print("Como quieres que se llame el buho" + (numBuhos==1?"":" "+(i+1)) + " ? ");
                nom = teclado.nextLine();
                todosLosAnimales[numCaballos+numPerros+numGallinas+i] = new Buho(65, nom);
            }
        } else {
            System.out.println("No hay buhos.");
        }
    }

    public void muestra() {
        int numAnimales = numCaballos + numPerros + numGallinas + numBuhos;

        // Passem animal per animal, sigui del tipus que sigui, i cridem els tres mètodes definits:
        for (int i= 0; i<numAnimales; i++) {
            System.out.println(todosLosAnimales[i]); // Aquí es crida a toString()
            todosLosAnimales[i].desplaza();
            todosLosAnimales[i].come();
        }
    }

    public static void main(String[] args) {
        // Generem el MiniZoo
        //    (En el constructor està tota la introducció de dades per teclat.)
        MiniZoo mz = new MiniZoo();

        // Mostrem tots els animals del minizoo:
        mz.muestra();
    }
}
