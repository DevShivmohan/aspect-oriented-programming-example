package com.example.aspect.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class AspectController {

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public ResponseEntity<?> getData(){
        System.err.println("Controller executed");
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<1000;i++)
            if(i%2!=0)
                list.add(i);
        return new ResponseEntity(list, HttpStatus.OK);
    }
}
