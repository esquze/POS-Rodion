package at.bal;

import java.io.Serializable;
import java.util.Objects;

public class GruppenKurs extends Kurs implements Serializable {

    private double preisPauschal;

    public GruppenKurs(int dauer, double preisPauschal) throws TanzschuleException {
        super(dauer);
        setPreisPauschal(preisPauschal);
    }

    public GruppenKurs (String line) throws TanzschuleException {
        super(line);
        String[] lineParts = line.trim().split(";");
        if (lineParts.length < 3) {
            throw new TanzschuleException("Fehler bei Kurs mit line " + line + ", hat zuwenige Informationen");
        }
        try {
            setPreisPauschal(Double.parseDouble(lineParts[2]));
        } catch (NumberFormatException e) {
            throw new TanzschuleException("Fehler bei Kurs mit Preis pauschal " + lineParts[2] + ", ist keine Zahl");
        }
    }

    public double getPreisPauschal() {
        return preisPauschal;
    }

    public void setPreisPauschal(double preisPauschal) throws TanzschuleException {
        if (preisPauschal <= 0.0) {
            throw new TanzschuleException("Fehler: Dauer muss größer als 0.0 sein");
        }
        this.preisPauschal = preisPauschal;
    }

    @Override
    public double preis() {
        return preisPauschal;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GruppenKurs that = (GruppenKurs) o;
        return Double.compare(preisPauschal, that.preisPauschal) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), preisPauschal);
    }

    @Override
    public String toString() {
        return "GruppenKurs: " + super.toString() +
                ", Preis Pauschal: " + preisPauschal + " EUR";
    }

    @Override
    public String toCsvString() {
        return super.toCsvString() + ";" + preisPauschal;
    }

}
