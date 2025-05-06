package categories;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ProductData {
    private Map<String, Product> products = new HashMap<String, Product>();
    private List <Product> productList = new ArrayList<>();
    public ProductData() {
    }

    public void readData(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] parts = line.split(";");
            String category = parts[0];
            String name = parts[1];
            double price = Double.parseDouble(parts[2]);
            Product product = new Product(category, name, price);
            products.put(category, product);
        }
    }


    public void showMap(String category) {
        Double avg = 0.0;
        Integer count = 0;
        for (String key : products.keySet()) {
            if (key.equals(category)) {
                System.out.println(products.get(key));
                avg += products.get(key).getPrice();
                count++;
            }
        }
        avg /= count;
        System.out.println("Wartość średnia: " + avg);

    }


}
