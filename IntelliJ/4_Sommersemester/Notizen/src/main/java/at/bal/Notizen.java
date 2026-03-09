package at.bal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Notizen {

    List<String> notizen;

    public Notizen() {
        notizen = new ArrayList<>();
    }

    public boolean notizHinzufuegen(String notiz) {
        if (notiz == null || notiz.isBlank()) {
            throw new IllegalArgumentException("Fehler: null oder leer");
        }
        if (this.notizen.contains(notiz)) {
            return false;
        }
        return notizen.add(notiz);
    }

    public void sortierenAlphabetisch() {
        notizen.sort(null);
    }

    public void sortierenNachLaengeAbsteigend() {
        notizen.sort(new LaengeComparator().reversed());
    }

    public void sortierenNachDerLaengeAufsteigend() {
        notizen.sort(new LaengeComparator());
    }

    public boolean notizEntfernen(String notiz) {
        if (!checkNotiz(notiz)) {
            throw new IllegalArgumentException("Fehler: notiz ungültig");
        }
        return notizen.remove(notiz);
    }

    public boolean checkNotiz(String notiz) {
        if (notiz == null || notiz.isBlank()) {
            return false;
        }
        return true;
    }

    public void ausgebenNotizen() {
        if (notizen.isEmpty()) {
            System.out.println("Keine Notizen vorhanden");
        }
        System.out.println("Meine Notizen: ");
        for (String notiz: notizen) {
            System.out.println(notiz);
        }
    }



}
