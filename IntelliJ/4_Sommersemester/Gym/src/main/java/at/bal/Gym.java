package at.bal;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Gym {

    private double maxPreisEur;
    private int maxAnzahl;
    private List<Maschine> maschinen;

    public Gym(double maxPreisEur, int maxAnzahl, List<Maschine> maschinen) {
        setMaxPreisEur(maxPreisEur);
        setMaxAnzahl(maxAnzahl);
        this.maschinen = new LinkedList<>();
    }

    public double getMaxPreisEur() {
        return maxPreisEur;
    }

    public void setMaxPreisEur(double maxPreisEur) {
        if (maxPreisEur < 0.0 || maxPreisEur > 9000.0) {
            throw new IllegalArgumentException("Fehler: muss zwischen 0.0 und 9000.0 sein");
        }
        this.maxPreisEur = maxPreisEur;
    }

    public int getMaxAnzahl() {
        return maxAnzahl;
    }

    public void setMaxAnzahl(int maxAnzahl) {
        if (maxAnzahl < 5 || maxAnzahl > 100) {
            throw new IllegalArgumentException("Fehler: muss zwischen 5 und 100 sein");
        }
        this.maxAnzahl = maxAnzahl;
    }

    public boolean aufstellen(Maschine maschine) {
        if (maschine != null && !maschinen.contains(maschine) &&
                maschine.getPreisEur() <= maxPreisEur && maschinen.size() < maxAnzahl) {
            maschinen.add(maschine);
            return true;
        }
        return false;
    }

    public double berechneAvgPreisMaschinen() {
        if (maschinen.isEmpty()) {
            return 0.0;
        }
        return berechnePreisMaschinen() / maschinen.size();
    }

    private float berechnePreisMaschinen() {
        float sum = 0;
        for (Maschine m: maschinen) {
            sum += m.getPreisEur();
        }
        return sum;
    }

    public void sortieren() {
        maschinen.sort(null);
    }

    public void sortierenPreisEur() {
        maschinen.sort(new PreisComparator());
    }

    public int entfernenAlle(char typ) {
        char t = Character.toLowerCase(typ);
        if ((t != 'b' && t != 'e') || maschinen.isEmpty()) {
            return -99;
        }
        int entfernt = 0;
        Iterator<Maschine> iter = maschinen.iterator();
        while (iter.hasNext()) {
            Maschine m = iter.next();
            if ((t == 'b' && m instanceof Beinpresse) ||
                    (t == 'e' && m instanceof Ergometer)) {
                iter.remove();
                entfernt++;
            }
        }
        return entfernt;
    }

    public boolean entfernen(Maschine maschine) {
        if (maschine == null || maschinen.isEmpty()) {
            return false;
        }
        return maschinen.remove(maschine);
    }

    public int maxWartungsintervall() {
        if (maschinen.isEmpty()) {
            return -99;
        }
        int max = Integer.MIN_VALUE;
        for (Maschine m: maschinen) {
            if (m.wartungsIntervall() > max) {
                max = m.wartungsIntervall();
            }
        }
        return max;
    }

}
