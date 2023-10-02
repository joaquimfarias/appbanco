package com.example.appbanco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.appbanco.domain.transaction.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction , Long> {
    
}
