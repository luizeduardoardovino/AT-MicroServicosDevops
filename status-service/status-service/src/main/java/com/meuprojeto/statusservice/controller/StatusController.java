package com.meuprojeto.statusservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {
	
	  @Value("${server.port}")
	    private String serverPort;

    @GetMapping("/status")
    public String getStatus() {
    	System.out.println("Requisição atendida pela instância na porta: " + serverPort);
        return "O serviço está ativo!";
    }
}
