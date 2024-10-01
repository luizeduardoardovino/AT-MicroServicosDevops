package com.meuprojeto.webflux_h2_reactive.service;


import com.meuprojeto.webflux_h2_reactive.model.Usuario;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class ClienteService {

    private final WebClient webClient;

    public ClienteService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://jsonplaceholder.typicode.com").build();
    }

    
    public Flux<Usuario> getUsuarios() {
        return this.webClient.get()
            .uri("/users")
            .retrieve()
            .bodyToFlux(Usuario.class);
    }
}
