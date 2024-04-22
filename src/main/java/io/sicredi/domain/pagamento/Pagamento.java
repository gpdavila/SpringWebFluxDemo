package io.sicredi.domain.pagamento;

import static lombok.AccessLevel.PRIVATE;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor(access = PRIVATE)
public class Pagamento {

  String codigoPix;
  Boolean processado;
  BigDecimal valor;
}
