package me.dio.padroesprojetospring.service;

import me.dio.padroesprojetospring.model.Customer;

public interface CustomerService {

    Iterable<Customer> fetchAll();

    Customer fetchById(Long id);

    void insert(Customer customer);
    void update(Long id, Customer customer);
    void delete(Long id);
}
