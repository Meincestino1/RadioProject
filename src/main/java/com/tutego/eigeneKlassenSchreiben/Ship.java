package com.tutego.eigeneKlassenSchreiben;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.function.Predicate;

public class Ship {

    private final ArrayList<ElectronicDevice> devices = new ArrayList<>();

    private final static ElectronicDeviceWattComparator ELECTRONIC_DEVICE_WATT_COMPARATOR = new ElectronicDeviceWattComparator();
    private final static int MAXIMUM_POWER_CONSUMPTION = 1000;

    public void load(ElectronicDevice device) {
        Objects.requireNonNull(device);
        devices.add(device);
        devices.sort(ELECTRONIC_DEVICE_WATT_COMPARATOR);
    }

    public void holiday() {
        for (ElectronicDevice device : devices) {
            device.off();
        }
    }

    public void removePowerConsumingElectronicDevices() {
        class IsPowerConsumingElectronicDevice implements Predicate<ElectronicDevice> {
            @Override
            public boolean test(ElectronicDevice electronicDevice) {
                return electronicDevice.getWatt() > MAXIMUM_POWER_CONSUMPTION;
            }
        }
        devices.removeIf(new IsPowerConsumingElectronicDevice());
    }

    public ElectronicDevice findMostPowerConsumingElectronicDevice() {
        if (devices.isEmpty()) {
            throw new IllegalStateException("Ship has no devices, there can't be a maximum in an empty collection");
        }
        return Collections.max(devices, new ElectronicDeviceWattComparator());
    }

    public static int numberOfElectronicDevicesSwitchedOn(ElectronicDevice... devices) {
        int result = 0;
        for (ElectronicDevice device : devices) {
            if (device.isOn()) {
                result++;
            }
        }
        return result;
    }

    public int numberOfRadiosSwitchedOn() {
        int result = 0;

        for (ElectronicDevice device : devices ) {
            if (device.isOn()) {
                result++;
            }
        }
        return result;
    }

    public String toString() {
        return "Ship[" + devices + "]";
    }

}
