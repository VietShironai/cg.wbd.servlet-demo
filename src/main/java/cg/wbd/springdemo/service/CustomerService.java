package cg.wbd.springdemo.service;

import cg.wbd.springdemo.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    private static List<Customer> customers;
    private static long increaseIdentity = 0;

    static {
        customers = new ArrayList<>();

        Customer foo = new Customer("Foo", "foo@hn.vn", "Hoan Kiem");
        generateId(foo);
        customers.add(foo);

        Customer bar = new Customer("Bar", "bar@sg.vn", "Thu Duc");
        generateId(bar);
        customers.add(bar);
    }

    static void generateId(Customer customer) {
        customer.setId(increaseIdentity++);
    }

    public List<Customer> findAll() {
        return customers;
    }

    public Customer find(long id) {
        return customers
                .stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void save(Customer customer) {
        if (customer.getId() == null) {
            generateId(customer);
            customers.add(customer);
        } else {
            Customer original = find(customer.getId());
            original.setName(customer.getName());
            original.setEmail(customer.getEmail());
            original.setAddress(customer.getAddress());
        }
    }

    public void remove(Customer customer) {
        customers.removeIf(c -> c.getId().equals(customer.getId()));
    }
}
