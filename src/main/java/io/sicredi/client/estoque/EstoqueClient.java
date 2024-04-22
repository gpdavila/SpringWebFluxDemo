package io.sicredi.client.estoque;

import io.sicredi.domain.estoque.Estoque;
import io.sicredi.error.ExceptionWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
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

  public Mono<Estoque> buscarEstoque(String idPedido) {

    return client
        .get()
        .uri("/v3/067ab719-5f04-4c3a-90a5-bb1996b3cda1")
        .retrieve()
        .onStatus(HttpStatusCode::is4xxClientError,
            ExceptionWrapper::toBusinessException)
        .onStatus(HttpStatusCode::is5xxServerError,
            ExceptionWrapper::toTechnicalException)
        .bodyToMono(Estoque.class);
  }
}
