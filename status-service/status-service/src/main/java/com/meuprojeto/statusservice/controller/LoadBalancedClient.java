package com.meuprojeto.statusservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class LoadBalancedClient {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/loadbalanced-status")
    public String getStatusViaLoadBalancer() {
        String url = "http://status-service/status";
        return restTemplate.getForObject(url, String.class);
    }
}
