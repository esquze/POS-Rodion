package at.bal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TanzschuleTest {
    @Test
    void testSaveKurse_shouldWork_throwsNoException() {
        try {
            // GIVEN
            Tanzschule tanzschule = new Tanzschule("Dorn");
            GruppenKurs gruppenKurs = new GruppenKurs(5, 40.0);
            tanzschule.hinzufuegen(gruppenKurs);

            // WHEN
            tanzschule.saveKurse();

            // THEN
            // "Kurse erfolgreich gespeichert" sollte in einer GUI angezeigt werden
            // derzeit noch Ausgabe der Erfolgsmeldung auf der Konsole:
            System.out.println("Die Kurse wurden gespeichert");

        } catch (TanzschuleException e) {
            fail();
        }
    }

//    @Test
//    void testEntferneAlleGruppenKurse_shouldWork_throwsNoException() {
//        try {
//            // GIVEN
//            Tanzschule tanzschule = new Tanzschule("Dorn");
//            GruppenKurs gruppenKurs = new GruppenKurs(5, 40f);
//            GruppenKurs gruppenKurs1 = new GruppenKurs(3, 30f);
//            PrivatKurs privatKurs = new PrivatKurs(1, 100f);
//            tanzschule.hinzufuegen(gruppenKurs);
//            tanzschule.hinzufuegen(gruppenKurs1);
//            tanzschule.hinzufuegen(privatKurs);
//            //System.out.println(tanzschule); // 2 GruppenKurse
//
//            // WHEN
//            int anzahlEntfernt = tanzschule.entferneAlleGruppenKurse();
//            //System.out.println(tanzschule); // keine GruppenKurse
//
//            // THEN
//            assertEquals(2, anzahlEntfernt);
//
//        } catch (TanzschuleException e) {
//            fail();
//        }
//    }

    @Test
    void testSortiereKurseNachPreis_shouldWork_3Kurse_throwsNoException() {
        try {
            // GIVEN
            // absteigend nach Preis sortierte Kursliste
            Tanzschule tanzschule = new Tanzschule("Dorn");
            GruppenKurs gruppenKurs = new GruppenKurs(5, 300.0);
            GruppenKurs gruppenKurs1 = new GruppenKurs(3, 200.0);
            PrivatKurs privatKurs = new PrivatKurs(2, 50.0);
            tanzschule.hinzufuegen(gruppenKurs);
            tanzschule.hinzufuegen(gruppenKurs1);
            tanzschule.hinzufuegen(privatKurs);
            System.out.println(tanzschule); // absteigend nach Preis sortierte Kursliste
            System.out.println();

            // WHEN // THEN
            tanzschule.sortierenNachPreis();
            System.out.println(tanzschule); // aufsteigend nach Preis sortierte Kursliste

        } catch (TanzschuleException e) {
            fail();
        }
    }
}