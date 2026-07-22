package com.tutego.eigeneKlassenSchreiben;

public interface Distance {

    static Distance ofMeter(int value) {
        return new DistanceImplementation(value);
    }

    static Distance ofKilometer(int value) {
        return new DistanceImplementation(value * 1000);
    }

    int meter();

    default int kilometer() {
        return meter() / 1000;
    }
}
