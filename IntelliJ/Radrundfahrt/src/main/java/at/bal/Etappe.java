package at.bal;

public class Etappe {

    private int nummer;
    private float laenge;
    private String zielOrt;
    private String sieger;
    private int stunden;
    private int minuten;

    // Konstruktor
    public Etappe(float laenge, String zielOrt) {
        this.laenge = laenge;
        this.zielOrt = zielOrt;
    }

    // Getter/Setter für Nummer
    public int getNummer() {
        return nummer;
    }
    public int getNummer(int nummer) {
        this.nummer = nummer;
        return nummer;
    }

    // Getter/Setter für Länge
    public float getLaenge() {
        return laenge;
    }
    public float getLaenge(float laenge) {
        this.laenge = laenge;
        return laenge;
    }

    // Getter/Setter für ZielOrt
    public String getZielOrt() {
        return zielOrt;
    }
    public String getZielOrt(String zielOrt) {
        this.zielOrt = zielOrt;
        return zielOrt;
    }

    // Getter/Setter für Sieger
    public String getSieger() {
        return sieger;
    }
    public String getSieger(String sieger) {
        this.sieger = sieger;
        return sieger;
    }

    // Getter/Setter für Stunden
    public int getStunden() {
        return stunden;
    }
    public int getStunden(int stunden) {
        this.stunden = stunden;
        return stunden;
    }

    // Getter/Setter für Minuten
    public int getMinuten() {
        return minuten;
    }
    public int getMinuten(int minuten) {
        this.minuten = minuten;
        return minuten;
    }

    // toString Methode, um alles zu printen
    public String toString() {
        return("Etappe " + nummer + ": Länge " + laenge +
                " km, Ziel-Ort " + zielOrt + ", Sieger " + sieger +
                ", Dauer " + stunden + ":" + minuten);
    }

}
