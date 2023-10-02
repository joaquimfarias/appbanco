package com.example.appbanco.domain.users;

import java.math.*;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")

public class Users {


    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    private String firstname ;
    private String lastname ;

    @Column(unique = true)
    private String document;

    @Column(unique = true)
    private String email ;
    

    private String password ;

    private BigDecimal balance ;

    @Enumerated(EnumType.STRING)
    private UserType UserType ;


    public Users(UsersDTO user){

        this.firstname = user.firstname();
        this.lastname = user.lastname();
        this.document = user.document();
        this.balance = user.balance() ;
        this.email = user.email();
        this.password = user.password();
        this.UserType= user.UserType() ;

    }
}
