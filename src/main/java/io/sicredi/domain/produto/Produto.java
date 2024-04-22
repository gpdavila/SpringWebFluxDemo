package io.sicredi.domain.produto;

import static lombok.AccessLevel.PRIVATE;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor(access = PRIVATE)
public class Produto {

  BigDecimal valor;

}
