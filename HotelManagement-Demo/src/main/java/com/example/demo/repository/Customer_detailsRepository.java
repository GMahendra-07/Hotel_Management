package com.example.demo.repository;

import com.example.demo.entity.Customer_details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Customer_detailsRepository extends JpaRepository<Customer_details, Integer> {
}

