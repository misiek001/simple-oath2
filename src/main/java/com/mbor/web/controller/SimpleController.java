package com.mbor.web.controller;

import com.mbor.service.DataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class SimpleController {

    private final DataLoader dataLoader;

    @Autowired
    public SimpleController(DataLoader dataLoader) {
        this.dataLoader = dataLoader;
    }

    @GetMapping
    public String helloWorld(){
        return "Hello World";
    }

}
