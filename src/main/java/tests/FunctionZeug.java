package tests;

import java.awt.geom.Point2D;
import java.time.LocalDate;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;
import java.util.function.*;


public class FunctionZeug {

    public record recordkackfuck(double longitude, double latitude) {
        Point2D.Double toPoint() {
            return new Point2D.Double(longitude, latitude);
        }

    }




    public static void main(String[] args) {




    }
}
