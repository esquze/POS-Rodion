package at.bal;

import java.io.*;
import java.util.*;

public class Notizen {

    private List<String> notizen;

    public Notizen() {
        notizen = new ArrayList<>();
    }

    public boolean notizHinzufuegen(String notiz) throws NotizException {
        if (notiz == null || notiz.isBlank()) {
            throw new NotizException("Fehler: null oder leer");
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

    public boolean notizEntfernen(String notiz) throws NotizException {
        if (!checkNotiz(notiz)) {
            throw new NotizException("Fehler: notiz ungültig");
        }
        return notizen.remove(notiz);
    }

    public boolean checkNotiz(String notiz) {
        return notiz != null && !notiz.isBlank();
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

    public void save() throws NotizException {
        String filepath = "src/main/resources/notizen.ser";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filepath))) {

            oos.writeObject(notizen);

        } catch (FileNotFoundException e) {
            throw new NotizException("Die Datei " + filepath + " nicht gefunden: " + e.getMessage());
        } catch (IOException e) {
            throw new NotizException("I/O-Probmlem mit Datei " + filepath + ": " + e.getMessage());
        }
    }

    public void load() throws NotizException {
        String filepath = "src/main/resources/notizen.ser";
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filepath))) {

            List<?> notizenLoad = (List<?>) ois.readObject();

            ArrayList<String> notizenBackup = new ArrayList<>();
            Collections.copy(notizenBackup, notizen);

            notizen.clear(); // alles weg
            for (Object o: notizenLoad) {
                if (o instanceof String) {
                    notizen.add((String) o);
                } else {
                    notizen = notizenBackup;
                    throw new NotizException("Fehler mit den Notizen in " + filepath + ", andere Informationen gefunden");
                }
            }

        } catch (FileNotFoundException e) {
            throw new NotizException("Die Datei " + filepath + " kann nicht geladen werden: " + e.getMessage());
        } catch (IOException e) {
            throw new NotizException("I/O-Probmlem mit Datei " + filepath + ": " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new NotizException("Die Datei " + filepath + " enthält keine Notizen: " + e.getMessage());
        }
    }

}
