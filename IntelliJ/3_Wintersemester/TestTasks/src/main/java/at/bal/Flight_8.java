package at.bal;

public class Flight_8 {
    public static void main(String[] args) {

        String[] seats = new String[2];
        String[] wait = {"Anna", "Tom"};
        int waitSize = 2;

        seats[0] = "Max";

        if (seats[1] == null && waitSize > 0) {
            seats[1] = wait[0];

            for (int i = 0; i < waitSize - 1; i++) {
                wait[i] = wait[i + 1];
            }
            waitSize--;
        }
    }
}

