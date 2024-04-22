package io.sicredi.controller;

import static org.springframework.http.HttpStatus.OK;

import io.sicredi.domain.pedido.Pedido;
import io.sicredi.domain.pedido.PedidoServiceExemplo1;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/pedidos")
@RequiredArgsConstructor
class PedidoController {

  private final PedidoServiceExemplo1 pedidoServiceExemplo;

  @ResponseStatus(OK)
  @PostMapping("/{idProduto}")
  Mono<Pedido> criar(@PathVariable String idProduto) {

    return Mono.just(idProduto)
        .flatMap(pedidoServiceExemplo::criar);
  }

}
