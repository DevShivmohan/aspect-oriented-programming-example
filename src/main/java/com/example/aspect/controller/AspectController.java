package com.example.aspect.controller;

import com.example.aspect.annotation.CustomAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api")
public class AspectController {

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public ResponseEntity<?> getData(){
        log.info("Controller executed");
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<1000;i++)
            if(i%2!=0)
                list.add(i);
        if(list.size()>0);
//            throw new Exception("Authorization revoked");
//        return ResponseEntity.status(HttpStatus.MULTI_STATUS).body(new Exception("This is some technical problem"));
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(list);
//        return null;
//            return ResponseEntity.status(HttpStatus.ACCEPTED).body(list);
    }

    @CustomAnnotation
    @GetMapping(value = "/pet")
    public String custom(){
        log.info("Controller executed");
        return "Some message";
    }
}
