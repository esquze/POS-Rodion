package at.bal;

import java.time.Year;

public abstract class Messstation {

    private String standort;
    private Year installationsJahr;
    private double messwert;

    public Messstation(String standort, Year installationsJahr, double messwert) {
        setStandort(standort);
        setInstallationsJahr(installationsJahr);
        setMesswert(messwert);
    }

    public String getStandort() {
        return standort;
    }

    public void setStandort(String standort) {
        if (standort == null || standort.isBlank()) {
            throw new IllegalArgumentException("Fehler: null oder leer");
        }
        this.standort = standort;
    }

    public Year getInstallationsJahr() {
        return installationsJahr;
    }

    public void setInstallationsJahr(Year installationsJahr) {
        if (installationsJahr.getValue() <= 1880) {
            throw new IllegalArgumentException("Fehler: kleiner oder gleich 1880");
        }
        this.installationsJahr = installationsJahr;
    }

    public double getMesswert() {
        return messwert;
    }

    public void setMesswert(double messwert) {
        if (messwert < 0.0) {
            throw new IllegalArgumentException("Fehler: ist negtiv");
        }
        this.messwert = messwert;
    }

    public abstract double berechneUmweltIndex();
    public abstract String getStationTyp();

    public int compareTo(Messstation anderes) {
        return Double.compare(messwert, anderes.getMesswert());
    }

    @Override
    public String toString() {
        return "Messstation: " +
                "Standort: " + standort +
                ", Installationsjahr: " + installationsJahr +
                ", Messwert: " + messwert +
                ", Stationstyp: " + getStationTyp();
    }
}
