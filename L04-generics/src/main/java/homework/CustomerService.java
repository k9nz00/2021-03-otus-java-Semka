package homework;


import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class CustomerService {

    private final SortedMap<Customer, String> customersSortedMap = new TreeMap<>();

    public Map.Entry<Customer, String> getSmallest() {
        //Возможно, чтобы реализовать этот метод, потребуется посмотреть как Map.Entry сделан в jdk
        Set<Map.Entry<Customer, String>> entries = this.customersSortedMap.entrySet(); //не доделано


        return null; // это "заглушка, чтобы скомилировать"
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        return null; // это "заглушка, чтобы скомилировать"
        //не доделано
    }

    public void add(Customer customer, String data) {
        customersSortedMap.put(customer, data);
    }
}
