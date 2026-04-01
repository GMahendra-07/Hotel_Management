package com.example.demo.controller;

import com.example.demo.entity.Customer_details;
import com.example.demo.service.Customer_detailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class Customer_detailsController {

    @Autowired
    private Customer_detailsService customerService;

    // Demonstration of GET mapping
    @GetMapping("/welcome")
    public String welcome() {
        return "Customer Controller is working";
    }

    // Create customer
    @PostMapping("/create")
    public Customer_details createCustomer(@RequestBody Customer_details customer) {
        return customerService.saveCustomer(customer);
    }

    @GetMapping("/{id}")
    public Customer_details getCustomerById(@PathVariable Integer id) {
        return customerService.getCustomerById(id);
    }

    // Get all customers
    @GetMapping("/all")
    public List<Customer_details> getAllCustomers() {
        return customerService.getAllCustomers();
    }


    // Update customer
    @PutMapping("/update/{id}")
    public Customer_details updateCustomer(
            @PathVariable Integer id,
            @RequestBody Customer_details customer) {
        return customerService.updateCustomer(id, customer);
    }

    // Delete customer
    @DeleteMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
        return "Customer deleted successfully with id " + id;
    }
}

