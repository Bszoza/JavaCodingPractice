package Zadania5;

import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private String user;
    private Double amount;
    private String Category;

    public Transaction(String user, Double amount, String category) {
        this.user = user;
        this.amount = amount;
        Category = category;
    }

    public String getUser() {
        return user;
    }

    public Double getAmount() {
        return amount;
    }

    public String getCategory() {
        return Category;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "user='" + user + '\'' +
                ", amount=" + amount +
                ", Category='" + Category + '\'' +
                '}';
    }
}
