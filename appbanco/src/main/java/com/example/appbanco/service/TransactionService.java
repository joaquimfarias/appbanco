package com.example.appbanco.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.appbanco.domain.transaction.Transaction;
import com.example.appbanco.domain.users.Users;
import com.example.appbanco.dtos.TransactionDTO;
import com.example.appbanco.repositories.TransactionRepository;

@Service
public class TransactionService {
    
    @Autowired
    private UserService userService;

    @Autowired
    private TransactionRepository repository; 

    @Autowired
    private RestTemplate restTemplate ;

    public Transaction createTransaction(TransactionDTO Transaction) throws Exception{

        Users sender = (Users) this.userService.findUserById(Transaction.sender());
        Users receiver = (Users) this.userService.findUserById(Transaction.receiver());


        userService.validateTransaction(sender, Transaction.amount());

        if(!autorizeTransaction(sender, Transaction.amount())){

            throw new Exception("transação não autorizada");
        }

        Transaction newtrans = new Transaction() ;
        newtrans.setAmount(Transaction.amount());
        newtrans.setReceiver(receiver);
        newtrans.setSender(sender);
        newtrans.setTime(LocalDateTime.now());


        sender.setBalance(sender.getBalance().subtract(Transaction.amount()));
        receiver.setBalance(receiver.getBalance().add(Transaction.amount()));

        this.repository.save(newtrans);
        this.userService.saveUser(receiver);
        this.userService.saveUser(sender);

        return newtrans ;
    }

    public boolean autorizeTransaction(Users sender , BigDecimal value){

        ResponseEntity<Map> response = restTemplate.getForEntity("https://run.mocky.io/v3/8fafdd68-a090-496f-8c9a-3442cf30dae6", Map.class);

        if(response.getStatusCode() == HttpStatus.OK){

            return true ;
        }
        return false;
    }


    
}
