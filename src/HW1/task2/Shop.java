package HW1.task2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

public class Shop implements Runnable {
    List<Product> products;
    Producer producer;

    public Shop(Producer producer) {
        this.products = producer.call();
        this.producer = producer;
    }

    @Override
    public void run() {
        try {
            producer.call()
                    .stream()
                    .map(p -> p + p.getDateOfExpiry().format(DateTimeFormatter.ofPattern(" dd-MMM-yy "))
                            + ", expired: " + productExpired(p.getDateOfExpiry()))
                    .collect(Collectors.toList())
                    .forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static boolean productExpired(LocalDate date){
        return date.isBefore(LocalDate.now());
    }
}
