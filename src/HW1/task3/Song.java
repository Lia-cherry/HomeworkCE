package HW1.task3;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Song{
    private static final AtomicInteger countId = new AtomicInteger(0);

    static ConcurrentHashMap<Integer,Song> songs = new ConcurrentHashMap<>();

    static List<String> songNames = new CopyOnWriteArrayList<>
            (Arrays.asList("Comfortably Numb", "Dear moon", "Copycat", "Monster", "Brigit"));

    static ListIterator<String> iterator = songNames.listIterator();
    private final int songID;
    private final String songName;
    private final String songGenre;

    public Song(String songName, String songGenre) {
        this.songID = countId.incrementAndGet();
        this.songName = songName;
        this.songGenre = songGenre;
        songs.put(songID,this);
    }

    static Song findSong(String genre){
        for(Song o: songs.values()){
            if (genre.equals(o.getSongGenre())){
                return o;
            }
        }
        return null;
    }

    public enum Genre{
        POP, ROCK, JAZZ, RAP, BLUES
    }

    public String getSongGenre() {
        return songGenre;
    }

    @Override
    public String toString() {
        return "Song{" +
                "songID=" + songID +
                ", songName='" + songName + '\'' +
                ", songGenre='" + songGenre + '\'' +
                '}';
    }
}
