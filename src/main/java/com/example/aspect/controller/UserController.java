package com.example.aspect.controller;

import com.example.aspect.exception.UserNotFoundException;
import com.example.aspect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/login/{id}")
    public ResponseEntity<?> login(@PathVariable("id") int id){
        if(id==200)
            return ResponseEntity.status(HttpStatus.OK).body("Welcome accepted user");
        else
            throw new UserNotFoundException("User not found by Id "+id);
    }

    @GetMapping(value = "/loginw/{name}")
    public ResponseEntity<?> login(@PathVariable("name") String name){
        if(userService.getUserName(name)!=null)
            return ResponseEntity.status(HttpStatus.OK).body("Welcome accepted user");
        else
            throw new UserNotFoundException("User not found by Id "+name);
    }
}
