package at.bal;

import java.time.Year;

public class Main {

    public static void main(String[] args) {
        testGetStationstyp();
        testAddMessstation();
        testBerechneDurchschnittswert();
        testZaehleAlleStationenMitZuHohemWert();
        testSortieren();
        testRemoveMessstation();
        testZeigeNurLaermessstationen();
        testZeigeNurLuftmessstationen();
        testZeigeAlleStationen();
        testRemoveErsteStationNachStandort();
        testZaehleStationstypen();
        testRemoveAlleStationenAelterAls();
        testZeigeStationenMitGrenzwertUeberschreitung();
    }

    private static void testGetStationstyp() {
        System.out.println("-------------------- testGetStationstyp() --------------------");
        Luftmessstation luftmessstation = new Luftmessstation("Wien", Year.now().minusYears(2), 21.0, 55.5);
        Laermmessstation laermmessstation = new Laermmessstation("Eisenstadt", Year.now(), 50.0, 30);
        Wetterstation wetterstation = new Wetterstation("Graz", Year.now().minusYears(10), 21, 12);
        System.out.println(luftmessstation.getStationTyp());
        System.out.println(laermmessstation.getStationTyp());
        System.out.println(wetterstation.getStationTyp());
        System.out.println();
    }

    private static void testAddMessstation() {
        System.out.println("-------------------- testAddMessstation() --------------------");
        UmweltBehoerde umweltBehoerde = new UmweltBehoerde();
        Luftmessstation luftmessstation = new Luftmessstation("Wien", Year.now().minusYears(2), 21.0, 55.5);
        Laermmessstation laermmessstation = new Laermmessstation("Eisenstadt", Year.now(), 50.0, 30);
        Wetterstation wetterstation = new Wetterstation("Graz", Year.now().minusYears(10), 21, 12);
        System.out.println(umweltBehoerde.addMessstation(null));
        System.out.println(umweltBehoerde.addMessstation(luftmessstation));
        System.out.println(umweltBehoerde.addMessstation(luftmessstation));
        System.out.println(umweltBehoerde.addMessstation(laermmessstation));
        System.out.println(umweltBehoerde.addMessstation(wetterstation));
        System.out.println(umweltBehoerde);
        System.out.println();
    }

    private static void testBerechneDurchschnittswert() {
        System.out.println("-------------------- testBerechneDurchschnittswert() --------------------");
        UmweltBehoerde umweltBehoerde = new UmweltBehoerde();
        Luftmessstation luftmessstation = new Luftmessstation("Wien", Year.now().minusYears(2), 50.5, 50.5);
        Laermmessstation laermmessstation = new Laermmessstation("Eisenstadt", Year.now(), 50.0, 30);
        Wetterstation wetterstation1 = new Wetterstation("Graz", Year.now().minusYears(10), 20.5, 40);
        Wetterstation wetterstation2 = new Wetterstation("Leoben", Year.now().minusYears(1), 20, 40);
        System.out.println(umweltBehoerde.berechneDurchschnittMesswert());
        System.out.println("Luft: " + umweltBehoerde.berechneDurchschnittLuftmessstationen());
        System.out.println("Lärm: " + umweltBehoerde.berechneDurchschnittLaermmessstationen());
        System.out.println("Wetter: " + umweltBehoerde.berechneDurchschnittWetterstation());
        System.out.println();
        umweltBehoerde.addMessstation(luftmessstation);
        umweltBehoerde.addMessstation(laermmessstation);
        umweltBehoerde.addMessstation(wetterstation1);
        umweltBehoerde.addMessstation(wetterstation2);
        System.out.println(umweltBehoerde.berechneDurchschnittMesswert());
        System.out.println("Luft: " + umweltBehoerde.berechneDurchschnittLuftmessstationen());
        System.out.println("Lärm: " + umweltBehoerde.berechneDurchschnittLaermmessstationen());
        System.out.println("Wetter: " + umweltBehoerde.berechneDurchschnittWetterstation());
        System.out.println();
    }

