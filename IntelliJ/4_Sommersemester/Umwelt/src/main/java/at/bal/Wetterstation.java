package at.bal;

import java.time.Year;

public class Wetterstation extends Messstation {

    private double temperatur;

    public Wetterstation(String standort, Year installationsJahr, double messwert) {
        super(standort, installationsJahr, messwert);
        setTemperatur(temperatur);
    }

    @Override
    public double berechneUmweltIndex() {
        return 0;
    }

    @Override
    public String getStationTyp() {
        return "Wetterstation";
    }

    public double getTemperatur() {
        return temperatur;
    }

    public void setTemperatur(double temperatur) {
        if (temperatur < -200 || temperatur > 200) {
            throw new IllegalArgumentException("Fehler: kleiner als -200 oder größer als 200");
        }
        this.temperatur = temperatur;
    }

    @Override
    public String toString() {
        return "Wetterstation: " + super.toString() +
                ", Temperatur: " + temperatur;
    }
}
