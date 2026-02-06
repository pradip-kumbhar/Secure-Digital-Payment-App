package com.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.payment.entity.Transaction;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByUserEmail(String email);
}
