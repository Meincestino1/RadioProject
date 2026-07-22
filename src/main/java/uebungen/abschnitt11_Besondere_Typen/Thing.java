package uebungen.abschnitt11_Besondere_Typen;

public class Thing {
    String name;

    @Override
    public String toString() {
        return "Thing{" + "name='" + name + '\'' + '}';
    }
}


class Appliance extends Thing {
    boolean isOn;
    double watt;

    @Override
    public String toString() {
        return "Appliance{" + "isOn=" + isOn + ", watt=" + watt + "} " + super.toString();
    }
}


class Radio extends Appliance {
    int volume;

    @Override
    public String toString() {
        return "Radio{" + "volume=" + volume + "} " + super.toString();
    }
}