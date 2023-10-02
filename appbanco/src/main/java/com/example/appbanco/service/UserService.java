package com.example.appbanco.service;

import java.math.BigDecimal;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.appbanco.domain.users.UserType;
import com.example.appbanco.domain.users.Users;
import com.example.appbanco.domain.users.UsersDTO;
import com.example.appbanco.repositories.UserRepository;






@Service 
public class UserService {

    @Autowired
    private UserRepository repository ;


    public void validateTransaction (Users user , BigDecimal amount) throws Exception{
        if(user.getUserType() == UserType.merchant){

            throw new Exception("usuario não autorizado");
        }
        
        if(user.getBalance().compareTo(amount)< 0){

            throw new Exception("Saldo Insuficiente");
        }
    }

    public User findUserById(Long id ) throws Exception{

        return this.repository.findUserById(id).orElseThrow(() -> new Exception("usuario não encontrado"));
    }

    public void saveUser(Users user){

        this.repository.save(user);
    }

    public Users createUser(UsersDTO data){
        Users newuser = new Users(data);
        this.saveUser(newuser);
        return newuser ;
    }

    public List<Users> getAllUsers(){

    return this.repository.findAll();
    }
}
