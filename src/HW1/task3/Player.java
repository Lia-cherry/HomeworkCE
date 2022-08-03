package HW1.task3;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Player {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService genres = Executors.newFixedThreadPool(5);

        List<Callable<String>> callables = Arrays.asList(
                Song.Genre.POP::toString,
                Song.Genre.RAP::toString,
                Song.Genre.BLUES::toString,
                Song.Genre.JAZZ::toString,
                Song.Genre.ROCK::toString);

        genres.invokeAll(callables)
                .stream()
                .map(future -> {
                    try {
                        new Song(Song.iterator.next(), future.get());
                        return future.get();
                    }
                    catch (Exception e) {
                        throw new IllegalStateException(e);
                    }
                })
                .forEach(x -> System.out.println(Song.findSong(x)));
    }
}
