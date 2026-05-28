package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Tanzschule {

    private String name;
    private List<Kurs> kurse;

    public Tanzschule(String name) throws TanzschuleException {
        setName(name);
        this.kurse = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws TanzschuleException {
        if (name == null || name.isEmpty()) {
            throw new TanzschuleException("Fehler: Name ist null oder leer");
        }
        this.name = name;
    }

    public boolean hinzufuegen(Kurs kurs) throws TanzschuleException {
        if (kurs != null && !kurse.contains(kurs)) {
            kurse.add(kurs);
            return true;
        }
        return false;
    }

    public void sortierenNachPreis() {
        kurse.sort(Comparator.comparingDouble(Kurs::preis));
    }

    public void saveKurse() throws TanzschuleException {
        String filePath = "src/main/resources/saveKurse.ser";
        File file = new File(filePath);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {

            oos.writeObject(kurse);

        } catch (FileNotFoundException e) {
            throw new TanzschuleException("Die Datei " + file + " ist nicht gefunden: " + e.getMessage());
        } catch (IOException e) {
            throw new TanzschuleException("IO-Problem mit Datei " + file + ": "+ e.getMessage());
        }
    }

    public void loadKurse() throws TanzschuleException {
        String filePath = "src/main/resources/saveKurse.ser";
        File file = new File(filePath);
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {

            List<?> kurseLoad = (List<?>) ois.readObject();
            ArrayList<Kurs> kurseBackup = new ArrayList<>(kurse);

            kurse.clear();
            for (Object o: kurseLoad) {
                if (o instanceof Kurs) {
                    kurse.add((Kurs) o);
                } else {
                    kurse = kurseBackup;
                    throw new TanzschuleException("Fehler: Unbekanntes Objekt in " + file);
                }
            }


        } catch (FileNotFoundException e) {
            throw new TanzschuleException("Die Datei " + file + " ist nicht gefunden: " + e.getMessage());
        } catch (IOException e) {
            throw new TanzschuleException("IO-Problem mit Datei " + file + ": "+ e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new TanzschuleException("Die Datei " + file + " enthält keine Kurse: " + e.getMessage());
        }
    }

    public void importKurseCsv() throws TanzschuleException {
        String filePath = "src/main/resources/kurse.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();
            while (line != null) {
                Kurs kurs = null;
                if (line.startsWith("PrivatKurs")) {
                    try {
                        kurs = new PrivatKurs(line);
                    } catch (TanzschuleException e) {
                        System.out.println("Fehler PrivatKurs mit " + line + " - " + e.getMessage());
                    }
                }
                if (line.startsWith("GruppenKurs")) {
                    try {
                        kurs = new GruppenKurs(line);
                    } catch (TanzschuleException e) {
                        System.out.println("Fehler GruppenKurs mit " + line  + " - " + e.getMessage());
                    }
                }
                if (hinzufuegen(kurs)) {
                    System.out.println("Kurs wurde hinzugefügt: " + kurs);
                } else {
                    System.out.println("Kurs konnte NICHT hinzugefügt werden: " + line);
                }
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new TanzschuleException("Fehler bei importKurseCsv Datei nicht gefunden:  " + filePath + ": " + e.getMessage() );
        } catch (IOException e) {
            throw new TanzschuleException("Fehler bei importKurseCsv mit Datei " + filePath + ": " + e.getMessage());
        }
    }

    public void exportPrivatKurseCsv() throws TanzschuleException {
        String filePath = "src/main/resources/privatKurse.csv";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Kurs k: kurse) {
                if (k instanceof PrivatKurs) {
                    bw.write(k.toCSVString());
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            throw new TanzschuleException("Fehler beim Export " + filePath + ": " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Tanzschule ").append(name).append("\n");
        for (Kurs k: kurse) sb.append(k.toString()).append("\n");
        return sb.toString();
    }

    public String toCSVString() {
        final StringBuilder sb = new StringBuilder();
        for (Kurs k: kurse) sb.append(k.toCSVString()).append("\n");
        return sb.toString();
    }
}
