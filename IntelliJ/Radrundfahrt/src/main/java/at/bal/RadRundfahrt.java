package at.bal;

public class RadRundfahrt {

    private String name;
    private Etappe[] etappen;
    private int maxEtappen = 50;

    // Konstruktor
    public RadRundfahrt(String name) {
        this.setName(name);
        this.etappen = new Etappe[maxEtappen];
    }

    // Name Setter
    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name ist null oder leer");
        }
        this.name = name;
    }

    // Eine Etappe hinzufügen
    public boolean hinzufuegen(Etappe etappe) {
        if (etappe == null) {
            throw new IllegalArgumentException("Etappe ist nicht null");
        }
        for (int i = 0; i < etappen.length; i++) {
            if (etappen[i] == etappe) {
                throw new IllegalArgumentException("Etappe schon eingetragen");
            }
            if (etappen[i] == null) {
                etappen[i] = etappe;
                etappen[i].setNummer(i + 1);
                return true;
            }
        }
        throw new IllegalArgumentException("Maximal nur " + maxEtappen + " ist");
    }

    public String etappenUebersicht() {
        String alleEtappen = "";
        for(Etappe etappe : etappen) {
            if (etappe != null) {
                alleEtappen += etappe;
            }
        }
        return alleEtappen;
    }

    public float berechneGesamtlaenge() {
        float gesLaenge = 0;
        for (Etappe etappe : etappen) {
            if (etappe != null) {
                gesLaenge += etappe.getLaenge();
            }
        }
        return gesLaenge;
    }

    public int anzEtappen() {
        int gesEtappen = 0;
        for (Etappe etappe : etappen) {
            if (etappe != null) {
                gesEtappen++;
            }
        }
        return gesEtappen;
    }

    public float berechneDurchschnittslaenge() {
        return berechneGesamtlaenge() / anzEtappen();
    }

    public int anzGewonnen(String fahrer) {
        int siege = 0;
        for (Etappe etappe : etappen) {
            if (etappe != null && etappe.getSieger().equals(fahrer)) {
                siege++;
            }
        }
        return siege;
    }

    public String alleGewonnen() {
        String gewonnen = "";
        for (int i = 0; i < etappen.length; i++) {
            Etappe etappe = etappen[i];
            if (etappe != null) {
                String sieger = etappe.getSieger();
                int anzahl = anzGewonnen(sieger);
                boolean schonGezählt = false;

                for (int j = 0; j < i; j++) {
                    if (etappen[j] != null && sieger.equals(etappen[j].getSieger())) {
                        schonGezählt = true;
                        break;
                    }
                }
                if (schonGezählt) {
                    continue;
                }

                gewonnen += sieger + ": Siege " + anzahl + "\n";
            }
        }
        return gewonnen;
    }

    public float sucheLaengsteEtappe() {
        float rv = 0;
        if (etappen[0] != null) {
            rv = etappen[0].getLaenge();
        }
        for (int i = 0; i < etappen.length; i++) {
            for (int j = i + 1; j < etappen.length; j++) {
                if (etappen[j] != null && rv < etappen[j].getLaenge()) {
                    rv = etappen[j].getLaenge();
                }
            }
        }
        return rv;
    }

    public boolean annullieren(int pos) {
        for (int i = 0; i < etappen.length; i++) {
            if (etappen[i] == etappen[pos]) {
                etappen[i] = null;
                return true;
            }
        }
        return false;
    }

    public int berechneGesamtdauer() {
        int stunden = 0;
        int minuten = 0;
        for (int i = 0; i < etappen.length; i++) {
            if (etappen[i] != null) {
                stunden += etappen[i].getStunden();
            }
            if (etappen[i] != null && etappen[i].getMinuten() > 30) {
                minuten += etappen[i].getMinuten();
            }
        }
        return stunden / 60 + minuten;
    }

    public String toString() {
        return  this.name +
                "\n=====================" +
                "\nEtappen: " + anzEtappen() +
                "\nGesamt-Länge: " + berechneGesamtlaenge() + " km" +
                "\nGesamt-Dauer: " + berechneGesamtdauer() + " Stunden" +
                "\nLängste Etappe: " + sucheLaengsteEtappe() +
                "\nEtappen-Durchschnitt: " + berechneDurchschnittslaenge() + " km" +
                "\n" +
                "\n" + etappenUebersicht() +
                "\n" +
                "\nSiege: " +
                "\n" + alleGewonnen();
    }
}
