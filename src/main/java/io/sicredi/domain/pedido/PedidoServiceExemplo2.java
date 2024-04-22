package io.sicredi.domain.pedido;

import static java.lang.Boolean.TRUE;

import io.sicredi.domain.estoque.EstoqueService;
import io.sicredi.domain.pagamento.PagamentosService;
import io.sicredi.domain.produto.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class PedidoServiceExemplo2 {

  private final PagamentosService pagamentosService;
  private final EstoqueService estoqueService;
  private final ProdutoService produtoService;

  // Fazendo um if e else
  // Utilizando abordagem do filter + switchIfEmpty

  public Mono<Pedido> criar(String idProduto) {

    var buscarEstoque = estoqueService.buscar(idProduto);

    return buscarEstoque
        .map(estoque -> estoque.getQuantidade() > 0)
        .filter(estoqueDisponivel -> estoqueDisponivel.equals(TRUE))
        .flatMap(x -> this.criaPedido(idProduto))
        .switchIfEmpty(
            produtoService.solicitarReposicao(idProduto)
                .then(Mono.error(() -> new RuntimeException("Sem Estoque do Produto")))
        );
  }

  private Mono<Pedido> criaPedido(String idProduto) {

    return produtoService.buscar(idProduto)
        .flatMap(produto -> pagamentosService.gerar(produto.getValor()))
        .map(pagamento ->
          Pedido
              .builder()
              .id(Pedido.gerarId())
              .codigoPix(pagamento.getCodigoPix())
              .build()
        );
  }

}