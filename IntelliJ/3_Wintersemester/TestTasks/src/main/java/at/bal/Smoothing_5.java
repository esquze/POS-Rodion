package at.bal;

public class Smoothing_5 {
    public static void main(String[] args) {

        int[] data = {10, 20, 30, 40, 50};
        int[] smooth = new int[data.length];

        for (int i = 0; i < data.length; i++) {
            if (i == 0 || i == data.length - 1) {
                smooth[i] = data[i];
            } else {
                smooth[i] = (data[i - 1] + data[i] + data[i + 1]) / 3;
            }
        }
    }
}

