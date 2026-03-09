package at.bal;

public class Main {
    public static void main(String[] args) {
        Notizen notizen = new Notizen();
        notizen.ausgebenNotizen();
        System.out.println();

        System.out.println(notizen.notizHinzufuegen("Brot einkaufen"));
        System.out.println(notizen.notizHinzufuegen("Brot einkaufen"));
        System.out.println(notizen.notizHinzufuegen("Anna anrufen"));
        System.out.println(notizen.notizHinzufuegen("Film mit Van Damme streamen"));
        System.out.println(notizen.notizHinzufuegen("Chips einkaufen"));
        System.out.println(notizen.notizHinzufuegen("Ins Gym gehen"));

        notizen.ausgebenNotizen();
        System.out.println();

        notizen.sortierenAlphabetisch();
        notizen.ausgebenNotizen();
        System.out.println();

        System.out.println(notizen.notizEntfernen("Ins Gym gehen"));
        notizen.ausgebenNotizen();
        System.out.println();

        notizen.sortierenNachLaengeAbsteigend();
        notizen.ausgebenNotizen();
        System.out.println();

        notizen.notizHinzufuegen("Perl lernen");
        notizen.notizHinzufuegen("Java lernen");
        notizen.ausgebenNotizen();
        System.out.println();

        notizen.sortierenAlphabetisch();
        notizen.ausgebenNotizen();
        System.out.println();

        notizen.sortierenNachDerLaengeAufsteigend();
        notizen.ausgebenNotizen();
        System.out.println();

        notizen.notizHinzufuegen("ZZZZ lernen");
        notizen.notizHinzufuegen("AAAA lernen");
        notizen.ausgebenNotizen();
        System.out.println();

        notizen.sortierenNachDerLaengeAufsteigend();
        notizen.ausgebenNotizen();
        System.out.println();


    }
}