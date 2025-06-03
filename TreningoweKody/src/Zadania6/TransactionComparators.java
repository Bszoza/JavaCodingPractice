package Zadania6;

import java.util.Comparator;

public class TransactionComparators {

    public static class nameComparator implements Comparator<Transaction> {
        @Override
        public int compare(Transaction o1, Transaction o2) {
            return o1.getUser().compareTo(o2.getUser());
        }
    }
}
