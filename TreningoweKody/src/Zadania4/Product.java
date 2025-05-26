package Zadania4;


public class Product {
    private String name;
    private Double price;
    private Boolean available;

    public Product(String name, Double price, Boolean available) {
        this.name = name;
        this.price = price;
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Boolean getAvailable() {
        return available;
    }


    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", available=" + available +
                '}';
    }
}
