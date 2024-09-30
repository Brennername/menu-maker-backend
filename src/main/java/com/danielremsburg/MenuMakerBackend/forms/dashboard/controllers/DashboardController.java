package com.danielremsburg.MenuMakerBackend.forms.dashboard.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {
    @GetMapping("/api/v1/landing/Dashboard")
    String hello() {
      return "";
    }
}