    private static void testZaehleAlleStationenMitZuHohemWert() {
        System.out.println("-------------------- testZaehleAlleStationenMitZuHohemWert() --------------------");
        UmweltBehoerde umweltBehoerde = new UmweltBehoerde();
        Luftmessstation luftmessstation = new Luftmessstation("Wien", Year.now().minusYears(2), 21.0, 55.5);
        Laermmessstation laermmessstation = new Laermmessstation("Eisenstadt", Year.now(), 50.0, 30);
        Wetterstation wetterstation = new Wetterstation("Graz", Year.now().minusYears(10), 21, 12);
        umweltBehoerde.addMessstation(luftmessstation);
        umweltBehoerde.addMessstation(laermmessstation);
        umweltBehoerde.addMessstation(wetterstation);
        System.out.println("Anzahl zu hoher Wert (50): " + umweltBehoerde.zaehleAlleStationenMitZuHohemWert(50));
        System.out.println("Anzahl zu hoher Wert (0): " + umweltBehoerde.zaehleAlleStationenMitZuHohemWert(0));
        System.out.println("Anzahl zu hoher Wert (21): " + umweltBehoerde.zaehleAlleStationenMitZuHohemWert(21));
        System.out.println(umweltBehoerde);
        System.out.println();
    }

    private static void testSortieren() {
        System.out.println("-------------------- testSortieren() --------------------");
        UmweltBehoerde umweltBehoerde = new UmweltBehoerde();
        Luftmessstation luftmessstation = new Luftmessstation("Wien", Year.now().minusYears(2), 21.0, 55.5);
        Laermmessstation laermmessstation = new Laermmessstation("Eisenstadt", Year.now(), 50.0, 30);
        Wetterstation wetterstation = new Wetterstation("Graz", Year.now().minusYears(10), 21, 12);
        umweltBehoerde.addMessstation(luftmessstation);
        umweltBehoerde.addMessstation(laermmessstation);
        umweltBehoerde.addMessstation(wetterstation);
        System.out.println(umweltBehoerde);
        System.out.println();
        umweltBehoerde.sortiereMessstationen();
        System.out.println(umweltBehoerde);
        System.out.println();
    }

    private static void testRemoveMessstation() {
        System.out.println("-------------------- testRemoveMessstation() --------------------");
        UmweltBehoerde umweltBehoerde = new UmweltBehoerde();
        Luftmessstation luftmessstation = new Luftmessstation("Wien", Year.now().minusYears(2), 21.0, 55.5);
        Laermmessstation laermmessstation = new Laermmessstation("Eisenstadt", Year.now(), 50.0, 30);
        Wetterstation wetterstation = new Wetterstation("Graz", Year.now().minusYears(10), 21, 12);
        umweltBehoerde.addMessstation(luftmessstation);
        umweltBehoerde.addMessstation(laermmessstation);
        umweltBehoerde.addMessstation(wetterstation);
        System.out.println(umweltBehoerde);
        System.out.println();
        System.out.println(umweltBehoerde.removeMessstation(laermmessstation));
        System.out.println(umweltBehoerde);
        System.out.println();
    }

    private static void testZeigeNurLaermessstationen() {
        System.out.println("-------------------- testZeigeNurLaermessstationen() --------------------");
        UmweltBehoerde umweltBehoerde = new UmweltBehoerde();
        Luftmessstation luftmessstation = new Luftmessstation("Wien", Year.now().minusYears(2), 21.0, 55.5);
        Laermmessstation laermmessstation = new Laermmessstation("Eisenstadt", Year.now(), 50.0, 30);
        Wetterstation wetterstation = new Wetterstation("Graz", Year.now().minusYears(10), 21, 12);
        umweltBehoerde.addMessstation(luftmessstation);
        umweltBehoerde.addMessstation(laermmessstation);
        umweltBehoerde.addMessstation(wetterstation);
        System.out.println(umweltBehoerde);
        System.out.println();
        System.out.println("Nur Lärmstationen: ");
        umweltBehoerde.zeigeNurLaermmessstationen();
        System.out.println();
    }

    private static void testZeigeNurLuftmessstationen() {
        System.out.println("-------------------- testZeigeNurLuftmessstationen() --------------------");
        UmweltBehoerde umweltBehoerde = new UmweltBehoerde();
        Luftmessstation luftmessstation = new Luftmessstation("Wien", Year.now().minusYears(2), 21.0, 55.5);
        Laermmessstation laermmessstation = new Laermmessstation("Eisenstadt", Year.now(), 50.0, 30);
        Wetterstation wetterstation = new Wetterstation("Graz", Year.now().minusYears(10), 21, 12);
        umweltBehoerde.addMessstation(luftmessstation);
        umweltBehoerde.addMessstation(laermmessstation);
        umweltBehoerde.addMessstation(wetterstation);
        System.out.println(umweltBehoerde);
        System.out.println();
        umweltBehoerde.zeigeNurLuftmessstationen();
        System.out.println();
    }

