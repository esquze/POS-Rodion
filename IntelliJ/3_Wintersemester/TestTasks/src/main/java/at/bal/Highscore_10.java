package at.bal;

public class Highscore_10 {
    public static void main(String[] args) {

        int[] scores = {100, 90, 80, 70, 60};
        int newScore = 85;

        for (int i = 0; i < scores.length; i++) {
            if (newScore > scores[i]) {
                for (int j = scores.length - 1; j > i; j--) {
                    scores[j] = scores[j - 1];
                }
                scores[i] = newScore;
                break;
            }
        }
    }
}

