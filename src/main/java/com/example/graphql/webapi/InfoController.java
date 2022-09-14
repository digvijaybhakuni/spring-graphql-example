package com.example.graphql.webapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class InfoController {

    @GetMapping("/api/info")
    public Map<String, String> info() {
        return Map.of("info", "UP");
    }
}
