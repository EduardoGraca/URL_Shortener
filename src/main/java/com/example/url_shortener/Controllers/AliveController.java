package com.example.url_shortener.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AliveController {

    @GetMapping("/alive")
    public String alive () {
        return "I am alive!";
    }

}
