package at.bal;

import java.util.ArrayList;

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
