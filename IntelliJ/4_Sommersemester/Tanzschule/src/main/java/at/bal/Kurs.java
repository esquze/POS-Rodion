package at.bal;

import java.util.Objects;

public abstract class Kurs {

    private int dauer;

    public Kurs(int dauer) throws TanzschuleException {
        setDauer(dauer);
    }

    public Kurs(String line) throws TanzschuleException {
        if (line == null) {
            throw new TanzschuleException("Fehler bei Kurs mit line " + line + ", ist kein Kurs");
        }
        String[] lineParts = line.trim().split(";");
        if (lineParts.length < 2) {
            throw new TanzschuleException("Fehler bei Kurs mit line " + line + ", hat zuwenige Informationen");
        }
        try {
            setDauer(Integer.parseInt(lineParts[1]));
        } catch (NumberFormatException e) {
            throw new TanzschuleException("Fehler bei Kurs mit Dauer " + lineParts[1] + ", ist keine Zahl");
        }
    }

    public int getDauer() {
        return dauer;
    }

    public void setDauer(int dauer) throws TanzschuleException {
        if (dauer <= 0) {
            throw new TanzschuleException("Fehler: Dauer muss größer als 0 sein");
        }
        this.dauer = dauer;
    }

    public abstract double preis();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Kurs kurs = (Kurs) o;
        return dauer == kurs.dauer;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(dauer);
    }

    @Override
    public String toString() {
        return "Dauer: " + dauer;
    }

    public String toCsvString() {
        return getClass().getSimpleName() + ";" + dauer;
    }

}
