package com.example.appbanco.domain.transaction;


import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import com.example.appbanco.domain.users.Users;

import jakarta.persistence.*;
import lombok.* ;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Transaction {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;


    private BigDecimal amount ;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private Users sender ;
    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private Users receiver;
    private LocalDateTime time ;
}
