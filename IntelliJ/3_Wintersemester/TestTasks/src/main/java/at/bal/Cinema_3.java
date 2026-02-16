package at.bal;

public class Cinema_3 {
    public static void main(String[] args) {

        boolean[][] seats = new boolean[5][10];
        int persons = 3;

        for (int row = 0; row < seats.length; row++) {
            int count = 0;

            for (int col = 0; col < seats[row].length; col++) {
                if (!seats[row][col]) {
                    count++;
                    if (count == persons) {
                        System.out.println("Plätze in Reihe " + row);
                        return;
                    }
                } else {
                    count = 0;
                }
            }
        }
    }
}
