package comparatory;

public class Estate implements Comparable<Estate>{
    private String city;
    private Double price;
    private Double area;

    public Estate(String city, Double price, Double area) {
        this.city = city;
        this.price = price;
        this.area = area;
    }

    public Estate() {
    }

    @Override
    public int compareTo(Estate o) {
        Double thisM2 = this.price/this.area;
        Double oM2 = o.price/o.area;
        return thisM2.compareTo(oM2);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Estate{" +
                "city='" + city + '\'' +
                ", price=" + price +
                ", area='" + area + '\'' +
                '}';
    }
}
