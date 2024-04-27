package com.crud.ApiCrud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/health")
public class HealthCheckController {
    @GetMapping("/status")
    public String welcome() {
        return "return Up and Running";
    }
}
