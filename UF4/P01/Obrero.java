public interface Obrero {
    default public int recolectar() {
        return (int) (Math.random() * 30) + 1;
    }
}
