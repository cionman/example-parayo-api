package com.example.parayo.controller;

import com.example.parayo.common.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JavaController {
    @GetMapping("/api/v1/java")
    public ApiResponse java(){
        return ApiResponse.Companion.ok("java");
    }
}
