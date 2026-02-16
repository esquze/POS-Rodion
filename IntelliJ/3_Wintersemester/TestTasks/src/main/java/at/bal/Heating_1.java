package at.bal;

public class Heating_1 {
    public static void main(String[] args) {

        int[] temp = {18,17,17,16,16,17,18,20,22,23,24,24,23,22,21,20,19,18,18,17,17,16,16,16};

        int min = temp[0];
        int max = temp[0];
        int sum = 0;

        for (int i = 0; i < temp.length; i++) {
            if (temp[i] < min) min = temp[i];
            if (temp[i] > max) max = temp[i];
            sum += temp[i];
        }

        double avg = sum / (double) temp.length;

        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
        System.out.println("Avg: " + avg);
    }
}
