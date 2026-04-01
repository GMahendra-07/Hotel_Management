package com.example.demo.service;

import com.example.demo.entity.Customer_details;
import com.example.demo.repository.Customer_detailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Customer_detailsService {

    @Autowired
    private Customer_detailsRepository customerRepository;

    // Create or Update Customer
    public Customer_details saveCustomer(Customer_details customer) {
        return customerRepository.save(customer);
    }

    public Customer_details getCustomerById(Integer id) {
        Optional<Customer_details> optional = customerRepository.findById(id);
        return optional.orElse(null);
    }

    // Get all customers
    public List<Customer_details> getAllCustomers() {
        return customerRepository.findAll();
    }




    // Update customer
    public Customer_details updateCustomer(Integer id, Customer_details customerDetails) {
        Customer_details customer = getCustomerById(id);

        if (customer != null) {
            customer.setFirstName(customerDetails.getFirstName());
            customer.setLastName(customerDetails.getLastName());
            customer.setDateOfBirth(customerDetails.getDateOfBirth());
            customer.setAddress1(customerDetails.getAddress1());
            customer.setAddress2(customerDetails.getAddress2());
            customer.setCity(customerDetails.getCity());
            customer.setPincode(customerDetails.getPincode());
            customer.setContactNumber(customerDetails.getContactNumber());


            return customerRepository.save(customer);
        }
        return null;
    }

    // Delete customer
    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }
}