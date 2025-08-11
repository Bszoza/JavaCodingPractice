package Zadania11;

import java.util.Comparator;

public class ProductComparators {
public static class PriceThenAlphabetComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return Comparator.comparing(Product::getPrice).thenComparing(Product::getName).compare(o1, o2);
    }
}


}
