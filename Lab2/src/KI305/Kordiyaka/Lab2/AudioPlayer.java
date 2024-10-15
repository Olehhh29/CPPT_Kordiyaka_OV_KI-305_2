/**
 * KI305.Kordiyaka.Lab2 package
 */
package KI305.Kordiyaka.Lab2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Клас AudioPlayer реалізує аудіоплеєр з можливістю відтворення, паузи та перемикання треків.
 */
public class AudioPlayer {
    // Поля
    private List<String> playlist;
    private int currentTrackIndex;
    private boolean isPlaying;
    private FileWriter logWriter;

    // Конструктори
    /**
     * Дефолтний конструктор
     * @throws IOException
     */
    public AudioPlayer() throws IOException {
        this.playlist = new ArrayList<>();
        this.currentTrackIndex = 0;
        this.isPlaying = false;
        this.logWriter = new FileWriter("player_log.txt", true);
        log("Аудіоплеєр створено.");
    }

    /**
     * Конструктор з параметрами
     * @param playlist
     * @throws IOException
     */
    public AudioPlayer(List<String> playlist) throws IOException {
        this.playlist = playlist;
        this.currentTrackIndex = 0;
        this.isPlaying = false;
        this.logWriter = new FileWriter("player_log.txt", true);
        log("Аудіоплеєр створено з плейлистом.");
    }

    // Методи

    /**
     * Метод додавання треку
     * @param track
     * @throws IOException
     */
    public void addTrack(String track) throws IOException {
        playlist.add(track);
        log("Додано трек: " + track);
    }

    /**
     * Метод відігравання треку
     * @throws IOException
     */
    public void play() throws IOException {
        if (!playlist.isEmpty() && currentTrackIndex < playlist.size()) {
            isPlaying = true;
            log("Відтворюється трек: " + playlist.get(currentTrackIndex));
        } else {
            log("Неможливо відтворити трек.");
        }
    }

    /**
     * Метод паузи
     * @throws IOException
     */
    public void pause() throws IOException {
        if (isPlaying) {
            isPlaying = false;
            log("Плейер поставлено на паузу.");
        } else {
            log("Плейер вже на паузі.");
        }
    }

    /**
     * Метод зупинки
     * @throws IOException
     */
    public void stop() throws IOException {
        if (isPlaying) {
            isPlaying = false;
            log("Відтворення зупинено.");
        }
    }

    /**
     * Метод наступного треку
     * @throws IOException
     */
    public void nextTrack() throws IOException {
        if (currentTrackIndex < playlist.size() - 1) {
            currentTrackIndex++;
            log("Перемикання на наступний трек: " + playlist.get(currentTrackIndex));
            play();
        } else {
            log("Це останній трек у плейлисті.");
        }
    }

    /**
     * Метод попереднього треку
     * @throws IOException
     */
    public void previousTrack() throws IOException {
        if (currentTrackIndex > 0) {
            currentTrackIndex--;
            log("Перемикання на попередній трек: " + playlist.get(currentTrackIndex));
            play();
        } else {
            log("Це перший трек у плейлисті.");
        }
    }

    /**
     * Метод показу списку треків
     * @throws IOException
     */
    public void displayPlaylist() throws IOException {
        log("Відображення плейлисту:");
        for (String track : playlist) {
            log("Трек: " + track);
        }
    }

    /**
     * Метод видалення треку
     * @param track
     * @throws IOException
     */
    public void removeTrack(String track) throws IOException {
        if (playlist.remove(track)) {
            log("Трек видалено: " + track);
        } else {
            log("Трек не знайдено: " + track);
        }
    }

    /**
     * Метод запису у файл
     * @param message
     * @throws IOException
     */
    // Протоколювання подій
    private void log(String message) throws IOException {
        logWriter.write(message + "\n");
        logWriter.flush();
    }

    /**
     * Метод завершення роботи
     * @throws IOException
     */
    // Коректне завершення роботи з файлом
    public void close() throws IOException {
        log("Закриття аудіоплеєра.");
        logWriter.close();
    }
}
