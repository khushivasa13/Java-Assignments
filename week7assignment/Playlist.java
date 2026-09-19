import java.util.Arrays;

public class Playlist {

    private final String[] songs;
    private int songCount;

    public Playlist(int maxSize) {
        songs = new String[maxSize];
        songCount = 0;
    }

    public void addSong(String song) {

        if (songCount >= songs.length) {
            System.out.println("Playlist is full");
            return;
        }

        songs[songCount] = song;
        songCount++;
    }

    public String[] getSongs() {

        return Arrays.copyOf(songs, songCount);
    }

    public int getSongCount() {
        return songCount;
    }

    public static void main(String[] args) {

        Playlist p = new Playlist(10);

        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();

        System.out.println("Original songs:");
        for (String song : p.getSongs()) {
            System.out.println(song);
        }

        copy[0] = "Hacked";

        System.out.println("\nAfter modifying the copy:");
        for (String song : p.getSongs()) {
            System.out.println(song);
        }

        System.out.println("\nSong count: " + p.getSongCount());
    }
}