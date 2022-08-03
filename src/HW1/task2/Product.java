package HW1.task2;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

public class Product {
    private static final AtomicInteger countId = new AtomicInteger(0);
    private int productID;
    private String productName;
    private LocalDate dateOfExpiry;


    public Product(String name, LocalDate dateOfExpiry) {
        this.productID = countId.incrementAndGet();
        this.productName = name;
        this.dateOfExpiry = dateOfExpiry;
    }

    public int getProductID() {
        return productID;
    }

    public String getName() {
        return productName;
    }

    public LocalDate getDateOfExpiry() {
        return dateOfExpiry;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", name='" + productName + '\'' +
                ", dateOfExpiry=" + dateOfExpiry +
                '}';
    }
}
