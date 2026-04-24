package at.bal;

import java.util.Objects;

public class Haushaltspolizze extends Vertrag {

    private double quadratmeter;

    public Haushaltspolizze(double summe, double quadratmeter) throws VersicherungException {
        super(summe);
        setQuadratmeter(quadratmeter);
    }

    public void setQuadratmeter(double quadratmeter) throws VersicherungException {
        if (quadratmeter <= 0.0) {
            throw new VersicherungException("Fehler: muss größer als 0.0 sein");
        }
        this.quadratmeter = quadratmeter;
    }

    @Override
    public double berechnePreis() {
        return (quadratmeter / 100) * (getSumme() / 1000);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Haushaltspolizze that = (Haushaltspolizze) o;
        return Double.compare(quadratmeter, that.quadratmeter) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), quadratmeter);
    }

    @Override
    public String toString() {
        return "Haushaltspolizze: " + super.toString() +
                ", Quadratmeter: " + quadratmeter;
    }
}
