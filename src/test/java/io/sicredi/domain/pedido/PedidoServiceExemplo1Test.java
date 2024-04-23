package io.sicredi.domain.pedido;

import io.sicredi.domain.estoque.EstoqueService;
import io.sicredi.domain.pagamento.PagamentosService;
import io.sicredi.domain.produto.ProdutoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PedidoServiceExemplo1Test {

  @InjectMocks
  private PedidoServiceExemplo1 pedidoServiceExemplo1;

  @Mock
  private EstoqueService estoqueService;

  @Mock
  private ProdutoService produtoService;

  @Mock
  private PagamentosService pagamentosService;

  @Test
  @DisplayName("Deve criar o pedido quando o estoque retornar uma quantidade maior que zero")
  void deveCriarPedidoQuandoEstoqueRetornarMaiorQueZero() {

  }

  @Test
  @DisplayName("Não deve criar o pedido quando o estoque retornar uma quantidade menor ou igual a zero")
  void naoDeveCriarPedidoQuandoEstoqueRetornarValorMenorOuIgualAZero() {

  }

  @Test
  @DisplayName("")
  void teste() {

  }
}