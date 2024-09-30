package com.danielremsburg.MenuMakerBackend.forms.LandingPage.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LandingPageController {
    @GetMapping("/")
    String hello() {
      String name = "World";
      return "Hello " + name + "!";
    }
    
}
