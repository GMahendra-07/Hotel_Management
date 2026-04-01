package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "reservation_details")
public class Reservation_details {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Integer reservationId;

    @Column(length = 12, nullable = false)
    private String status;

    @Column(name = "check_in_date")
    private LocalDate checkInDate;

    @Column(name = "check_out_date")
    private LocalDate checkOutDate;

    @Column(name = "no_of_guests")
    private Integer noOfGuests;

    @Column(name = "reservation_date")
    private LocalDate reservationDate;

    @Column(name = "no_of_rooms")
    private Integer noOfRooms;

    @ManyToOne
    @JoinColumn(name = "customerdetails_customer_id")
    private Customer_details customer;

    @ManyToOne
    @JoinColumn(name = "roomtype_id")
    private Room_type roomType;

    @OneToOne(mappedBy = "reservation", cascade = CascadeType.ALL)
    private Payment payment;

    // ===== GETTERS & SETTERS =====

    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public Integer getNoOfGuests() {
        return noOfGuests;
    }

    public void setNoOfGuests(Integer noOfGuests) {
        this.noOfGuests = noOfGuests;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Integer getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(Integer noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    // 🔥 THESE FIX YOUR ERROR
    public Customer_details getCustomer() {
        return customer;
    }

    public void setCustomer(Customer_details customer) {
        this.customer = customer;
    }

    public Room_type getRoomType() {
        return roomType;
    }

    public void setRoomType(Room_type roomType) {
        this.roomType = roomType;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}