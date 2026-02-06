package com.payment.controller;

import com.payment.dto.PaymentRequestDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.payment.service.PaymentService;
import com.payment.entity.Transaction;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/initiate")
    public ResponseEntity<Transaction> initiatePayment(
            @RequestBody PaymentRequestDto dto,
            org.springframework.security.core.Authentication authentication) {

        String email = authentication.getName(); // ✅ from JWT
        System.out.println("JWT EMAIL = " + email);

        Transaction txn = paymentService.initiatePayment(
                email,
                dto.getAmount(),
                dto.getUpiId()
        );

        return ResponseEntity.ok(txn);
    }


    @PutMapping("/success/{id}")
    public Transaction markPaymentSuccess(@PathVariable Long id) {
        return paymentService.markSuccess(id);
    }

    @PutMapping("/failed/{id}")
    public Transaction markPaymentFailed(@PathVariable Long id) {
        return paymentService.markFailed(id);
    }

    @GetMapping("/history")
    public ResponseEntity<List<Transaction>> getHistory(
            org.springframework.security.core.Authentication authentication) {

        String email = authentication.getName();

        List<Transaction> list = paymentService.getTransactionHistory(email);
        return ResponseEntity.ok(list);
    }


}
