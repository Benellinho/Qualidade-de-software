package org.bancario;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ContaTest {

    @Test
    @DisplayName(" Deve somar o valor ao saldo ao realizar um deposito valido")
    void deveSomarAoSaldoAoDepositar() {
        Conta conta = new Conta("Lucas");
        conta.depositar(100);

        assertEquals(100, conta.getSaldo(), "O saldo deveria ser atualizado apos o deposito.");
    }

    @Test
    @DisplayName("Nao deve permitir deposito com valor negativo")
    void naoDevePermitirDepositoNegativo() {
        Conta conta = new Conta("Lucas");

        IllegalArgumentException erro = assertThrows(
                IllegalArgumentException.class,
                () -> conta.depositar(-100),
                "Depositos negativos deveriam gerar uma excecao.");

        assertEquals("Valor invalido", erro.getMessage(), "A mensagem da excecao deveria explicar o erro.");
    }

    @Test
    @DisplayName("Deve permitir saque com valor suficiente")
    void deveSubitrairDoSaldoAoSacar() {
        Conta conta = new Conta("Lucas");
        conta.depositar(1000);
        conta.sacar(900);
        assertEquals(100, conta.getSaldo(), "O saldo deveria ser atualizado apos o saque.");

    }

    @Test
    @DisplayName("Nao deve permitir saque sem saldo")
    void naoDevePermitirSaqueSemSaldo() {
        Conta conta = new Conta("Lucas");

        IllegalArgumentException erro = assertThrows(
                IllegalArgumentException.class,
                () -> conta.sacar(100),
                "Saques sem saldo deveriam gerar uma excecao.");

        assertEquals("Saldo insuficiente", erro.getMessage(), "A mensagem da excecao deveria explicar o erro.");
    }

    @Test
    @DisplayName("Nao deve permitir saque negativo")
    void naoDevePermitirSaqueNegativo() {
        Conta conta = new Conta("Lucas");

        IllegalArgumentException erro = assertThrows(
                IllegalArgumentException.class,
                () -> conta.sacar(-100),
                "Saques sem saldo deveriam gerar uma excecao.");

        assertEquals("Valor invalido", erro.getMessage(), "A mensagem da excecao deveria explicar o erro.");
    }
}
