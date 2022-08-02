package HW1.task1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static HW1.ConcurrentUtils.stop;

public class FireStation{

    public static final int SECONDS_IN_DAY = 86400;
    //static List<String>
    //public static int count;

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);
        var thread = new Thread(new CallFireStation());
        thread.start();

                    IntStream.range(0,SECONDS_IN_DAY).forEach(i ->
                        executor.submit(CallFireStation::operatorCall));


        stop(executor);

    }

}

