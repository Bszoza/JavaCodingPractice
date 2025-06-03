package Zadania6;

public class Transaction implements Comparable<Transaction>{
    private String user;
    private Double payment;
    private String category;

    public Transaction(String user, Double payment, String category) {
        this.user = user;
        this.payment = payment;
        this.category = category;
    }

    public String getUser() {
        return user;
    }

    public Double getPayment() {
        return payment;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public int compareTo(Transaction o) {
        return Double.compare(this.payment, o.payment);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "user='" + user + '\'' +
                ", payment=" + payment +
                ", category='" + category + '\'' +
                '}';
    }
}
