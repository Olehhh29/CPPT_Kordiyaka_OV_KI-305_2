package KI305.Kordiyaka.Lab2;

import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;

/**
 * AudioPlayerDriver клас для тестування і демонстрації роботи класу AudioPlayer.
 * @author Oleh Kordiyaka
 * @version 1.0
 */
public class AudioPlayerDriver {
    public static void main(String[] args) {
        try {
            AudioPlayer player = new AudioPlayer(new ArrayList<>(Arrays.asList("Song1", "Song2", "Song3")));
            player.displayPlaylist();
            player.play();
            player.nextTrack();
            player.pause();
            player.previousTrack();
            player.stop();
            player.addTrack("Song4");
            player.displayPlaylist();
            player.removeTrack("Song2");
            player.displayPlaylist();
            player.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
