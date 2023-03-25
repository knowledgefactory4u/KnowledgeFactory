package com.knf.dev.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MyController {

    @Value("${knf.secret1}")
    String secret1;

    @Value("${knf.secret2}")
    String secret2;

    @GetMapping("/secret")
    public Map<String,String> getSecret()
    {
        Map<String,String> map = new HashMap<>();
        map.put("Secret 1",secret1);
        map.put("Secret 2",secret2);

        return map;
    }
}
