package com.example.appbanco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.appbanco.domain.transaction.Transaction;
import com.example.appbanco.dtos.TransactionDTO;
import com.example.appbanco.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService service ;


    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDTO trans) throws Exception{

        Transaction newtrans = service.createTransaction(trans);


        return new ResponseEntity<>(newtrans , HttpStatus.OK);
    }
    
}
