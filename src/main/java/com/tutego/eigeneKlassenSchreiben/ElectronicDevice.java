package com.tutego.eigeneKlassenSchreiben;

import java.util.Comparator;

public class ElectronicDevice {

    private boolean isOn;
    private int watt;

    public int getWatt() {
        return watt;
    }

    public void setWatt(int watt) {
        this.watt = watt;
    }

    void on() {
        isOn = true;
    }

    void off() {
        isOn = false;
    }

    boolean isOn() {
        return isOn;
    }

    public String toString() {
        return "ElectronicDevice[watt= " + watt / 1000 + "kw]";
    }

    // ElectronicDeviceWattComparator als statische geschachtelte Klasse:
    static class ElectronicDeviceWattComparator implements Comparator<ElectronicDevice> {
        @Override
        public int compare(ElectronicDevice ea1, ElectronicDevice ea2) {
            System.out.println(ea1 + " is compared with " + ea2);
            return Double.compare(ea1.getWatt(), ea2.getWatt());
        }
    }

    // ElectronicDeviceWattComparator als lokale Klasse
    public static void ElectronicWattComparatorKlasse() {
        class ElectronicDeviceWattComparator1 implements Comparator<ElectronicDevice> {
            @Override
            public int compare(ElectronicDevice ea1, ElectronicDevice ea2) {
                System.out.println(ea1 + " is compared with " + ea2);
                return Double.compare(ea1.getWatt(), ea2.getWatt());
            }
        }
    }


    // ElectronicDeviceWattComparator als anonyme innere Klasse:
    Comparator<ElectronicDevice> wattComparator = new Comparator<ElectronicDevice>() {
        @Override
        public int compare(ElectronicDevice ea1, ElectronicDevice ea2) {
            System.out.println(ea1 + " is compared with " + ea2);
            return Double.compare(ea1.getWatt(), ea2.getWatt());
        }
        };

}
