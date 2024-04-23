package io.sicredi.domain.pedido;

import io.sicredi.domain.estoque.EstoqueService;
import io.sicredi.domain.pagamento.PagamentosService;
import io.sicredi.domain.produto.ProdutoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class PedidoServiceExemplo1 {

  private final EstoqueService estoqueService;
  private final ProdutoService produtoService;
  private final PagamentosService pagamentosService;

  /*
   Se  estoqueProduto > 0
        Cria Pedido
    Senão
        Dispara Exceção
  */

  // Fluxo condicional
  // Utilizando operador ternario - Exemplo 1
  public Mono<Pedido> criar(String idProduto) {

    return Mono.empty();
  }

  // Fluxo condicional
  // Utilizando operador ternario - Exemplo 1
  public Mono<Pedido> criar1(String idProduto) {

    var buscarEstoque = estoqueService.buscar(idProduto);

    return buscarEstoque
        .flatMap(estoque -> estoque.getQuantidade() > 0
            ? this.criaPedido(idProduto)
            : Mono.error(() -> new RuntimeException("Sem Estoque do Produto"))
        );
  }

  // Fluxo condicional
  // Utilizando operador ternario - Exemplo 2
  public Mono<Pedido> criar2(String idProduto) {

    var buscarEstoque = estoqueService.buscar(idProduto);

    return buscarEstoque
        .flatMap(estoque -> estoque.getQuantidade() > 0
            ? this.criaPedido(idProduto)
            : reposicao(idProduto)
        );
  }

  // Além de retornar uma exceção, queremos pedir reposição do produto
  // D: Tipo de retorno não alinhado com corpo do metodo.
  private Mono<Pedido> reposicao(String idProduto) {

    return produtoService.solicitarReposicao(idProduto)
        .then(Mono.error(() -> new RuntimeException("Sem Estoque do Produto")));

  }

  private Mono<Pedido> criaPedido(String idProduto) {

    return produtoService.buscar(idProduto)
        .flatMap(produto -> pagamentosService.gerar(produto.getValor()))
        .doOnNext(pagamento -> log.info("Codigo Pix gerado com sucesso: {}", pagamento.getCodigoPix()))
        .map(pagamento ->
            Pedido
                .builder()
                .id(Pedido.gerarId())
                .codigoPix(pagamento.getCodigoPix())
                .build()
        );
  }
}
