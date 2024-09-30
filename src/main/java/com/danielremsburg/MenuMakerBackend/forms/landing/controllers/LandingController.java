package com.danielremsburg.MenuMakerBackend.forms.landing.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LandingController {
    @GetMapping("/")
    String hello() {
      String name = "World";
      return "Hello " + name + "!";
    }
    
}
