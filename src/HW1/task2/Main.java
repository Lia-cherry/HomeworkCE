package HW1.task2;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Product milk = new Product("Harvest Moon Milk Alternative UHT Classic 2,1% - Bio - 1L", LocalDate.of(2022,8,1));
        Product butter = new Product("Kerrygold Original Irische Butter (250 g)", LocalDate.of(2022,9,1));

        Producer kerrygold = new Producer();

        kerrygold.add(milk);
        kerrygold.add(butter);


        Shop consumer = new Shop(kerrygold);

        System.out.println(kerrygold.call());
        consumer.run();
    }



}
