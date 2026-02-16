package at.bal;

import java.time.Year;

public class Main {
    public static void main(String[] args) {
        Mitarbeiter mitarbeiter = new Mitarbeiter("Anna", Year.of(2001), Year.now());
        System.out.println(mitarbeiter);
        Personalbuero personalbuero = new Personalbuero();
        System.out.println(personalbuero);
        System.out.println();
        System.out.println(personalbuero.aufnehmen(null));
        System.out.println();
        System.out.println(personalbuero.aufnehmen(mitarbeiter));
        System.out.println(personalbuero);
        Mitarbeiter mitarbeiter1 = new Mitarbeiter("Rodion", Year.of(2007), Year.now());
        personalbuero.aufnehmen(mitarbeiter1);
        personalbuero.aufnehmen(mitarbeiter1);
        System.out.println(personalbuero);
        System.out.println();
    }
}