package at.bal;

public class Image_9 {
    public static void main(String[] args) {

        int[][] img = {{0, 50}, {200, 255}};

        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[i].length; j++) {
                img[i][j] += 50;
                if (img[i][j] > 255) {
                    img[i][j] = 255;
                }
            }
        }
    }
}

