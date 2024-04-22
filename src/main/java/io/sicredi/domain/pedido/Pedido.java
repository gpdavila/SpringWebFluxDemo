package io.sicredi.domain.pedido;

import static lombok.AccessLevel.PRIVATE;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor(access = PRIVATE)
public class Pedido {

  private static int base = 0;

  String id;
  String codigoPix;

  public static String gerarId(){

    base = base + 1;
    return "Sicredi " + base;
  }

}
