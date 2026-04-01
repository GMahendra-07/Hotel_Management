package com.example.demo.controller;

import com.example.demo.entity.Payment;
import com.example.demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    // Test API
    @GetMapping("/welcome")
    public String welcome() {
        return "Payment Controller is working";
    }

    // Create payment
    @PostMapping("/create")
    public Payment createPayment(@RequestBody Payment payment) {
        return paymentService.savePayment(payment);
    }

    // Get all payments
    @GetMapping("/all")
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    // Get payment by invoice number
    @GetMapping("/{invoiceNo}")
    public Payment getPaymentByInvoiceNo(@PathVariable Integer invoiceNo) {
        return paymentService.getPaymentByInvoiceNo(invoiceNo);
    }

    // Update payment
    @PutMapping("/update/{invoiceNo}")
    public Payment updatePayment(
            @PathVariable Integer invoiceNo,
            @RequestBody Payment payment) {
        return paymentService.updatePayment(invoiceNo, payment);
    }

    // Delete payment
    @DeleteMapping("/delete/{invoiceNo}")
    public String deletePayment(@PathVariable Integer invoiceNo) {
        paymentService.deletePayment(invoiceNo);
        return "Payment deleted successfully with invoice no " + invoiceNo;
    }
}
