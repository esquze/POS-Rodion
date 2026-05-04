package at.bal.model;

import java.time.Year;

public class Main {
    static void main() {
        //Mitarbeiter mitarbeiter = new Mitarbeiter();
//        Mitarbeiter mitarbeiter = new Mitarbeiter("Anna", Year.of(2001), Year.now());
//        System.out.println(mitarbeiter);
//        System.out.println();
//        Personalbuero personalbuero = new Personalbuero();
//        System.out.println(personalbuero);
//        System.out.println();
//        System.out.println(personalbuero.aufnehmen(null));
//        System.out.println();
//        System.out.println(personalbuero.aufnehmen(mitarbeiter));
//        System.out.println(personalbuero);
//        Mitarbeiter mitarbeiter1 = new Mitarbeiter("Hanna", Year.of(2002), Year.now());
//        personalbuero.aufnehmen(mitarbeiter1);
//        personalbuero.aufnehmen(mitarbeiter1);
//        System.out.println(personalbuero);
//        System.out.println();

       // testSortierenAlter();

      //  testSortierenNachDienstalter();

      //  testSortierenNachName();

        testSave();
    }

    public static void testSortierenAlter() {
        try {
            System.out.println("------------------ sortierenAlter --------------");
            Personalbuero personalbuero = new Personalbuero();
            Mitarbeiter mitarbeiter1 = new Angestellter("Anna", Year.of(2002), Year.now().minusYears(3));
            Mitarbeiter mitarbeiter2 = new Angestellter("Bert", Year.of(2003), Year.now().minusYears(2));
            Mitarbeiter mitarbeiter3 = new Angestellter("Cäsar", Year.of(2004), Year.now().minusYears(1));
            Mitarbeiter mitarbeiter4 = new Angestellter("Emma", Year.of(2005), Year.now());
            personalbuero.aufnehmen(mitarbeiter1);
            personalbuero.aufnehmen(mitarbeiter2);
            personalbuero.aufnehmen(mitarbeiter3);
            personalbuero.aufnehmen(mitarbeiter4);
            System.out.println(personalbuero);
            System.out.println();
            personalbuero.sortierenNachAlter();
            System.out.println(personalbuero);
            System.out.println();
        } catch (PersonalException e) {
            System.out.println("Unwartete Exception: " + e.getMessage());
        }
    }

    public static void testSortierenNachDienstalter() {
        try {
            System.out.println("------------------ sortierenNachDienstalter --------------");
            Personalbuero personalbuero = new Personalbuero();
            Mitarbeiter mitarbeiter9 = new Angestellter("Anna", Year.of(2002), Year.now().minusYears(15));
            Mitarbeiter mitarbeiter10 = new Angestellter("Bert", Year.of(2003), Year.now().minusYears(10));
            Mitarbeiter mitarbeiter11 = new Angestellter("Cäsar", Year.of(2004), Year.now().minusYears(25));
            Mitarbeiter mitarbeiter12 = new Angestellter("Emma", Year.of(2005), Year.now());
            personalbuero.aufnehmen(mitarbeiter9);
            personalbuero.aufnehmen(mitarbeiter10);
            personalbuero.aufnehmen(mitarbeiter11);
            personalbuero.aufnehmen(mitarbeiter12);
            System.out.println(personalbuero);
            System.out.println();
            personalbuero.sortierenNachDienstalter();
            System.out.println(personalbuero);
            System.out.println();
        } catch (PersonalException e) {
            System.out.println("Unwartete Exception: " + e.getMessage());
        }
    }

    public static void testSortierenNachName() {
        try {
            System.out.println("------------------ sortierenNachName --------------");
            Personalbuero personalbuero = new Personalbuero();
            Mitarbeiter mitarbeiter13 = new Angestellter("Zölestin", Year.of(2002), Year.now().minusYears(15));
            Mitarbeiter mitarbeiter14 = new Angestellter("Yasmin", Year.of(2003), Year.now().minusYears(10));
            Mitarbeiter mitarbeiter15 = new Angestellter("Xaver", Year.of(2004), Year.now().minusYears(25));
            Mitarbeiter mitarbeiter16 = new Angestellter("Wilma", Year.of(2005), Year.now());
            personalbuero.aufnehmen(mitarbeiter13);
            personalbuero.aufnehmen(mitarbeiter14);
            personalbuero.aufnehmen(mitarbeiter15);
            personalbuero.aufnehmen(mitarbeiter16);
            System.out.println(personalbuero);
            System.out.println();
            personalbuero.sortierenNachName();
            System.out.println(personalbuero);
            System.out.println();
        } catch (PersonalException e) {
            System.out.println("Unwartete Exception: " + e.getMessage());
        }
    }

    public static void testSave() {
        try {
            System.out.println("------------------ testSave --------------");
            Personalbuero personalbuero = new Personalbuero();
            Mitarbeiter mitarbeiter13 = new Angestellter("Zölestin", Year.of(2002), Year.now().minusYears(15));
            Mitarbeiter mitarbeiter14 = new Angestellter("Yasmin", Year.of(2003), Year.now().minusYears(10));
            Mitarbeiter mitarbeiter15 = new Angestellter("Xaver", Year.of(2004), Year.now().minusYears(25));
            Mitarbeiter mitarbeiter16 = new Angestellter("Wilma", Year.of(2005), Year.now());
            personalbuero.aufnehmen(mitarbeiter13);
            personalbuero.aufnehmen(mitarbeiter14);
            personalbuero.aufnehmen(mitarbeiter15);
            personalbuero.aufnehmen(mitarbeiter16);
            System.out.println(personalbuero);
            System.out.println();
            personalbuero.sortierenNachName();
            System.out.println(personalbuero);
            System.out.println();
            personalbuero.save();
            System.out.println("Mitarbeiter wurden gespeichert");
            System.out.println();
        } catch (PersonalException e) {
            System.out.println("Unwartete Exception: " + e.getMessage());
        }
    }
}
