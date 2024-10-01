package com.meuprojeto.webflux_h2_reactive.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("produto")
public class Produto {
    @Id
    private Long id;
    private String nome;
    private double preco;
}
