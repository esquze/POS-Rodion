package at.bal;

public class Main {
    public static void main(String[] args) {
        try {
            testBetriebszertifikat();
            System.out.println();
            testZertifikatsverwaltung();
            System.out.println();
            testTopNachhaltigkeitsScore();
            System.out.println();
        } catch (UmweltProjektException e) {
            System.out.println("Unerwartete exception: Upps, irgendwas lief schief...");
            System.out.println(e.getMessage());
        }
    }

    private static void testBetriebszertifikat() throws UmweltProjektException {
        BetriebsZertifikat betriebsZertifikat =
                new BetriebsZertifikat("Z-2026-001", "GreenCity Festival",
                        20.5, 78.0, 10);
        System.out.println(betriebsZertifikat);
    }

    private static void testZertifikatsverwaltung() throws UmweltProjektException {
        ZertifikatsVerwaltung zertifikatsVerwaltung = new ZertifikatsVerwaltung();
        zertifikatsVerwaltung.druckAlle();

        BetriebsZertifikat betriebsZertifikat =
                new BetriebsZertifikat("Z-2026-001", "GreenCity Festival",
                        20.5, 78.0, 10);
        zertifikatsVerwaltung.addZertifikat(betriebsZertifikat);
        zertifikatsVerwaltung.druckAlle();
    }

    private static void testTopNachhaltigkeitsScore() throws UmweltProjektException {
        ZertifikatsVerwaltung zertifikatsVerwaltung = new ZertifikatsVerwaltung();
        BetriebsZertifikat betriebsZertifikat =
                new BetriebsZertifikat("Z-2026-001", "GreenCity Festival",
                        20.5, 78.0, 10);
        zertifikatsVerwaltung.addZertifikat(betriebsZertifikat);
        zertifikatsVerwaltung.druckAlle();
    }

}