package tests;

public class Schnittstellentester {

    interface TestInterface {
        static int testDefaultInterfaceMethode() {
            return 88;
        }


    }

    static int boh = TestInterface.testDefaultInterfaceMethode();

    public static void main(String[] args) {
        System.out.println(boh);
    }

}
