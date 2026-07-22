package tests;

public class Rekursiontest {

    public static String reverseString(String s) {
        return s.isEmpty() ? ""  : s.charAt(s.length() - 1) +reverseString(s.substring(0, s.length() - 1));
    }



    public static void main(String[] args) {
        System.out.println(reverseString("Michi"));
    }

}
