package com.payment.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.payment.repository.TransactionRepository;
import com.payment.repository.UserRepository;
import com.payment.entity.Transaction;
import com.payment.entity.User;
import com.payment.exception.TransactionNotFoundException;
import java.util.List;
import java.time.LocalDateTime;


@Service
public class PaymentService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;

    public Transaction initiatePayment(String email, Double amount, String upiId) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));

        Transaction txn = new Transaction();
        txn.setUser(user);
        txn.setUpiId(upiId);
        txn.setAmount(amount);
        txn.setStatus(Transaction.SUCCESS);
        txn.setTransactionTime(LocalDateTime.now());


        return transactionRepository.save(txn);
    }



    public Transaction markSuccess(Long transactionId) {
        Transaction txn = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new TransactionNotFoundException("Transaction not found"));

        txn.setStatus(Transaction.SUCCESS);
        return transactionRepository.save(txn);
    }

    public Transaction markFailed(Long transactionId) {

        Transaction txn = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new TransactionNotFoundException("Transaction not found"));

        txn.setStatus(Transaction.FAILED);
        return transactionRepository.save(txn);
    }

    public List<Transaction> getTransactionHistory(String email) {
        return transactionRepository.findByUserEmail(email);
    }


}
