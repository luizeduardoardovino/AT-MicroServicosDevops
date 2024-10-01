package com.meuprojeto.webflux_h2_reactive.service;



import com.meuprojeto.webflux_h2_reactive.model.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
@Testcontainers
public class ClienteServiceTest {

    @Autowired
    private ClienteService clienteService;

    @Test
    public void testGetUsuarios() {
        Flux<Usuario> usuarios = clienteService.getUsuarios();

        StepVerifier.create(usuarios)
            .expectNextCount(10)  // JSONPlaceholder retorna 10 usuários
            .verifyComplete();
    }
}
