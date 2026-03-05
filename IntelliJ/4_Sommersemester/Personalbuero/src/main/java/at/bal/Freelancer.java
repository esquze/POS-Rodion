package at.bal;

import java.time.Year;
import java.util.Objects;

public class Freelancer extends Mitarbeiter{
    private double stundenSatz;
    private int stunden;

    public Freelancer() {
        super("Anna", Year.of(2001), Year.now());
        setStundenSatz(100.0);
        setStunden(10);
    }

    public Freelancer(String name, Year gebJahr, Year eintrJahr, double stundenSatz, int stunden) {
        super(name, gebJahr, eintrJahr);
        setStundenSatz(stundenSatz);
        setStunden(stunden);
    }

    public double getStundenSatz() {
        return stundenSatz;
    }

    public void setStundenSatz(double stundenSatz) {
        if (stundenSatz <= 0.0) {
            throw new IllegalArgumentException("Fehler: 0.0 oder kleiner");
        }
        this.stundenSatz = stundenSatz;
    }

    public int getStunden() {
        return stunden;
    }

    public void setStunden(int stunden) {
        if (stunden <= 0) {
            throw new IllegalArgumentException("Fehler: 0 oder kleiner");
        }
        this.stunden = stunden;
    }

    @Override
    public double berechneGehalt() {
        return stunden * stundenSatz;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Freelancer that = (Freelancer) o;
        return Double.compare(stundenSatz, that.stundenSatz) == 0 && stunden == that.stunden;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Double.hashCode(stundenSatz);
        result = 31 * result + stunden;
        return result;
    }

    @Override
    public String toString() {
        return "Freelancer: " + super.toString() +
                ", Stundensatz: " + stundenSatz +
                ", Stunden: " + stunden;
    }
}
