package at.bal;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Bootsverleih {
    private String name;
    private List<Boot> boote;

    public Bootsverleih(String name) throws BootException {
        setName(name);
        boote = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws BootException {
        if (name == null || name.isEmpty()) {
            throw new BootException("Fehler: name ist null oder leer");
        }
        this.name = name;
    }

    public Boot getBoot(int index) {
        if (index >= 0 && index < boote.size() ) {
            return boote.get(index);
        }
        return null;
    }

    public boolean hinzufuegen(Boot boot) {
        if (boot != null || boote.size() < 20 || !boote.contains(boot)) {
            return boote.add(boot);
        } else {
            return false;
        }
    }

    public boolean entfernen(Boot boot) {
        if (boot != null) {
            return boote.remove(boot);
        } else {
            return false;
        }
    }

    // Wiederholen
    public int entfernen(String bezeichnung) {
        int entfernt = 0;
        if (bezeichnung != null) {
            Iterator<Boot> iter = boote.iterator();
            while (iter.hasNext()) {
                if (iter.next().getBezeichnung().equals(bezeichnung)) {
                    iter.remove();
                    entfernt++;
                }
            }
            return entfernt;
        }
        return -99;
    }

    public int anzahlBooteMitLizenz() {
        int anzahlBooteMitLizenz = 0;
        if (anzahlSegelBoote() > 0) {
            for (Boot b: boote) {
                if (b instanceof SegelBoot && ((SegelBoot) b).isLizenz()) {
                    anzahlBooteMitLizenz++;
                }
            }
            return anzahlBooteMitLizenz;
        }
        return -99;
    }

    private int anzahlSegelBoote() {
        int anzahlSegelBoote = 0;
        for (Boot k: boote) {
            if (k instanceof SegelBoot) {
                anzahlSegelBoote++;
            }
        }
        return anzahlSegelBoote;
    }

    public void sortieren() {
        boote.sort(null);
    }

    public void sortierenNachBezeichnung() {
        boote.sort(new BezeichnungComparator());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Bootsverleih ");
        sb.append(name).append("\n");
        if (!boote.isEmpty()) {
            for (Boot k: boote) {
                sb.append(k).append("\n");
            }
        } else {
            sb.append("keine Boote vorhanden");
        }
        return sb.toString();
    }
}
