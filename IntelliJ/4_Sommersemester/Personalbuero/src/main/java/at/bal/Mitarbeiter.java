package at.bal;

import java.time.Year;

public class Mitarbeiter {

    private String name;
    private Year gebJahr;
    private Year eintrJahr;

    public Mitarbeiter(String name, Year gebJahr, Year eintrJahr) {
        setName(name);
        setGebJahr(gebJahr);
        setEintrJahr(eintrJahr);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Year getGebJahr() {
        return gebJahr;
    }

    public void setGebJahr(Year gebJahr) {
        if (gebJahr == null) {
            throw new IllegalArgumentException("Fehler null");
        }
        if (gebJahr.isAfter(Year.now())) {
            throw new IllegalArgumentException("Fehler: leigt in der Zukunft");
        }
        this.gebJahr = gebJahr;
    }

    public Year getEintrJahr() {
        return eintrJahr;
    }

    public void setEintrJahr(Year eintrJahr) {
        if (eintrJahr == null) {
            throw new IllegalArgumentException("Fehler null");
        }
        if (eintrJahr.isAfter(Year.now())) {
            throw new IllegalArgumentException("Fehler: leigt in der Zukunft");
        }
        this.eintrJahr = eintrJahr;
    }

    public int berechneAlter() {
        return Year.now().getValue() - gebJahr.getValue();
    }

    public int berechneDienstalter() {
        return Year.now().getValue() - eintrJahr.getValue();
    }

    public double berechneGehalt() {
        return 1500.0 + berechneDienstalter()*50.0;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                ", Geb.Jahr: " + gebJahr +
                ", Alter: " + berechneAlter() +
                ", Eintr.Jahr: " + eintrJahr +
                ", Dienstalter: " + berechneDienstalter() +
                ", Gehalt: " + berechneGehalt();
    }

    public void print(){
        System.out.println(this);
    }
}
