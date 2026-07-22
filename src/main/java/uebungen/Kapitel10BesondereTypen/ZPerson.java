package uebungen.Kapitel10BesondereTypen;

import java.util.Objects;

public class ZPerson {

    public long id;
    public int age;
    public double income;
    public boolean isDrugLord;
    public String name;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZPerson person = (ZPerson) o;
        return id == person.id && age == person.age && Double.compare(income, person.income) == 0 && isDrugLord == person.isDrugLord && Objects.equals(name, person.name);
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
