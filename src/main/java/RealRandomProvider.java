public class RealRandomProvider implements RandomProvider {

    private final java.util.Random random = new java.util.Random();

    public int nextInt(int bound) {
        return random.nextInt(bound);
    }
}