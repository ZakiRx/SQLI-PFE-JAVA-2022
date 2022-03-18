package org.sqli.authentification.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.sqli.authentification.dao.UserRepository;
import org.sqli.authentification.dto.request.UserDto;
import org.sqli.authentification.entitie.User;
import org.sqli.authentification.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("auth")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity<User> authentication(@RequestBody UserDto user){
       User userauth=userService.findUserByUsernameAndPassword(user.getLogin(),user.getPassword()).get();
        return  new ResponseEntity<>(userauth, HttpStatus.ACCEPTED);
    }


}
