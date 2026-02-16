package at.bal;

public class Parking_6 {
    public static void main(String[] args) {

        String[] places = {null, "Auto", null, "Auto"};

        for (int i = 0; i < places.length; i++) {
            if (places[i] == null) {
                System.out.println("Freier Platz: " + i);
                break;
            }
        }
    }
}

