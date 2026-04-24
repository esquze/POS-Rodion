package at.bal;

import java.util.*;

public class Versicherungsmakler {

    private String name;
    private List<Vertrag> vertraege;

    public Versicherungsmakler(String name) throws VersicherungException {
        setName(name);
        vertraege = new LinkedList<>();
    }

    public void setName(String name) throws VersicherungException {
        if (name == null || name.isEmpty()) {
            throw new VersicherungException("Fehler: name ist ungültig");
        }
        this.name = name;
    }

    public int anzahlVertraege() {
        return vertraege.size();
    }

    public void hinzufuegen(Vertrag vertrag) throws VersicherungException {
        if (vertrag != null && !vertraege.contains(vertrag)) {
            vertraege.add(vertrag);
        } else {
            throw new VersicherungException("geworfen");
        }
    }

    public double berechneGesamtPreis() {
        double sum = 0.0;
        if (vertraege != null) {
            for (Vertrag vertrag: vertraege) {
                sum += vertrag.berechnePreis();
            }
        }
        return sum;
    }
}
