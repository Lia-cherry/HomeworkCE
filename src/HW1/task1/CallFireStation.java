package HW1.task1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import static HW1.ConcurrentUtils.sleep;

public class CallFireStation  implements Runnable{
    static ReentrantLock lock = new ReentrantLock();
    static StringBuilder threadName;
    static Queue<String> streets= new LinkedList<>();

    @Override
        public void run() {
            System.out.println("Enter address of fire: ");
            var scanner = new Scanner(System.in);
            while (scanner.hasNextLine()){
                var street = scanner.nextLine();
                if (!street.trim().equals(""))
                streets.add(street);
                System.out.println("Enter address of fire: ");
            }
    }
    static void operatorCall(){

        lock.lock();
        try {
            while (streets.isEmpty()){
                sleep(1);
            }
                threadName = new StringBuilder(Thread.currentThread().getName());
                System.out.println("\nFire brigade " + threadName.charAt(threadName.length() - 1) + " going on " + streets.peek());
                streets.remove();
                sleep(5);
        } finally {
            lock.unlock();
        }
    }
}
