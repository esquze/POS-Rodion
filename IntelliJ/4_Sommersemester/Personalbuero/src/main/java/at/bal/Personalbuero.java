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

    public int zahleAlter(int alter) {
        if(alter < 15) {
            throw new IllegalArgumentException("Fehler: zu jung");
        }
        if(employees.isEmpty()) {
            return -99;
        }
        int count = 0;
        for(Mitarbeiter ma: employees) {
            if(ma.berechneAlter() == alter) {
               count++;
            }
        }
        return count;
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

    public Mitarbeiter kuendigen(int pos) {
        if (pos < 0 || pos >= employees.size()) {
            throw new IllegalArgumentException("Fehler: index ungültig");
        }
        return employees.remove(pos);
    }

    public boolean kuendigen(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Fehler: name ungültig");
        }
        for (Mitarbeiter ma: employees) {
            if (ma.getName().equals(name)) {
                return employees.remove(ma);
            }
        }
        return false;
    }

    public boolean kuendigen(Mitarbeiter ma) {
        if (ma == null) {
            throw new IllegalArgumentException("Fehler: null");
        }
        return employees.remove(ma);
    }

    public void gehaltListe() {
        System.out.println("Gehaltsliste:\n");
        if (!employees.isEmpty()) {
            for (Mitarbeiter ma: employees) {
                System.out.println("Name: " + ma.getName());
                System.out.println(", Gehalt: " + ma.berechneGehalt() + " EUR");
            }
            System.out.println("Gehaltsumme: " + berechneGehaltsumme() + " EUR");
        } else {
            System.out.println("Keine MitarbeiterInnen vorhanden");
        }
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
