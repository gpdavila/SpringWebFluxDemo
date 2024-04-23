package io.sicredi.domain.pagamento;

import static java.lang.Boolean.FALSE;

import java.math.BigDecimal;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PagamentoFixture {

  public Pagamento buildPagamento() {

    return Pagamento
        .builder()
        .valor(BigDecimal.valueOf(100))
        .processado(FALSE)
        .codigoPix("00020126360014BR.GOV.BCB.PIX0114+55545451982545204000053039865802BR5903sad6003asd62070503***630497B7")
        .build();
  }
}
