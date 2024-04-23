package io.sicredi.domain.pedido;

import lombok.experimental.UtilityClass;

@UtilityClass
public class PedidoFixture {

  public Pedido buildPedido() {

    return Pedido
        .builder()
        .id("Sicredi 1")
        .codigoPix("00020126360014BR.GOV.BCB.PIX0114+55545451982545204000053039865802BR5903sad6003asd62070503***630497B7")
        .build();
  }
}
