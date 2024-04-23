package io.sicredi.domain.estoque;

import io.sicredi.client.estoque.EstoqueClient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EstoqueServiceTest {

  @InjectMocks
  private EstoqueService estoqueService;

  @Mock
  private EstoqueClient estoqueClient;

  @Test
  @DisplayName("Deve testar a consulta de estoque com sucesso")
  void deveTestarConsultaEstoqueComSucesso() {

  }
}