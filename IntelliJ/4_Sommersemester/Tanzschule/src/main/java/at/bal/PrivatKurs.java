package at.bal;

import java.io.Serializable;
import java.util.Objects;

public class PrivatKurs extends Kurs implements Serializable {

    private double preisProTag;

    public PrivatKurs(int dauer, double preisProTag) throws TanzschuleException {
        super(dauer);
        setPreisProTag(preisProTag);
    }

    public PrivatKurs(String line) throws TanzschuleException {
        super(line);
        String[] lineParts = line.trim().split(";");
        if (lineParts.length < 3) {
            throw new TanzschuleException("Fehler bei Kurs mit line " + line + ", hat zuwenige Informationen");
        }
        try {
            setPreisProTag(Double.parseDouble(lineParts[2]));
        } catch (NumberFormatException e) {
            throw new TanzschuleException("Fehler bei Kurs mit Preis pro Tag " + lineParts[2] + ", ist keine Zahl");
        }
    }

    public double getPreisProTag() {
        return preisProTag;
    }

    public void setPreisProTag(double preisProTag) throws TanzschuleException {
        if (preisProTag <= 0.0) {
            throw new TanzschuleException("Fehler: Dauer muss größer als 0.0 sein");
        }
        this.preisProTag = preisProTag;
    }

    @Override
    public double preis() {
        return getDauer() * preisProTag;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PrivatKurs that = (PrivatKurs) o;
        return Double.compare(preisProTag, that.preisProTag) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), preisProTag);
    }

    @Override
    public String toString() {
        return "PrivatKurs: " + super.toString() +
                ", Preis pro Tag: " + preisProTag + " EUR";
    }

    @Override
    public String toCsvString() {
        return super.toCsvString() + ";" + preisProTag;
    }

}
