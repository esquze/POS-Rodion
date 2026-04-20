package at.bal;

import java.util.Objects;

public abstract class Maschine implements Comparable<Maschine> {
    private String name;
    private double preisEur;

    public Maschine(String name, double preisEur) {
        setName(name);
        setPreisEur(preisEur);
    }

    public double getPreisEur() {
        return preisEur;
    }

    public void setPreisEur(double preisEur) {
        if (preisEur <= 0.0) {
            throw new IllegalArgumentException("Fehler: muss größer 0.0 sein");
        }
        this.preisEur = preisEur;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Fehler: ist null oder leer");
        }
        this.name = name;
    }

    public abstract int wartungsIntervall();

    @Override
    public int compareTo(Maschine o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Maschine maschine = (Maschine) o;
        return Double.compare(preisEur, maschine.preisEur) == 0 && Objects.equals(name, maschine.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, preisEur);
    }

    @Override
    public String toString() {
        return name + ", " + preisEur + " EUR";
    }
}
