package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "payment")
public class Payment {

    @Entity
    @Table(name = "payment")
    public class payment {

        @Id
        @Column(name = "invoice_no")
        private Integer invoiceNo;

        @Column(name = "payment_date")
        private LocalDate paymentDate;

        @Column(name = "payment_mode")
        private String paymentMode;

        private Long amount;

        @OneToOne
        @JoinColumn(
                name = "reservation_details_reservation_id",
                unique = true,
                nullable = false
        )
        private Reservation_details reservation;

        public Integer getInvoiceNo() { return invoiceNo; }
        public void setInvoiceNo(Integer invoiceNo) { this.invoiceNo = invoiceNo; }

        public LocalDate getPaymentDate() { return paymentDate; }
        public void setPaymentDate(LocalDate paymentDate) { this.paymentDate = paymentDate; }

        public String getPaymentMode() { return paymentMode; }
        public void setPaymentMode(String paymentMode) { this.paymentMode = paymentMode; }

        public Long getAmount() { return amount; }
        public void setAmount(Long amount) { this.amount = amount; }

        public Reservation_details getReservation() {
            return reservation;
        }

        public void setReservation(Reservation_details reservation) {
            this.reservation = reservation;
        }
    }}

