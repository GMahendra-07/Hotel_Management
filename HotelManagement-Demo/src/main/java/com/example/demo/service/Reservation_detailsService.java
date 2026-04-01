package com.example.demo.service;

import com.example.demo.entity.Customer_details;
import com.example.demo.entity.Reservation_details;
import com.example.demo.entity.RoomType;
import com.example.demo.repository.Customer_detailsRepository;
import com.example.demo.repository.Reservation_detailsRepository;
import com.example.demo.repository.Room_typeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Reservation_detailsService {

    @Autowired
    private Reservation_detailsRepository reservationRepository;

    @Autowired
    private Customer_detailsRepository customerRepository;

    @Autowired
    private Room_typeRepository roomTypeRepository;

    // CREATE reservation (IMPORTANT FIX)
    public Reservation_details saveReservation(Reservation_details reservation) {

        // Fetch customer
        Integer customerId = reservation.getCustomer().getCustomerId();
        Customer_details customer =
                customerRepository.findById(customerId).orElse(null);

        if (customer == null) {
            throw new RuntimeException("Customer not found with id " + customerId);
        }

        // Fetch room type
        Integer roomTypeId = reservation.getRoomType().getRoomTypeId();
        Room_type roomType =
                roomTypeRepository.findById(roomTypeId).orElse(null);

        if (roomType == null) {
            throw new RuntimeException("RoomType not found with id " + roomTypeId);
        }

        // Attach managed entities
        reservation.setCustomer(customer);
        reservation.setRoomType(roomType);

        return reservationRepository.save(reservation);
    }

    // GET ALL
    public List<Reservation_details> getAllReservations() {
        return reservationRepository.findAll();
    }

    // GET BY ID
    public Reservation_details getReservationById(Integer id) {
        Optional<Reservation_details> optional = reservationRepository.findById(id);
        return optional.orElse(null);
    }

    // UPDATE
    public Reservation_details updateReservation(Integer id, Reservation_details details) {

        Reservation_details reservation = getReservationById(id);

        if (reservation != null) {
            reservation.setStatus(details.getStatus());
            reservation.setCheckInDate(details.getCheckInDate());
            reservation.setCheckOutDate(details.getCheckOutDate());
            reservation.setNoOfGuests(details.getNoOfGuests());
            reservation.setNoOfRooms(details.getNoOfRooms());
            reservation.setReservationDate(details.getReservationDate());

            return reservationRepository.save(reservation);
        }
        return null;
    }

    // DELETE
    public void deleteReservation(Integer id) {
        reservationRepository.deleteById(id);
    }
}
