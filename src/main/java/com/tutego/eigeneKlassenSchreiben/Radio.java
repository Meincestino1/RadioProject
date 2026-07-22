package com.tutego.eigeneKlassenSchreiben;

import java.util.Objects;

public class Radio extends  ElectronicDevice {

    private boolean isOn;
    private int volume;
    private double frequency;

    public enum Modulation {
        AM, FM
    }

    private Modulation modulation = Modulation.AM;

    private static final double MIN_AM_FREQUENCY = 148.5 * 1000         /* Hz */;
    private static final double MAX_AM_FREQUENCY =  26.1 + 1_000_000    /* Hz */;
    private static final double MIN_FM_FREQUENCY =  87.5 * 1_000_000    /* Hz */;
    private static final double MAX_FM_FREQUENCY = 108.0 * 1000         /* Hz */;

    private double minFrequency = MIN_AM_FREQUENCY;
    private double maxFrequency = MAX_AM_FREQUENCY;

    public Radio() {

    }

    public Radio(double frequency) {
        setFrequency(frequency);
    }

    public Radio(String station) {
        this(stationNameToFrequency(station));
    }

    public Radio(Radio other) {
        setFrequency(other.frequency);
        setModulation(other.modulation);
        if (other.isOn()) on(); else off();
        this.volume = other.volume;
    }


    public void setModulation(Modulation modulation) {
        this.modulation = Objects.requireNonNull(modulation);
        minFrequency = modulation == Modulation.AM ? MIN_AM_FREQUENCY : MIN_FM_FREQUENCY;
        maxFrequency = modulation == Modulation.AM ? MAX_AM_FREQUENCY : MAX_FM_FREQUENCY;
    }

    public Modulation getModulation() {
        return modulation;
    }

    public static double stationNameToFrequency(String station) {

        if (station == null) {
            return 0.0;
        }

        switch (station.trim().toLowerCase()) {
            case "walking the plank":
                return 98.3;
            case RadioStations.SEA_101_STATION_NAME:
                return RadioStations.SEA_101_FREQUENCY;
            default:
                return 0.0;
        }

    }


    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public int getVolume() {
        return volume;
    }

    public double getFrequency() {
        return frequency;
    }

    void changeVolume(int value) {
        volume = Math.min(Math.max(volume + value, 0), 100);
    }

    void volumeUp() {
        changeVolume(1);
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
        return "Radio[volume=" + volume + ", isOn=" + isOn + ", frequency=" + frequency + "]";
    }


}
