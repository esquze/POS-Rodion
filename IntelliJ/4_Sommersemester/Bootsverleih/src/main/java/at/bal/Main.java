package at.bal;

public class Main {

    public static void main(String[] args) {
        testHinzufuegen();
        testSortieren();
        testEntfernen();
        testEntfernenAlle();
    }

    private static void testEntfernenAlle() {
        try {
            Bootsverleih bootsverleih = new Bootsverleih("Bootsverleih Test EntfernenAlle");
            EventBoot eventBoot = new EventBoot(12, "Ausflugsboot", 1200.0);
            SegelBoot segelBoot1 = new SegelBoot(2, "Ausflugsboot", 1000.0, false);
            SegelBoot segelBoot2 = new SegelBoot(1, "Ausflugsboot", 1000.0, false);
            bootsverleih.hinzufuegen(eventBoot);
            bootsverleih.hinzufuegen(segelBoot1);
            bootsverleih.hinzufuegen(segelBoot2);
            System.out.println(bootsverleih);
            System.out.println();
            System.out.println(bootsverleih.entfernen("Ausflugsboot"));
            System.out.println();
            System.out.println(bootsverleih);
            System.out.println();
        } catch (BootException e) {
            System.out.println("Unerwartete Exception: " + e.getMessage());
        }
    }

    private static void testEntfernen() {
        try {
            Bootsverleih bootsverleih = new Bootsverleih("Bootsverleih Test Entfernen");
            EventBoot eventBoot = new EventBoot(12, "Oase", 1200.0);
            SegelBoot segelBoot1 = new SegelBoot(2, "Searay", 1000.0, false);
            SegelBoot segelBoot2 = new SegelBoot(1, "Windjammer", 1000.0, false);
            bootsverleih.hinzufuegen(eventBoot);
            bootsverleih.hinzufuegen(segelBoot1);
            bootsverleih.hinzufuegen(segelBoot2);
            System.out.println(bootsverleih);
            System.out.println();
            System.out.println(bootsverleih.entfernen((Boot) null));
            System.out.println();
            System.out.println(bootsverleih);
            System.out.println();
        } catch (BootException e) {
            System.out.println("Unerwartete Exception: " + e.getMessage());
        }
    }

    private static void testSortieren() {
        try {
            Bootsverleih bootsverleih = new Bootsverleih("Bootsverleih Test Sortieren");
            EventBoot eventBoot = new EventBoot(12, "Oase", 1200.0);
            SegelBoot segelBoot1 = new SegelBoot(2, "Searay", 1000.0, false);
            SegelBoot segelBoot2 = new SegelBoot(1, "Windjammer", 1000.0, false);
            bootsverleih.hinzufuegen(eventBoot);
            bootsverleih.hinzufuegen(segelBoot1);
            bootsverleih.hinzufuegen(segelBoot2);
            System.out.println(bootsverleih);
            System.out.println();
            bootsverleih.sortieren();
            System.out.println(bootsverleih);
            System.out.println();
        } catch (BootException e) {
            System.out.println("Unerwartete Exception: " + e.getMessage());
        }
    }

    private static void testHinzufuegen() {
        try {
            Bootsverleih bootsverleih = new Bootsverleih("Bootsverleih Test Hinzufuegen");
            SegelBoot segelBoot = new SegelBoot(2, "Searay", 1000.0, false);
            bootsverleih.hinzufuegen(segelBoot);
            System.out.println(bootsverleih);
            System.out.println();
        } catch (BootException e) {
            System.out.println("Unerwartete Exception: " + e.getMessage());
        }
    }
}
