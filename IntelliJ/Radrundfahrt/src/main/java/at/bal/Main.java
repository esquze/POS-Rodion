package at.bal;

public class Main {
    public static void main(String[] args) {

        RadRundfahrt rr = new RadRundfahrt("Wien Radrundfahrt");

        Etappe e1 = new Etappe(151, "Bad Aussee", "Rodion", 4, 21);
        rr.hinzufuegen(e1);

        Etappe e2 = new Etappe(218, "Altaussee", "Alen", 6, 55);
        rr.hinzufuegen(e2);

        Etappe e3 = new Etappe(171, "Bad Ischl", "Sasha", 5, 32);
        rr.hinzufuegen(e3);

        System.out.println(rr.toString());
    }
}