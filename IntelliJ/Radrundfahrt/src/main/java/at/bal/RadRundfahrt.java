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

    public float anzEtappen() {
        float gesEtappen = 0;
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



    public String toString() {
        return  this.name +
                "\n=====================" +
                "\nEtappen: " +
                "\nGesamt-Länge: " + berechneGesamtlaenge() + " km" +
                "\nGesamt-Dauer: " +
                "\nLängste Etappe: " +
                "\nEtappen-Durchschnitt: " + berechneDurchschnittslaenge() + " km" +
                "\n" +
                "\n" + etappenUebersicht();
    }
}
