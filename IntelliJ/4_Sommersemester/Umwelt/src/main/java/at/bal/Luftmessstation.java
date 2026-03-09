package at.bal;

import java.time.Year;

public class Luftmessstation extends Messstation {

    private double feinstaubGrenzwert;

    public Luftmessstation(String standort, Year installationsJahr, double messwert, double feinstaubGrenzwert) {
        super(standort, installationsJahr, messwert);
        setFeinstaubGrenzwert(feinstaubGrenzwert);
    }

    @Override
    public double berechneUmweltIndex() {
        return getMesswert() / feinstaubGrenzwert;
    }

    @Override
    public String getStationTyp() {
        return "Luftmessstation";
    }

    public double getFeinstaubGrenzwert() {
        return feinstaubGrenzwert;
    }

    public void setFeinstaubGrenzwert(double feinstaubGrenzwert) {
        if (feinstaubGrenzwert <= 0.0) {
            throw new IllegalArgumentException("Fehler: kleiner oder gleich 0");
        }
        this.feinstaubGrenzwert = feinstaubGrenzwert;
    }

    @Override
    public String toString() {
        return "Luftmessstation: " + super.toString() +
                ", Feinstaub-Grenzwert: " + feinstaubGrenzwert;
    }
}
