package com.example.dockerjenkinsdeneme;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controller {


    @GetMapping
    public String deneme2(){
        return "Furkan Göksuaaaaaa";
    }


}