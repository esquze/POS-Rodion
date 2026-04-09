package at.bal;

import java.util.ArrayList;
import java.util.List;

public class ZertifikatsVerwaltung {

    private List<UmweltZertifikat> zertifikate;

    public ZertifikatsVerwaltung() {
        zertifikate = new ArrayList<>();
    }

    public void addZertifikat(UmweltZertifikat z) throws UmweltProjektException {
        if (z == null) {
            throw new UmweltProjektException("Fehler: zertifikat ist null");
        }
        zertifikate.add(z);
    }

    public void druckAlle() {
        if (zertifikate.isEmpty()) {
            System.out.println("Keine Zertifikate vorhanden");
        }
        for (UmweltZertifikat u: zertifikate) {
            System.out.println(u);
        }
    }

    public List<UmweltZertifikat> listeTopNachhaltigkeitsScore() {
        zertifikate.sort(null);
        zertifikate.reversed();
        int anzahlTop10Prozent = zertifikate.size() / 10;
        ArrayList<UmweltZertifikat> topList = new ArrayList<>();
        for (int i = 0; i < anzahlTop10Prozent; i++) {
            topList.add(zertifikate.get(i));
        }
        return topList;
    }

}
