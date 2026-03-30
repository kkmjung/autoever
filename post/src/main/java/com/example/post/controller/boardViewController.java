package com.example.post.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class boardViewController {

    @GetMapping("/board")
    public String board(){
        return "board";
    };
}
