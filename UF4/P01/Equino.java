public class Equino extends Animal {
    public Equino() {
        hambre = (int) (Math.random() * 10) + 1;
        System.out.println("Nace equino con hambre " + hambre);
    }
}
