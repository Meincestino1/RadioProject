package tests;

public class GetCauseTest {

    public static void testMethode() {
        try {
            try {
                System.out.println(5 );
            } catch (ArithmeticException e) {
                throw new RuntimeException("Fehler aufgetreten", e);
            }
        } catch (RuntimeException e) {
            System.err.println("Cause: " + e.getCause()); // zeigt die ursprüngliche ArithmeticException
        }
    }

    public static void main(String[] args) {
        testMethode();

        int vari = 1;
        assert vari > 10 : "Focknfock";
    }
}
