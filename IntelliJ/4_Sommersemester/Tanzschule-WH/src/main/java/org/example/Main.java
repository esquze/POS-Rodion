package org.example;

public class Main {
    static void main() {
       // testImportKurseCsv();
       // testPrivatKurseCsv();
       // testSaveKurse();
        testSortiereKurseNachPreis();
    }

    private static void testImportKurseCsv() {
        try {
            Tanzschule tanzschule = new Tanzschule("Dorn");
            System.out.println(tanzschule);
            System.out.println();

            tanzschule.importKurseCsv();
            System.out.println("Kurse wurden geladen");
            System.out.println(tanzschule);
            System.out.println();

        } catch (TanzschuleException e) {
            System.out.println("Exception bei testPrivatKurseCsv(): " + e.getMessage());
        }
    }

    private static void testPrivatKurseCsv() {
        try {
            Tanzschule tanzschule = new Tanzschule("Dorn");
            GruppenKurs gruppenKurs1 = new GruppenKurs(5, 40.0);
            GruppenKurs gruppenKurs2 = new GruppenKurs(5, 40.0);
            PrivatKurs privatKurs = new PrivatKurs(1,100);
            tanzschule.hinzufuegen(gruppenKurs1);
            tanzschule.hinzufuegen(gruppenKurs2);
            tanzschule.hinzufuegen(privatKurs);

            tanzschule.exportPrivatKurseCsv();
            System.out.println("Die PrivatKurse wurden gespeichert");

        } catch (TanzschuleException e) {
            System.out.println("Exception bei testPrivatKurseCsv(): " + e.getMessage());
        }
    }

    private static void testSaveKurse() {
        try {
            Tanzschule tanzschule = new Tanzschule("Dorn");
            GruppenKurs gruppenKurs1 = new GruppenKurs(5, 40.0);
            GruppenKurs gruppenKurs2 = new GruppenKurs(5, 40.0);
            PrivatKurs privatKurs = new PrivatKurs(1,100);
            tanzschule.hinzufuegen(gruppenKurs1);
            tanzschule.hinzufuegen(gruppenKurs2);
            tanzschule.hinzufuegen(privatKurs);

            tanzschule.saveKurse();
            System.out.println("Die Kurse wurden gespeichert");

        } catch (TanzschuleException e) {
            System.out.println("Exception bei testLoadKurse(): " + e.getMessage());
        }
    }

    private static void testSortiereKurseNachPreis() {
        try {
            Tanzschule tanzschule = new Tanzschule("Dorn");
            GruppenKurs gruppenKurs1 = new GruppenKurs(5, 300.0);
            GruppenKurs gruppenKurs2 = new GruppenKurs(3, 200.0);
            PrivatKurs privatKurs = new PrivatKurs(1,500.0);
            tanzschule.hinzufuegen(gruppenKurs1);
            tanzschule.hinzufuegen(gruppenKurs2);
            tanzschule.hinzufuegen(privatKurs);
            System.out.println(tanzschule);
            System.out.println();

            tanzschule.sortierenNachPreis();
            System.out.println(tanzschule);

        } catch (TanzschuleException e) {
            System.out.println("asas" + e);
        }

    }

}
