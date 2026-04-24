package at.bal;

import java.util.Objects;

public abstract class Vertrag {
    private double summe;

    public Vertrag(double summe) throws VersicherungException {
        setSumme(summe);
    }

    public double getSumme() {
        return summe;
    }

    public void setSumme(double summe) throws VersicherungException {
        if (summe > 0.0) {
            throw new VersicherungException("Fehler: muss größer als 0.0 sein");
        }
        this.summe = summe;
    }

    public abstract double berechnePreis();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vertrag vertrag = (Vertrag) o;
        return Double.compare(summe, vertrag.summe) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(summe);
    }

    @Override
    public String toString() {
        return "Summe: " + summe + " EUR, " +
                "Preis: " + berechnePreis() + " EUR";
    }
}
