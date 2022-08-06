package com.example.learn.dockerjenkins;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping
public class TestClass {

    @GetMapping("/")
    public String getStringValues(){
        return "hello";
    }
}
