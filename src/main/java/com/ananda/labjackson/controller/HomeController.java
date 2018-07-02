package com.ananda.labjackson.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("home")
public class HomeController {

    @GetMapping("status")
    public Object getServiceStatus() {
        Map<String, Object> response = new HashMap<>();
        response.put("server_status", "ok");
        return response;
    }

    @GetMapping("status/{id}")
    public Object getServiceStatusByInstanceId(@PathVariable int id) {
        Map<String, Object> response = new HashMap<>();
        response.put("server_status", "ok");
        response.put("instance_id", "" + id);
        return response;
    }
}
