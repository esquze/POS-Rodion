package at.bal;

import java.util.Objects;

public abstract class Boot implements Comparable<Boot> {
    private int maxPersonen;
    private String bezeichnung;

    public Boot(int maxPersonen, String bezeichnung) throws BootException {
        setMaxPersonen(maxPersonen);
        setBezeichnung(bezeichnung);
    }

    public int getMaxPersonen() {
        return maxPersonen;
    }

    public void setMaxPersonen(int maxPersonen) throws BootException {
        if (maxPersonen <= 0) {
            throw new BootException("Fehler: maxPersonen muss größer als 0 sein");
        }
        this.maxPersonen = maxPersonen;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) throws BootException {
        if (bezeichnung == null || bezeichnung.isEmpty()) {
            throw new BootException("Fehler: darf nicht null oder leer sein");
        }
        this.bezeichnung = bezeichnung;
    }

    public abstract double preis();

    public double preisProPerson() {
        return maxPersonen > 0 ? preis() / maxPersonen : 0.0;
    }

    @Override
    public int compareTo(Boot o) {
        return maxPersonen - o.getMaxPersonen();
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxPersonen, bezeichnung);
    }

    @Override
    public String toString() {
        return "Max. Personen: " + maxPersonen +
                ", Bezeichnung: " + bezeichnung +
                ", Preis: " + preis() + " EUR" +
                ", Preis pro Person: " + preisProPerson() + " EUR";
    }
}
