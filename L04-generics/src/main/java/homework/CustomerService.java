package homework;


import java.util.*;

public class CustomerService {

    private final TreeMap<Customer, String> treeMap = new TreeMap<>(Comparator.comparing(Customer::getScores));

    public Map.Entry<Customer, String> getSmallest() {
        return entryClone(treeMap.firstEntry());
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        return entryClone(treeMap.higherEntry(customer));
    }

    public void add(Customer customer, String data) {
        treeMap.put(customer, data);
    }

    private Map.Entry<Customer, String> entryClone(Map.Entry<Customer, String> original) {
        if (original == null) {
            return null;
        }

        Customer customer = original.getKey();
        Customer clone = new Customer(customer.getId(), customer.getName(), customer.getScores());
        return new AbstractMap.SimpleEntry<>(clone, original.getValue());
    }
}
