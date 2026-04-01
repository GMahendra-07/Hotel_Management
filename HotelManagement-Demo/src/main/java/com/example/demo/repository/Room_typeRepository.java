package com.example.demo.repository;

import com.example.demo.entity.Room_type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Room_typeRepository extends JpaRepository<Room_type, Integer> {

    // Find room by room type name
    Room_type findByRoomType(String roomType);

    // Find rooms with charge less than a value
    // List<Room_type> findByRoomChargeLessThan(Integer charge);

    // Find rooms by number of people
    // List<Room_type> findByNumPeople(Integer numPeople);
}
