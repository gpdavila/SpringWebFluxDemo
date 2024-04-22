package io.sicredi.domain.pagamento;

import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class PagamentosService {

  public Mono<Pagamento> gerar(BigDecimal valor) {

    return Mono.just(Pagamento
        .builder()
        .valor(valor)
        .codigoPix("00020126360014BR.GOV.BCB.PIX0114+55545451982545204000053039865802BR5903sad6003asd62070503***630497B7")
        .processado(Boolean.FALSE)
        .build());
  }

  public Mono<Void> estornar(String idPedido) {
    return Mono.empty();
  }

}