    private static void testZeigeAlleStationen() {
        System.out.println("-------------------- testZeigeAlleStationen() --------------------");
        UmweltBehoerde umweltBehoerde = new UmweltBehoerde();
        Luftmessstation luftmessstation = new Luftmessstation("Wien", Year.now().minusYears(2), 21.0, 55.5);
        Laermmessstation laermmessstation = new Laermmessstation("Eisenstadt", Year.now(), 50.0, 30);
        Wetterstation wetterstation = new Wetterstation("Graz", Year.now().minusYears(10), 21, 12);
        umweltBehoerde.addMessstation(luftmessstation);
        umweltBehoerde.addMessstation(laermmessstation);
        umweltBehoerde.addMessstation(wetterstation);
        System.out.println(umweltBehoerde);
        System.out.println();
        System.out.println("Alle Stationen: ");
        umweltBehoerde.zeigeAlleStationen();
        System.out.println();
    }

    private static void testRemoveErsteStationNachStandort() {
        System.out.println("-------------------- testRemoveErsteStationNachStandort() --------------------");
        UmweltBehoerde umweltBehoerde = new UmweltBehoerde();
        Luftmessstation luftmessstation = new Luftmessstation("Wien", Year.now().minusYears(2), 21.0, 55.5);
        Laermmessstation laermmessstation = new Laermmessstation("Eisenstadt", Year.now(), 50.0, 30);
        Wetterstation wetterstation = new Wetterstation("Graz", Year.now().minusYears(10), 21, 12);
        umweltBehoerde.addMessstation(luftmessstation);
        umweltBehoerde.addMessstation(laermmessstation);
        umweltBehoerde.addMessstation(wetterstation);
        System.out.println(umweltBehoerde);
        System.out.println();
        System.out.println(umweltBehoerde.removeErsteStationNachStandort("Wien"));
        System.out.println(umweltBehoerde.removeErsteStationNachStandort("gibtEsNicht"));
        System.out.println(umweltBehoerde);
        System.out.println();
    }

    private static void testZaehleStationstypen() {
        System.out.println("-------------------- testZaehleStationstypen() --------------------");
        UmweltBehoerde umweltBehoerde = new UmweltBehoerde();
        Luftmessstation luftmessstation = new Luftmessstation("Wien", Year.now().minusYears(2), 21.0, 55.5);
        Laermmessstation laermmessstation = new Laermmessstation("Eisenstadt", Year.now(), 50.0, 30);
        Wetterstation wetterstation = new Wetterstation("Graz", Year.now().minusYears(10), 21, 12);
        umweltBehoerde.addMessstation(luftmessstation);
        umweltBehoerde.addMessstation(laermmessstation);
        umweltBehoerde.addMessstation(wetterstation);
        System.out.println(umweltBehoerde);
        System.out.println();
        umweltBehoerde.zaehleStationstypen();
        System.out.println();
    }

    private static void testRemoveAlleStationenAelterAls() {
        System.out.println("-------------------- testRemoveAlleStationenAelterAls() --------------------");
        UmweltBehoerde umweltBehoerde = new UmweltBehoerde();
        Luftmessstation luftmessstation = new Luftmessstation("Wien", Year.now().minusYears(2), 50.5, 50.5);
        Laermmessstation laermmessstation = new Laermmessstation("Eisenstadt", Year.now(), 50.0, 30);
        Wetterstation wetterstation1 = new Wetterstation("Graz", Year.now().minusYears(10), 20.5, 40);
        Wetterstation wetterstation2 = new Wetterstation("Leoben", Year.now().minusYears(1), 20, 40);
        System.out.println(umweltBehoerde);
        System.out.println();
        System.out.println("removeAlleStationenAelterAls(10): " + umweltBehoerde.removeAlleStationenAelterAls(10));
        System.out.println();
        umweltBehoerde.addMessstation(luftmessstation);
        umweltBehoerde.addMessstation(laermmessstation);
        umweltBehoerde.addMessstation(wetterstation1);
        umweltBehoerde.addMessstation(wetterstation2);
        System.out.println(umweltBehoerde);
        System.out.println();
        System.out.println("removeAlleStationenAelterAls(10): " + umweltBehoerde.removeAlleStationenAelterAls(10));
        System.out.println();
        System.out.println(umweltBehoerde);
        System.out.println();
        System.out.println("removeAlleStationenAelterAls(9): " + umweltBehoerde.removeAlleStationenAelterAls(9));
        System.out.println();
        System.out.println(umweltBehoerde);
        System.out.println();
        System.out.println("removeAlleStationenAelterAls(0): " + umweltBehoerde.removeAlleStationenAelterAls(0));
        System.out.println();
        System.out.println(umweltBehoerde);
        System.out.println();
    }

