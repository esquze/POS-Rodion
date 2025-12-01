package at.bal;

public class Main {
    public static void main(String[] args) {

        RadRundfahrt rr = new RadRundfahrt("Wien Radrundfahrt");

        Etappe e1 = new Etappe(151, "Bad Aussee", "Rodion", 4, 21);
        Etappe e2 = new Etappe(218, "Altaussee", "Alen", 6, 55);
        Etappe e3 = new Etappe(171, "Bad Ischl", "Sasha", 5, 32);
        Etappe e4 = new Etappe(134, "Gmunden", "Rodion", 3, 47);
        Etappe e5 = new Etappe(189, "Hallstatt", "Sasha", 5, 12);
        Etappe e6 = new Etappe(205, "Mondsee", "Rodion", 6, 3);
        Etappe e7 = new Etappe(163, "St. Wolfgang", "Alen", 4, 58);

        rr.hinzufuegen(e1);
        rr.hinzufuegen(e2);
        rr.hinzufuegen(e3);
        rr.hinzufuegen(e4);
        rr.hinzufuegen(e5);
        rr.hinzufuegen(e6);
        rr.hinzufuegen(e7);
        rr.annullieren(1);

        System.out.println(rr.toString());
    }
}