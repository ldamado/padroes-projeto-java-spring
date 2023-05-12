package me.dio.padroesprojetospring.service.impl;

import me.dio.padroesprojetospring.model.Address;
import me.dio.padroesprojetospring.model.AddressRepository;
import me.dio.padroesprojetospring.model.Customer;
import me.dio.padroesprojetospring.model.CustomerRepository;
import me.dio.padroesprojetospring.service.CustomerService;
import me.dio.padroesprojetospring.service.ViaCep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ViaCep viaCep;

    @Override
    public Iterable<Customer> fetchAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer fetchById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.get();
    }

    @Override
    public void insert(Customer customer) {
        saveCustomerWithCep(customer);
    }

    @Override
    public void update(Long id, Customer customer) {
        Optional<Customer> customerBd = customerRepository.findById(id);
        if (customerBd.isPresent()) {
            saveCustomerWithCep(customer);
        }

    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);

    }

    private void saveCustomerWithCep(Customer customer) {
        String cep = customer.getAddress().getCep();
        Address address = addressRepository.findById(cep).orElseGet(() -> {
            Address newAddress = viaCep.checkCep(cep);
            addressRepository.save(newAddress);
            return newAddress;
        });
        customer.setAddress(address);
        customerRepository.save(customer);
    }
}
