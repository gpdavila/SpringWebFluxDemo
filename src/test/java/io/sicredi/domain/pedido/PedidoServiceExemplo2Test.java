package io.sicredi.domain.pedido;

import static org.mockito.Mockito.doReturn;
import static reactor.core.publisher.Mono.just;

import io.sicredi.domain.estoque.EstoqueFixture;
import io.sicredi.domain.estoque.EstoqueService;
import io.sicredi.domain.pagamento.PagamentoFixture;
import io.sicredi.domain.pagamento.PagamentosService;
import io.sicredi.domain.produto.ProdutoFixture;
import io.sicredi.domain.produto.ProdutoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
class PedidoServiceExemplo2Test {

  @InjectMocks
  private PedidoServiceExemplo2 pedidoServiceExemplo2;

  @Mock
  private EstoqueService estoqueService;

  @Mock
  private ProdutoService produtoService;

  @Mock
  private PagamentosService pagamentosService;

  @Test
  @DisplayName("Deve criar um pedido com sucesso")
  void deveCriarPedidoSucesso() {

    var idProduto = "123";
    var quantidade = 50;
    var estoque = EstoqueFixture.buildEstoque(quantidade);
    var produto = ProdutoFixture.buildProduto();
    var pagamento = PagamentoFixture.buildPagamento();
    var pedido = PedidoFixture.buildPedido();

    doReturn(just(estoque))
        .when(estoqueService)
        .buscar(idProduto);

    doReturn(just(produto))
        .when(produtoService)
        .buscar(idProduto);

    doReturn(just(pagamento))
        .when(pagamentosService)
        .gerar(produto.getValor());

    StepVerifier.create(pedidoServiceExemplo2.criar(idProduto))
        .expectNext(pedido)
        .verifyComplete();

  }
}