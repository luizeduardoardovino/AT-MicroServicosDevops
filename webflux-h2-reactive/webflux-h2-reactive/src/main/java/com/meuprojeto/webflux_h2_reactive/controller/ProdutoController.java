package com.meuprojeto.webflux_h2_reactive.controller;

import com.meuprojeto.webflux_h2_reactive.model.Produto;
import com.meuprojeto.webflux_h2_reactive.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

   
    @GetMapping
    public Flux<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }

 
    @PostMapping
    public Mono<Produto> addProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }
}

