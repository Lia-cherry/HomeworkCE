package HW1.task2;

import HW1.ConcurrentUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

public class Producer implements Callable {

    private final List<Product> products = new ArrayList<>();

    public void add(Product product) {
        this.products.add(product);
    }

    @Override
    public List<Product> call(){
        ConcurrentUtils.sleep(1);
        return products;
    }

}

