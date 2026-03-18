package org.bancario;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BancoTest {

    @Test
    @DisplayName("Deve abrir uma conta e registrar o cliente no banco")
    void deveAbrirContaERegistrarCliente() {
        Banco banco = new Banco();

        Conta conta = banco.abrirConta("Lucas");

        assertNotNull(conta, "A conta criada nao deveria ser nula.");
        assertEquals("Lucas", conta.getNome(), "O nome do titular deveria ser armazenado na conta.");
        assertEquals(1, banco.getTotalContas(), "O banco deveria registrar exatamente uma conta apos a abertura.");
    }

    @Test
    @DisplayName("Deve transferir um valor da conta de origem para a conta de destino")
    void deveTransferirValorEntreContas() {
        Banco banco = new Banco();
        Conta origem = banco.abrirConta("Lucas");
        Conta destino = banco.abrirConta("Maria");
        origem.depositar(200);

        banco.transferir(origem.getId(), destino.getId(), 50);

        assertEquals(150, origem.getSaldo(), "O saldo da origem deveria ser reduzido pelo valor transferido.");
        assertEquals(50, destino.getSaldo(), "O saldo do destino deveria aumentar com o valor transferido.");
    }

    @Test
    @DisplayName("Nao deve permitir transferencia a partir de uma conta de origem inexistente")
    void naoDevePermitirTransferenciaDeContaInexistente() {
        Banco banco = new Banco();
        Conta destino = banco.abrirConta("Maria");

        IllegalArgumentException erro = assertThrows(
                IllegalArgumentException.class,
                () -> banco.transferir(999, destino.getId(), 50),
                "Transferencias com conta de origem inexistente deveriam falhar."
        );

        assertEquals(
                "Conta de origem Inexistente",
                erro.getMessage(),
                "A mensagem da excecao deveria indicar que a conta de origem nao foi encontrada."
        );
    }
}
