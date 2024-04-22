package io.sicredi.domain.produto;

import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProdutoService {

  public Mono<Produto> buscar(String idProduto) {

    return Mono.just(idProduto)
        .doOnNext(estoque -> log.info("Buscando Produto: {}", idProduto))
        .map(id ->
            Produto.builder().valor(BigDecimal.valueOf(100)).build()
        );
  }

  public Mono<Void> solicitarReposicao(String idProduto) {

    return Mono.just(idProduto)
        .doOnNext(id -> log.info("Solicitando Reposição do produto: {}", id))
        .then();
  }

}
