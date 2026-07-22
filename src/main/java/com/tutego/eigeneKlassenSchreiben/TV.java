package com.tutego.eigeneKlassenSchreiben;

public class TV extends ElectronicDevice {

    private boolean isOn;
    private MonitorTube monitorTube = new MonitorTube(this);

    @Override
    void on() {
        super.on();
        monitorTube.on();
    }

    @Override
    void off() {
        super.off();
        monitorTube.off();
    }

    public String toString() {
        return String.format("TV[on?=%s]", isOn);
    }

}
