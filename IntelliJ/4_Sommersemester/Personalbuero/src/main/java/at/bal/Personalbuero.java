package at.bal;

import java.util.ArrayList;
import java.util.Iterator;

public class Personalbuero {
    private ArrayList<Mitarbeiter> employees;

    public Personalbuero() {
        employees = new ArrayList<>();

    }

    public boolean aufnehmen(Mitarbeiter mitarbeiter) {
        if (mitarbeiter == null || mitarbeiter.berechneAlter() < 15 || employees.contains(mitarbeiter)) {
            return false;
        }
        return employees.add(mitarbeiter);
    }

    public double berechneGehaltsumme() {
        double summe = 0.0;
        for (Mitarbeiter ma: employees) {
            summe += ma.berechneGehalt();        }
        return summe;
    }

    public double berechneDurchschnittsalter() {
        if (employees.isEmpty()) {
            return -99.0;
        }
        double summe = 0.0;
        for (Mitarbeiter ma: employees) {
            summe += ma.berechneAlter();
        }
        return summe / employees.size();
    }

    public int zaehleMitarbeiter() {
        return employees.size();
    }

    // wenn keine MA vorhanden, dann return -99;
    public int kuendigenAlle(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Fehler: null");
        }
        if (employees.isEmpty()) {
            return -99;
        }
        int count = 0;
        Iterator<Mitarbeiter> iterator = employees.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getName().equals(name)) {
                // employees.remove(iterator.next()); //FEHLER SO NICHT
                iterator.remove();
                count++;
            }
        }
        return count;
    }

    public double kuendigen(double gehalt) {
        if (gehalt <= 0.0) {
            throw new IllegalArgumentException("Fehler: Gehalt 0.0 oder kleiner");
        }
        Iterator<Mitarbeiter> iterator = employees.iterator();
        double summe = 0.0;
        Mitarbeiter ma;
        while (iterator.hasNext()) {
            ma = iterator.next();
            if (ma.berechneGehalt() > gehalt) {
                summe += ma.berechneGehalt();
                iterator.remove();
            }
        }
        return summe;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Personalbüro:\n");
        if (!employees.isEmpty()){
            for (Mitarbeiter ma: employees) {
                sb.append(ma).append("\n");
            }
        }
        else {
            sb.append("Keine Mitarbeiter vorhanden");
        }
        return sb.toString();
    }
}
