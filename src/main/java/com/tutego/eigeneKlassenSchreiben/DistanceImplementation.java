package com.tutego.eigeneKlassenSchreiben;

public class DistanceImplementation implements Distance{

    private final int value;

    DistanceImplementation(int value) {
        this.value = value;
    }

    @Override
    public int meter() {
        return value;
    }
}
