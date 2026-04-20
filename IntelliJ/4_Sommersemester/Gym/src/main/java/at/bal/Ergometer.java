package at.bal;

import java.util.Objects;

public class Ergometer extends Maschine{

    private int maxDrehzahl;

    public Ergometer(String name, double preisEur, int maxDrehzahl) {
        super(name, preisEur);
        setMaxDrehzahl(maxDrehzahl);
    }

    public int getMaxDrehzahl() {
        return maxDrehzahl;
    }

    public void setMaxDrehzahl(int maxDrehzahl) {
        if (maxDrehzahl < 5 || maxDrehzahl > 150) {
            throw new IllegalArgumentException("Fehler: muss zwischen 5 und 150 sein");
        }
        this.maxDrehzahl = maxDrehzahl;
    }

    @Override
    public int wartungsIntervall() {
        return 12;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Ergometer ergometer = (Ergometer) o;
        return maxDrehzahl == ergometer.maxDrehzahl;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), maxDrehzahl);
    }

    @Override
    public String toString() {
        return "Ergometer: " + super.toString() +
                ", Wartungsintervall: " + wartungsIntervall() +
                " Monate, max. Drehzahl: " + maxDrehzahl;
    }
}
