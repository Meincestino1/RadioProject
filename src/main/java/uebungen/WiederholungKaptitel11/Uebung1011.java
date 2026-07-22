package uebungen.WiederholungKaptitel11;

import java.util.Objects;

public class Uebung1011 {

    public long id;
    public int age;
    public double income;
    public boolean isDrugLord;
    public String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Uebung1011 that = (Uebung1011) o;
        return id == that.id && age == that.age && Double.compare(income, that.income) == 0 && isDrugLord == that.isDrugLord && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        int result = Long.hashCode(id);
        result = 31 * result + age;
        result = 31 * result + Double.hashCode(income);
        result = 31 * result + Boolean.hashCode(isDrugLord);
        result = 31 * result + Objects.hashCode(name);
        return result;
    }
}
