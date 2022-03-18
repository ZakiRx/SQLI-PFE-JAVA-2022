package org.sqli.authentification.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.sqli.authentification.dto.request.UserDto;
import org.sqli.authentification.dto.response.ResponseMessage;
import org.sqli.authentification.dto.response.UserResDto;
import org.sqli.authentification.entitie.Group;
import org.sqli.authentification.entitie.User;
import org.sqli.authentification.exception.AuthenticationException;
import org.sqli.authentification.service.UserService;

@RestController
@RequestMapping("")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/auth")
    public ResponseEntity<UserResDto> authentication(@RequestBody UserDto user){
       User userauth=userService.findUserByUsernameAndPassword(user.getLogin(),user.getPassword());
       UserResDto userDto=new UserResDto(userauth);
        return  new ResponseEntity<>(userDto, HttpStatus.ACCEPTED);
    }
    @PostMapping("user")
    public ResponseEntity<UserResDto> createAccount(@RequestBody UserDto user){

        Group group = new Group(user.getGroup());
        User newUser=new User(user.getLogin(),user.getPassword(),group);

        User userCreated =userService.createUserAccount(newUser);
        UserResDto userDto=new UserResDto(userCreated);
        return  new ResponseEntity<>(userDto, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/user/{login}")
    public ResponseMessage deleteAccount(@PathVariable("login") String login){

            userService.deleteAccount(login);
            System.out.println("oooooook");
            return new ResponseMessage("account deleted",HttpStatus.ACCEPTED);

    }


}
