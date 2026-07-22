package tests;

public class NumberTestKla {

    public static void main(String[] args) {

        boolean b = true;

        Integer i = 1;
        Double d = 0.1;

        System.out.println( b ? i : d); // 1.0
        System.out.println(!b ? i : d); // 0.1

        Number n1 = b ? i : d;
        System.out.println(n1); // 1.0
        System.out.println(n1 == i); // false

        System.out.println(i.getClass().getSimpleName());
        System.out.println(n1.getClass().getSimpleName());

        Integer x = 1;
        Integer y = -2;
        int sj = x.compareTo(y);
        System.out.println(x.compareTo(y));
        byte s = 1;
        byte t = -2;
        System.out.println(Byte.compare(s, t));

        System.out.println(Boolean.TRUE.equals(Boolean.FALSE));

        int unsignedInt = Byte.toUnsignedInt((byte) -1);
        String unsignedString = Integer.toUnsignedString(-1);
        System.out.println(unsignedString);

        Boolean x1 = Boolean.TRUE;
        Boolean x2 = true;

    }


}
