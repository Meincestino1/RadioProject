package com.tutego.eigeneKlassenSchreiben;

public class MonitorTube {

    private final TV tv;

    public MonitorTube(TV tv) {
        this.tv = tv;
    }

    public TV getTv() {
        return tv;
    }

    public void on() {
        System.out.println("Tube is on.");
    }

    public void off() {
        System.out.println("Tube is off.");
    }

}
