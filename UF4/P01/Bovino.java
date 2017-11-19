public class Bovino extends Animal {
    public Bovino() {
        hambre = (int) (Math.random() * 5) + 1;
        System.out.println("Nace bovino con hambre " + hambre);
    }
}
