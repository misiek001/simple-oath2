package com.mbor.web.controller;

import com.mbor.domain.Post;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class SimpleController {

    @GetMapping
    public ResponseEntity<Post> helloWorld(){
        return new ResponseEntity<>(new Post(), HttpStatus.OK);
    }

}
