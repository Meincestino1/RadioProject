package com.tutego.eigeneKlassenSchreiben;

public class Tracer {

    private static boolean tracingIsOn;

    public static void on() {
        tracingIsOn = true;
    }

    public static void off() {
        tracingIsOn = false;
    }

    public static void trace(String msg) {
        if (tracingIsOn) {
            System.out.println(msg);
        }
    }

    public static void trace(String format, Object... args) {
        if (tracingIsOn) {
            System.out.printf(format + "%n", args);
        }
    }


}
