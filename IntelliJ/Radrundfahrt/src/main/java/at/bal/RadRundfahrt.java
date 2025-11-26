package at.bal;

public class RadRundfahrt {

    private String name;
    private Etappe[] etappen;
    private int anzahl;

    // Konstruktor
    public RadRundfahrt(String name) {
        this.name = name;
        this.etappen = new Etappe[50];
    }

    public boolean hinzufuegen(Etappe e) {
        if (anzahl > 50) {
            return false;
        }
        return true;
    }

}
