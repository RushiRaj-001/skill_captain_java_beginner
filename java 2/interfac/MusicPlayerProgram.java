
// 1. Create an interface called `MusicPlayer` with the following methods:

import java.util.ArrayList;
import java.util.List;

interface MusicPlayer {

    void play();

    void pause();

    void stop();

    void addsong(String song);

    void removeSong(String song);
}

class MyMusicPlayer implements MusicPlayer {

    public List<String> songs = new ArrayList<>();

    @Override
    public void play() {
        if (!songs.isEmpty()) {
            System.out.println("song play");
        } else {
            System.out.println("no song in playlist");
        }
    }

    @Override
    public void pause() {
        System.out.println("Song Pause");
    }

    @Override
    public void stop() {
        System.out.println("Song Stop");
    }

    @Override
    public void addsong(String song) {
        songs.add(song);
        System.out.println(song + " added");
    }

    @Override
    public void removeSong(String song) {
        songs.remove(song);
        System.out.println(song + " remove");
    }
}

public class MusicPlayerProgram {

    public static void main(String[] args) {
        MyMusicPlayer m1 = new MyMusicPlayer();

        m1.addsong("song 1");
        m1.addsong("song 2");
        m1.addsong("song 3");
        m1.addsong("song 4");
        m1.addsong("song 5");

        m1.play();
        m1.pause();
        m1.stop();
        m1.removeSong("song 2");
    }

}