

package com.meuprojeto.webflux_h2_reactive.controller;

import com.meuprojeto.webflux_h2_reactive.model.Usuario;
import com.meuprojeto.webflux_h2_reactive.service.ClienteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/usuarios")
    public Flux<Usuario> getUsuarios() {
        return clienteService.getUsuarios();
    }
}
