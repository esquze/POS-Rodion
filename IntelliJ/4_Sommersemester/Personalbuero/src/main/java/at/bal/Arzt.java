package at.bal;

import java.time.Year;
import java.util.Objects;

public class Arzt extends Mitarbeiter {
    private int wochenStunden;
    private double fixum;

    public Arzt(String name, Year gebJahr, Year eintrJahr, int wochenStunden, double fixum) {
        super(name, gebJahr, eintrJahr);
        setWochenStunden(wochenStunden);
        setFixum(fixum);
    }

    public int getWochenStunden() {
        return wochenStunden;
    }

    public void setWochenStunden(int wochenStunden) {
        if (wochenStunden <= 0) {
            throw new IllegalArgumentException("Fehler: 0 oder kleiner");
        }
        this.wochenStunden = wochenStunden;
    }

    public double getFixum() {
        return fixum;
    }

    public void setFixum(double fixum) {
        if (fixum <= 0.0) {
            throw new IllegalArgumentException("Fehler: 0.0 oder kleiner");
        }
        this.fixum = fixum;
    }

    @Override
    public double berechneGehalt() {
        return fixum;
    }

    public double berechneStundensatz() {
        return fixum / wochenStunden;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Arzt arzt = (Arzt) o;
        return wochenStunden == arzt.wochenStunden && Double.compare(fixum, arzt.fixum) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + wochenStunden;
        result = 31 * result + Double.hashCode(fixum);
        return result;
    }

    @Override
    public String toString() {
        return "Arzt: " + super.toString() +
                ", Wochenstunden: " + wochenStunden +
                ", Fixum: " + fixum;
    }
}
