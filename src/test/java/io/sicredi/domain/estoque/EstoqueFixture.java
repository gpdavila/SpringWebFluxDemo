package io.sicredi.domain.estoque;

import lombok.experimental.UtilityClass;

@UtilityClass
public class EstoqueFixture {

  public Estoque buildEstoque(Integer quantidade) {

      return Estoque
          .builder()
          .quantidade(quantidade)
          .build();
  }
}
