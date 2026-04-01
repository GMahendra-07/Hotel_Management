package com.example.demo.controller;

import com.example.demo.entity.Reservation_details;
import com.example.demo.service.Reservation_detailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class Reservation_detailsController {

    @Autowired
    private Reservation_detailsService reservationService;

    // Test API
    @GetMapping("/welcome")
    public String welcome() {
        return "Reservation Controller is working";
    }

    // CREATE reservation
    @PostMapping("/create")
    public Reservation_details createReservation(
            @RequestBody Reservation_details reservation) {
        return reservationService.saveReservation(reservation);
    }

    // GET ALL
    @GetMapping("/all")
    public List<Reservation_details> getAllReservations() {
        return reservationService.getAllReservations();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Reservation_details getReservationById(@PathVariable Integer id) {
        return reservationService.getReservationById(id);
    }

    // UPDATE
    @PutMapping("/update/{id}")
    public Reservation_details updateReservation(
            @PathVariable Integer id,
            @RequestBody Reservation_details reservation) {
        return reservationService.updateReservation(id, reservation);
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public String deleteReservation(@PathVariable Integer id) {
        reservationService.deleteReservation(id);
        return "Reservation deleted successfully with id " + id;
    }
}
