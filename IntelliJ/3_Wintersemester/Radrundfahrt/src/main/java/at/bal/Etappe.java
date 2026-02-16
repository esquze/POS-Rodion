package at.bal;

public class Etappe {

    private int nummer;
    private float laenge;
    private String zielOrt;
    private String sieger;
    private int stunden;
    private int minuten;

    // Konstruktor
    public Etappe(float laenge, String zielOrt, String sieger, int stunden, int minuten) {
        this.setLaenge(laenge);
        this.setZielOrt(zielOrt);
        this.setSieger(sieger);
        this.setStunden(stunden);
        this.setMinuten(minuten);
    }

    // Getter/Setter für Nummer
    public int getNummer() {
        return nummer;
    }
    public int setNummer(int nummer) {
        if (nummer <= 0) {
            throw new IllegalArgumentException("Nummer '" + nummer + "' ist ungültug, muss größer 0 sein");
        }
        this.nummer = nummer;
        return nummer;
    }

    // Getter/Setter für Länge
    public float getLaenge() {
        return laenge;
    }
    public float setLaenge(float laenge) {
        if (laenge <= 0) {
            throw new IllegalArgumentException("Länge '" + laenge + "' ist ungültug, muss größer 0 sein");
        }
        this.laenge = laenge;
        return laenge;
    }

    // Getter/Setter für ZielOrt
    public String getZielOrt() {
        return zielOrt;
    }
    public String setZielOrt(String zielOrt) {
        if (zielOrt == null || zielOrt.isBlank()){
            throw new IllegalArgumentException("ZielOrt ist null oder leer");
        }
        this.zielOrt = zielOrt;
        return zielOrt;
    }

    // Getter/Setter für Sieger
    public String getSieger() {
        return sieger;
    }
    public String setSieger(String sieger) {
        if (sieger == null || sieger.isBlank()){
            throw new IllegalArgumentException("Sieger ist null oder leer");
        }
        this.sieger = sieger;
        return sieger;
    }

    // Getter/Setter für Stunden
    public int getStunden() {
        return stunden;
    }
    public int setStunden(int stunden) {
        if (stunden <= 0) {
            throw new IllegalArgumentException("Stunden '" + stunden + "' ist ungültug, muss größer 0 sein");
        }
        this.stunden = stunden;
        return stunden;
    }

    // Getter/Setter für Minuten
    public int getMinuten() {
        return minuten;
    }
    public int setMinuten(int minuten) {
        if (minuten < 0 || minuten > 60) {
            throw new IllegalArgumentException("Minuten '" + minuten + "' ist ungültug, muss größer 0 und kleiner 60 sein");
        }
        this.minuten = minuten;
        return minuten;
    }

    // toString Methode, um alles zu printen
    public String toString() {
        return("Etappe " + nummer + ": Länge " + laenge +
                " km, Ziel-Ort " + zielOrt + ", Sieger " + sieger +
                ", Dauer " + stunden + ":" + minuten + "\n");
    }

}
