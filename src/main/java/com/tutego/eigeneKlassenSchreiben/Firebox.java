package com.tutego.eigeneKlassenSchreiben;

public class Firebox extends ElectronicDevice {

    public Firebox() {

    }


    public void on() {
        on();
    }

    @Override
    void off() {
        System.out.println("A firebox is always on, you can't switch it off");
    }



}
