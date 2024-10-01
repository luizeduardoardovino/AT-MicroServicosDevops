package com.meuprojeto.webflux_h2_reactive.model;

import lombok.Data;

@Data
public class Usuario {
    private Long id;
    private String name;
    private String username;
    private String email;
}
