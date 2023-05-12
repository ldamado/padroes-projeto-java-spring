package me.dio.padroesprojetospring.controller;


import me.dio.padroesprojetospring.model.Customer;
import me.dio.padroesprojetospring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<Iterable<Customer>> fetchAll() {
        return ResponseEntity.ok(customerService.fetchAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> fetchById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.fetchById(id));
    }

    @PostMapping
    public ResponseEntity<Customer> insert(@RequestBody Customer customer) {
        customerService.insert(customer);
        return ResponseEntity.ok(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> update(@PathVariable Long id, @RequestBody Customer customer) {
        customerService.update(id, customer);
        return ResponseEntity.ok(customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        customerService.delete(id);
        return ResponseEntity.ok().build();
    }

}
