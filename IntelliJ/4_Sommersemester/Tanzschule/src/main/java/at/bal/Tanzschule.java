package at.bal;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Tanzschule {

    private String name;
    private ArrayList<Kurs> kurse;

    public Tanzschule(String name) throws TanzschuleException {
        setName(name);
        this.kurse = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws TanzschuleException {
        if (name == null || name.isEmpty()) {
            throw new TanzschuleException("Fehler: Name darf nicht leer oder null sein");
        }
        this.name = name;
    }

    public boolean hinzufuegen(Kurs kurs) throws TanzschuleException {
        if (kurs != null && !kurse.contains(kurs)) {
            kurse.add(kurs);
            return true;
        } else {
            return false;
        }
    }

    //    public void sortierenNachPreis() {
    //        kurse.sort(new Comparator<Kurs>() {
    //            @Override
    //            public int compare(Kurs o1, Kurs o2) {
    //                return Double.compare(o1.preis(), o2.preis());
    //            }
    //        });
    //    }

    public void sortierenNachPreis() {
        kurse.sort(Comparator.comparingDouble(Kurs::preis));
    }

    public void saveKurse() throws TanzschuleException {
        String pathFileName = "saveKurse.ser";
        File file = new File(pathFileName);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {

            oos.writeObject(kurse);

        } catch (FileNotFoundException e) {
            throw new TanzschuleException("Die Datei " + file + " ist nicht gefunden: " + e.getMessage());
        } catch (IOException e) {
            throw new TanzschuleException("IO-Problem mit Datei " + file + ": "+ e.getMessage());
        }
    }

    public void importKurseCsv() throws TanzschuleException {
        String filepath = "src/main/resources/kurse.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
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
            throw new TanzschuleException("Fehler bei importKurseCsv Datei nicht gefunden:  " + filepath + ": " + e.getMessage() );
        } catch (IOException e) {
            throw new TanzschuleException("Fehler bei importKurseCsv mit Datei " + filepath + ": " + e.getMessage());
        }
    }

    public void exportPrivatKurseCsv() throws TanzschuleException {
        String filepath = "src/main/resources/privatKurse.csv";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filepath))) {
            for (Kurs k: kurse) {
                if (k instanceof PrivatKurs) {
                    bw.write(toCSVString());
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            throw new TanzschuleException("Fehler beim Export " + filepath + ": " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Tanzschule: ").append(name).append("\n");
        for (Kurs k: kurse) sb.append(k).append("\n");
        return sb.toString();
    }

    public String toCSVString() {
        final StringBuilder sb = new StringBuilder();
        for (Kurs k: kurse) sb.append(k.toCsvString()).append("\n");
        return sb.toString();
    }

}
