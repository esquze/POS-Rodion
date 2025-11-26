package at.bal;

public class Main {
    public static void main(String[] args) {

        Etappe e = new Etappe(151, "Bad Aussee");
        e.getNummer(1);
        e.getSieger("Huber");
        e.getStunden(4);
        e.getMinuten(21);

        System.out.println(e.toString());
    }
}