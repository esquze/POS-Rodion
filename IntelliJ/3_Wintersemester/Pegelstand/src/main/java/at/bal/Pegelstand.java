package at.bal;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Pegelstand {

    // 1. Aufgabe

    private String fluss;
    private int[] werte;
    private int anzahl;

    public Pegelstand(){
        fluss = "Donau";
        werte = new int[7];
    }

    public Pegelstand(String fluss) {
        setFluss(fluss);
        this.fluss = fluss;
    }

    public int getAnzahl() {
        return anzahl;
    }

    public void ausgebenWert() {
        for (int i = 0; i < werte.length; i++) {
            System.out.println("[" + (i + 1) + "]: " + werte[i]);
        }
    }

    public String getFluss() {
        return fluss;
    }
    public void setFluss(String fluss) {
        if (fluss != null && !fluss.isEmpty()) {
            this.fluss = fluss;
        }
        else {
            throw new IllegalArgumentException("Fehler: fluss ungültig");
        }
    }

    public void fuelleTestwerte() {
        werte = new int[] { 250, 290, 310, 310, 300, 300, 300 };
        anzahl = 7;
    }

    public float avgWert() {
        if (anzahl == 0) {
            return -99f; // Fehlercode -99f
        }
        float summe = 0f;
        for (int i = 0; i < anzahl; i++) {
            summe += werte[i];
        }
        return summe / anzahl;
    }

    public float minWert() {
        if (anzahl == 0) {
            return -99f; // Fehlercode -99f
        }
        int minZahl = werte[0];
        for (int i = 1; i < anzahl; i++) {
            if (werte[i] < minZahl) {
                minZahl = werte[i];
            }
        }
        return minZahl;
    }

    public int maxWertIndex() {
        if (anzahl == 0) {
            return -99; // Fehlercode -99
        }
        int maxZahl = werte[0];
        int maxWertIndex = 0;
        for (int i = 0; i < anzahl; i++) {
            if (werte[i] > maxZahl) {
                maxZahl = werte[i];
                maxWertIndex = i;
            }
        }
        return maxWertIndex;
    }

    public void printPegelstand() {
        StringBuilder sb = new StringBuilder();
        sb.append(fluss).append("\n");
        if (anzahl > 0) {
            for (int i = 0; i < anzahl; i++) {
                sb.append("[").append(i + 1).append("]: ").append(werte[i]).append(" cm\n");
            }
            sb.append(anzahl).append(" Messwerte");
        }
        else {
            sb.append("Keine Werte vorhanden");
        }
        System.out.println(sb.toString());
    }

    // 3. Aufgabe

    public int getWert(int index) {
        if (index < 0 || index > 6) {
            return -99;
        }
        return werte[index];
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pegelstand: ");
        sb.append(fluss).append(", ");
        sb.append(Arrays.toString(werte));
        sb.append(", ").append(anzahl).append(" Messwerte");
        return sb.toString();
    }

}
