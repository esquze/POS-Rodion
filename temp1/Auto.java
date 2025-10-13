import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

public class Auto {
    private String name;
    private int eigengewicht;
    private Person fahrer;
    private Person beifahrer;
    private Person rueckbank;

    public Auto() {
        setName("n/a");
        setEigengewicht(1300);
    }

    public Auto(String name, int eigengewicht) {
        setName(name);
        setEigengewicht(eigengewicht);
    }

    public String getName() {
        return name;
    }

    public int getEigengewicht() {
        return eigengewicht;
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        } else {
            System.out.println("Fehler: kein Name!");
            this.name = "n/a";
        }
    }

    public void setEigengewicht(int eigengewicht) {
        if ((eigengewicht >= 600) && (eigengewicht <= 3000)) {
            this.eigengewicht = eigengewicht;
        } else {
            System.out.println("Fehler: kein gültiges Eigengewicht (600..3000)!");
            this.eigengewicht = 1300;
        }
    }

    public void einsteigen(Person person) {
        // 1. Prüfung ob Referenz person nicht null
        if (person != null) 
        {
            if (this.fahrer == null) {

                this.fahrer = person; // this kann man hier weglassen

            } else if (this.beifahrer == null) {

                this.beifahrer = person;

            } else if (this.rueckbank == null) {

                this.rueckbank = person;

            } else {
                throw new IllegalArgumentException("Es gibt keine freien Plätze");
            }
        } else { 
            // entsprechende Fehlermeldung
            throw new IllegalArgumentException("Person existiert nicht");
        }
    }

    public void aussteigenFahrer() {
        fahrer = null;
    }

    public void aussteigenBeifahrer() {
        beifahrer = null;
    }

    public void aussteigenRueckbank() {
        rueckbank = null;
    }

    public void aussteigen(Person person) {
        if (person != null) {
            if (this.fahrer == person) {
                aussteigenFahrer();
            } else if (this.beifahrer == person) {
                aussteigenBeifahrer();
            } else if (this.rueckbank == person) {
                aussteigenRueckbank();
            } else {
                throw new IllegalArgumentException("Er kann von nirgends aussteigen");

            }
        } else {
            throw new IllegalArgumentException("Person existiert nicht");
        }
    }

    public void aussteigen(String name) {
        if (name != null) {
            // Achtung: String-Vergleich immer mit der equals-Methode
            if (this.fahrer != null && name.equals(fahrer.getName())) {
                aussteigenFahrer();
            } else if (this.beifahrer != null && name.equals(beifahrer.getName())) {
                aussteigenBeifahrer();
            } else if (this.rueckbank != null && name.equals(rueckbank.getName())) {
                aussteigenRueckbank();
            } else {
                System.out.println("Fehler: Person nicht im Fahrzeug.");
            }
        } else {
            System.out.println("Fehler: name ist null.");
        }
    }

    public int gesamtGewicht() {
        int gesamtGewicht = getEigengewicht();
        if (this.fahrer != null) {
            gesamtGewicht += this.fahrer.getKg();
        }
        if (this.beifahrer != null) {
            gesamtGewicht += this.beifahrer.getKg();
        }
        if (this.rueckbank != null) {
            gesamtGewicht += this.rueckbank.getKg();
        }
        return gesamtGewicht;
    }
}

