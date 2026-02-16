package at.bal;

class Song {
    String title;
    String genre;

    Song(String t, String g) {
        title = t;
        genre = g;
    }
}

public class Playlist_2 {
    public static void main(String[] args) {

        Song[] songs = new Song[3];
        songs[0] = new Song("A", "Rock");
        songs[1] = new Song("B", "Pop");
        songs[2] = new Song("C", "Rock");

        for (int i = 0; i < songs.length; i++) {
            if (songs[i].genre.equals("Rock")) {
                System.out.println(songs[i].title);
            }
        }
    }
}
