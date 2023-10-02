package com.example.appbanco.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.appbanco.domain.users.Users;
import com.example.appbanco.domain.users.UsersDTO;
import com.example.appbanco.service.UserService;

@RestController()
@RequestMapping("/Users")
public class UserController {


    @Autowired
    private UserService service ;

    @PostMapping
    public ResponseEntity<Users> createUser(@RequestBody UsersDTO user){

        Users newuser = user.createUser(user);
        return new ResponseEntity<>(newuser , HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers(){

        List<Users> users = this.service.getAllUsers();
        return new ResponseEntity<>(users , HttpStatus.OK);
    }
}
