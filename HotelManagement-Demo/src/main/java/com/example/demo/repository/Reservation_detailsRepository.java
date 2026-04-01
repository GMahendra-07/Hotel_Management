
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Reservation_detailsRepository extends JpaRepository<Reservation_details, Integer> {

    List<Reservation_details> findByStatus(String status);
}

