package io.sicredi.client.estoque;

import io.sicredi.domain.estoque.Estoque;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class EstoqueClient {

  private final WebClient client;

  EstoqueClient(@Value("${endpoint.estoque}") String baseUrl) {

    this.client = WebClient.create(baseUrl);
  }

  public Mono<Estoque> buscarEstoque(String idProduto) {

    return client
        .get()
        .uri("/estoque/" + idProduto)
        .retrieve()
//        .onStatus(HttpStatusCode::is4xxClientError,
//            ExceptionWrapper::toBusinessException)
//        .onStatus(HttpStatusCode::is5xxServerError,
//            ExceptionWrapper::toTechnicalException)
        .bodyToMono(Estoque.class);
  }
}
