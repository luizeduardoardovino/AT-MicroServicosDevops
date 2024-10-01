package com.meuprojeto.webflux_h2_reactive.repository;


import com.meuprojeto.webflux_h2_reactive.model.Produto;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends ReactiveCrudRepository<Produto, Long> {
}
