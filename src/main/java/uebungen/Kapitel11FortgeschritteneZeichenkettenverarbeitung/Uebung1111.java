package uebungen.Kapitel11FortgeschritteneZeichenkettenverarbeitung;

public class Uebung1111 {

    public static void createAsciiTable() {
        System.out.println("Dec Hex   Dec Hex   Dec Hex   Dec Hex   Dec Hex   Dec Hex");
        for(int row = 0; row < 16; row ++) {
            for (int asciiCode = 32 + row; asciiCode <= 127; asciiCode += 16) {
                System.out.printf("%1$3d %1$X %2$s  ", asciiCode, asciiCode == 127 ? "Del" : Character.toString(asciiCode));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        createAsciiTable();

    }

}
