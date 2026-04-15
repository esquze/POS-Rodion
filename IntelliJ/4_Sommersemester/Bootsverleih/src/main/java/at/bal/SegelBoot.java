package at.bal;

import java.util.Objects;

public class SegelBoot extends Boot {
    private double preisProPerson;
    private boolean lizenz;

    public SegelBoot(int maxPersonen, String bezeichnung, double preisProPerson, boolean lizenz) throws BootException {
        super(maxPersonen, bezeichnung);
        setPreisProPerson(preisProPerson);
        setLizenz(lizenz);
    }

    public double getPreisProPerson() {
        return preisProPerson;
    }

    public void setPreisProPerson(double preisProPerson) throws BootException {
        if (preisProPerson <= 0.0) {
            throw new BootException("Fehler: muss größer als 0.0 sein");
        }
        this.preisProPerson = preisProPerson;
    }

    public boolean isLizenz() {
        return lizenz;
    }

    public void setLizenz(boolean lizenz) {
        this.lizenz = lizenz;
    }

    private String lizensCheck() {
        if (lizenz == true) {
            return "mit Lizenz";
        }
        return "ohne Lizenz";
    }

    @Override
    public double preis() {
        return getMaxPersonen() * preisProPerson;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SegelBoot segelBoot = (SegelBoot) o;
        return Double.compare(preisProPerson, segelBoot.preisProPerson) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), preisProPerson);
    }

    @Override
    public String toString() {
        return "SegelBoot: " + super.toString() +
                ", " + lizensCheck();
    }
}
