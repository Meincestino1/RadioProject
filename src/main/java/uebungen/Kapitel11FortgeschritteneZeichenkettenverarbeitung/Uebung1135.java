package uebungen.Kapitel11FortgeschritteneZeichenkettenverarbeitung;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Scanner;

public class Uebung1135 {

    public static void convertToSvg() {

        String filename = "coordinates.csv";
        try (InputStream is = new FileInputStream("C:/Users/Micha/Desktop/coordinates.csv");
             Scanner scanner = new Scanner(is, StandardCharsets.UTF_8)) {
            scanner.useDelimiter(",|\\s+").useLocale(Locale.ENGLISH);

            StringBuilder svg = new StringBuilder(1024);
            svg.append("<svg height=\"210\" width=\"500\">\n<polygon points=\"");

            while (scanner.hasNextDouble()) {
                double x = scanner.nextDouble();
                System.out.println("Des isch x: " + x);

                if (!scanner.hasNextDouble()) {
                    throw new IllegalStateException("Missing second coordinate");
                }
                double y = scanner.nextDouble();
                System.out.println("Des isch y: " + y);
                svg.append(x).append(",").append(y).append(" ");
            }
            svg.append("\" style=\"fill:line;stroke:purple;stroke-width:1\" />\n</svg>");
            System.out.println(svg);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        convertToSvg();
    }
}



