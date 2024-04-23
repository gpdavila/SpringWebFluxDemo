package io.sicredi.domain.produto;

import java.math.BigDecimal;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ProdutoFixture {

  public Produto buildProduto() {

    return Produto
        .builder()
        .valor(BigDecimal.valueOf(100))
        .build();
  }
}
