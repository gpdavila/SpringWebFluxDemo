package io.sicredi.domain.estoque;

import io.sicredi.client.estoque.EstoqueClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class EstoqueService {

  private final EstoqueClient client;

  public Mono<Estoque> buscar(String idProduto) {

    return Mono.just(idProduto)
        .doOnNext(s -> log.info("Buscando Estoque do produto: {}", idProduto))
        .flatMap(client::buscarEstoque)
        .map(estoque ->
            Estoque.builder()
                .quantidade(estoque.getQuantidade())
                .build()
        );
  }

  public Mono<Void> atualizar(String idProduto) {
    return Mono.empty();
  }

}
