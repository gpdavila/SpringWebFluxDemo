package io.sicredi.error;

import static lombok.AccessLevel.PRIVATE;

import lombok.NoArgsConstructor;
import org.springframework.web.reactive.function.client.ClientResponse;
import reactor.core.publisher.Mono;

@NoArgsConstructor(access = PRIVATE)
public class ExceptionWrapper {

  private static final String ERRO_CHAMAR_SERVICO = "Erro ao chamar o serviço: ";

  public static Mono<TechnicalException> toTechnicalException(ClientResponse response) {
    return response
        .createException()
        .map(excecao -> new TechnicalException(ERRO_CHAMAR_SERVICO + excecao));
  }

  public static Mono<BusinessException> toBusinessException(ClientResponse response) {

    return response
        .createException()
        .map(excecao -> new BusinessException(ERRO_CHAMAR_SERVICO + excecao));
  }

}
