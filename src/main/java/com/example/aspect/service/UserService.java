package com.example.aspect.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserService {
    public ResponseEntity<?> getUserName(String name){
        log.info("in Service requested name: "+name);
        return ResponseEntity.status(HttpStatus.OK).body("Hey "+name);
    }
}
