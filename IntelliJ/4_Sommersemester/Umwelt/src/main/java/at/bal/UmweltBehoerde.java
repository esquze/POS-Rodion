package at.bal;

import java.time.Year;
import java.util.ArrayList;
import java.util.Iterator;

public class UmweltBehoerde {

    private ArrayList<Messstation> messstationen;

    public UmweltBehoerde() {
        messstationen = new ArrayList<>();
    }

    public boolean addMessstation(Messstation m) {
        if (m == null || messstationen.contains(m)) {
            return false;
        }
        return messstationen.add(m);
    }

    public double berechneDurchschnittMesswert() {
        if (messstationen.isEmpty()) {
            return 0.0;
        }
        double summe = 0.0;
        for (Messstation m: messstationen) {
            summe += m.getMesswert();
        }
        return summe / messstationen.size();
    }

    public double berechneDurchschnittLuftmessstationen() {
        double summe = 0;
        int anzahl = 0;

        for (Messstation m: messstationen) {
            if (m instanceof Luftmessstation) {
                summe += m.getMesswert();
                anzahl++;
            }
        }
        if (anzahl == 0) {
            return 0;
        }

        return summe / anzahl;
    }

    public double berechneDurchschnittLaermmessstationen() {
        double summe = 0;
        int anzahl = 0;

        for (Messstation m: messstationen) {
            if (m instanceof Laermmessstation) {
                summe += m.getMesswert();
                anzahl++;
            }
        }
        if (anzahl == 0) {
            return 0;
        }

        return summe / anzahl;
    }

    public double berechneDurchschnittWetterstation() {
        double summe = 0;
        int anzahl = 0;

        for (Messstation m: messstationen) {
            if (m instanceof Wetterstation) {
                summe += m.getMesswert();
                anzahl++;
            }
        }
        if (anzahl == 0) {
            return 0;
        }

        return summe / anzahl;
    }

    public void sortiereMessstationen() {
        messstationen.sort(null);
    }

    public void zeigeAlleStationen() {
        System.out.println("Alle Stationen: ");
        for (Messstation m: messstationen) {
            System.out.println(m);
        }
    }

    public void zeigeNurLuftmessstationen() {
        for (Messstation m: messstationen) {
            if (m instanceof Luftmessstation) {
                System.out.println(m);
            }
        }
    }

    public void zeigeNurLaermmessstationen() {
        for (Messstation m: messstationen) {
            if (m instanceof Laermmessstation) {
                System.out.println(m);
            }
        }
    }

    public void zaehleStationstypen() {
        int anzahlLuft = 0;
        int anzahlLaerm = 0;
        int anzahlWetter = 0;

        for (Messstation m : messstationen) {
            if (m instanceof Luftmessstation) {
                anzahlLuft++;
            } else if (m instanceof Laermmessstation) {
                anzahlLaerm++;
            } else if (m instanceof Wetterstation) {
                anzahlWetter++;
            }
        }

        System.out.println("Anzahl Luft: " + anzahlLuft);
        System.out.println("Anzahl Lärm: " + anzahlLaerm);
        System.out.println("Anzahl Wetter: " + anzahlWetter);
    }

    public int zaehleAlleStationenMitZuHohemWert(double grenzwert) {
        int count = 0;
        for (Messstation m : messstationen) {
            if (m.getMesswert() > grenzwert) {
                count++;
            }
        }
        return count;
    }

    public boolean removeMessstation(Messstation m) {
        if (m == null) {
            return false;
        }
        return messstationen.remove(m);
    }

    public boolean removeErsteStationNachStandort(String standort) {
        if(standort == null) {
            return false;
        }
        Iterator<Messstation> it = messstationen.iterator();
        Messstation m;
        while(it.hasNext()) {
            m = it.next();
            if(m.getStandort().equals(standort)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public ArrayList<Messstation> removeAlleStationenAelterAls(int alterInJahren) {
        if(messstationen.isEmpty() || alterInJahren < 0) {
            return null;
        }

        ArrayList<Messstation> messtationenEntfernt = new ArrayList<>();

        int currentYear = Year.now().getValue();
        int installationsJahr;
        Iterator<Messstation> iter = messstationen.iterator();
        while (iter.hasNext()) {
            Messstation messstation = iter.next();
            installationsJahr = messstation.getInstallationsJahr().getValue();
            if ((currentYear - installationsJahr) > alterInJahren) {
                messtationenEntfernt.add(messstation);
                iter.remove();
            }
        }
        return messtationenEntfernt;
    }

    public void zeigeStationenMitGrenzwertUeberschreitung() {

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Messstationen: ");
        for (Messstation m : messstationen) {
            sb.append("\n").append(m.toString());
        }
        return sb.toString();
    }
}
