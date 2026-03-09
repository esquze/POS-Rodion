package at.bal;

import java.time.Year;

public class Laermmessstation extends Messstation{

    private double maxErlaubterPegel;

    public Laermmessstation(String standort, Year installationsJahr, double messwert) {
        super(standort, installationsJahr, messwert);
        setMaxErlaubterPegel(maxErlaubterPegel);
    }

    @Override
    public double berechneUmweltIndex() {
        return getMesswert() - maxErlaubterPegel;
    }

    @Override
    public String getStationTyp() {
        return "Laermmessstation";
    }

    public double getMaxErlaubterPegel() {
        return maxErlaubterPegel;
    }

    public void setMaxErlaubterPegel(double maxErlaubterPegel) {
        if (maxErlaubterPegel <= 0.0) {
            throw new IllegalArgumentException("Fehler: kleiner oder gleich null");
        }
        this.maxErlaubterPegel = maxErlaubterPegel;
    }

    @Override
    public String toString() {
        return "Laermmessstation: " + super.toString() +
                ", Max erlaubten Pegel: " + maxErlaubterPegel;
    }
}
