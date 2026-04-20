package at.bal;

import java.util.Objects;

public class Beinpresse extends Maschine {
    private int maxGewicht;

    public Beinpresse(String name, double preisEur, int maxGewicht) {
        super(name, preisEur);
        setMaxGewicht(maxGewicht);
    }

    public int getMaxGewicht() {
        return maxGewicht;
    }

    public void setMaxGewicht(int maxGewicht) {
        if (maxGewicht < 100 || maxGewicht > 500) {
            throw new IllegalArgumentException("Fehler: muss zwischen 100 und 500 sein");
        }
        this.maxGewicht = maxGewicht;
    }

    @Override
    public int wartungsIntervall() {
        return 6;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Beinpresse that = (Beinpresse) o;
        return maxGewicht == that.maxGewicht;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), maxGewicht);
    }

    @Override
    public String toString() {
        return "Beinpresse: " + super.toString() +
                ", Wartungsintervall: " + wartungsIntervall() +
                " Monate, max. Gewicht: " + maxGewicht;
    }
}
