package com.example.appbanco.dtos;

import java.math.BigDecimal;

public record TransactionDTO( BigDecimal amount , Long sender , Long receiver) {

}
