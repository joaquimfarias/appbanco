package com.example.appbanco.domain.users;

import java.math.BigDecimal;

public record UsersDTO(String firstname , String lastname , String document , BigDecimal balance , String email , String password  , UserType UserType) {

    public Users createUser(UsersDTO user) {
        return null;
    }
    
}