    private static void testZeigeStationenMitGrenzwertUeberschreitung() {
        System.out.println("-------------------- testZeigeStationenMitGrenzwertUeberschreitung() --------------------");
        UmweltBehoerde umweltBehoerde = new UmweltBehoerde();
        Luftmessstation luftmessstation = new Luftmessstation("Wien", Year.now().minusYears(2), 50.1, 50);
        Luftmessstation luftmessstation2 = new Luftmessstation("Wien", Year.now().minusYears(2), 50.0, 50);
        Laermmessstation laermmessstation = new Laermmessstation("Eisenstadt", Year.now(), 49.1, 49);
        Laermmessstation laermmessstation2 = new Laermmessstation("Eisenstadt", Year.now(), 49.0, 49);
        Wetterstation wetterstation1 = new Wetterstation("Graz", Year.now().minusYears(10), 41.5, 40);
        Wetterstation wetterstation2 = new Wetterstation("Leoben", Year.now().minusYears(1), 40.1, 40);
        System.out.println(umweltBehoerde);
        System.out.println();
        umweltBehoerde.zeigeStationenMitGrenzwertUeberschreitung();
        System.out.println();
        umweltBehoerde.addMessstation(luftmessstation2);
        umweltBehoerde.addMessstation(laermmessstation2);
        System.out.println(umweltBehoerde);
        System.out.println();
        umweltBehoerde.zeigeStationenMitGrenzwertUeberschreitung();
        System.out.println();
        umweltBehoerde.addMessstation(luftmessstation);
        umweltBehoerde.addMessstation(laermmessstation);
        umweltBehoerde.addMessstation(wetterstation1);
        umweltBehoerde.addMessstation(wetterstation2);
        System.out.println(umweltBehoerde);
        System.out.println();
        umweltBehoerde.zeigeStationenMitGrenzwertUeberschreitung();
        System.out.println();

        /*
        Messstationen:

        Keine Messstationen vorhanden

        Messstationen:
        Messtation: Standort: 'Wien', Installationsjahr: 2024, Messwert: 50.0, Stationstyp: Luftmessstation, Feinstaubgrenzwert: 50.0
        Messtation: Standort: 'Eisenstadt', Installationsjahr: 2026, Messwert: 49.0, Stationstyp: Laermmessstation, maximal erlaubter Pegel: 49.0

        Es wurden keine Überschreitungen von Grenzwerten gemessen


        Messstationen:
        Messtation: Standort: 'Wien', Installationsjahr: 2024, Messwert: 50.0, Stationstyp: Luftmessstation, Feinstaubgrenzwert: 50.0
        Messtation: Standort: 'Eisenstadt', Installationsjahr: 2026, Messwert: 49.0, Stationstyp: Laermmessstation, maximal erlaubter Pegel: 49.0
        Messtation: Standort: 'Wien', Installationsjahr: 2024, Messwert: 50.1, Stationstyp: Luftmessstation, Feinstaubgrenzwert: 50.0
        Messtation: Standort: 'Eisenstadt', Installationsjahr: 2026, Messwert: 49.1, Stationstyp: Laermmessstation, maximal erlaubter Pegel: 49.0
        Messtation: Standort: 'Graz', Installationsjahr: 2016, Messwert: 41.5, Stationstyp: Wetterstation, Temperatur: 40.0
        Messtation: Standort: 'Leoben', Installationsjahr: 2025, Messwert: 40.1, Stationstyp: Wetterstation, Temperatur: 40.0

        Messtation: Standort: 'Wien', Installationsjahr: 2024, Messwert: 50.1, Stationstyp: Luftmessstation, Feinstaubgrenzwert: 50.0
        FeinstaubGrenzwert: 50.0
        Messwert: 50.1
        Überschreitung um 0.10000000000000142

        Messtation: Standort: 'Eisenstadt', Installationsjahr: 2026, Messwert: 49.1, Stationstyp: Laermmessstation, maximal erlaubter Pegel: 49.0
        MaxErlaubterPegel: 49.0
        Messwert: 49.1
        Überschreitung um 0.10000000000000142

        Messtation: Standort: 'Graz', Installationsjahr: 2016, Messwert: 41.5, Stationstyp: Wetterstation, Temperatur: 40.0
        Temperatur: 40.0
        Messwert: 41.5
        Überschreitung um 1.5

        Messtation: Standort: 'Leoben', Installationsjahr: 2025, Messwert: 40.1, Stationstyp: Wetterstation, Temperatur: 40.0
        Temperatur: 40.0
        Messwert: 40.1
        Überschreitung um 0.10000000000000142

         */
    }
}
