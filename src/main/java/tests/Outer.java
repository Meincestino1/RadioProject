package tests;

// Outer.java


public class Outer {
    private String secret = "top-secretWSNF";

    class Inner {
        void printSecret() {
            System.out.println("Inner sees: " + secret);
        }
    }

    public static void main(String[] args) {
        new Outer().new Inner().printSecret();
    }
}

