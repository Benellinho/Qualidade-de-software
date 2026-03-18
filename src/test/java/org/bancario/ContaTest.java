package org.bancario;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ContaTest {

    @Test
    @DisplayName("\n Deve somar o valor ao saldo ao realizar um deposito valido\n")
    void deveSomarAoSaldoAoDepositar() {
        Conta conta = new Conta("Lucas");
        conta.depositar(100);

        assertEquals(100, conta.getSaldo(), "\nO saldo deveria ser atualizado apos o deposito.\n");
    }

    @Test
    @DisplayName("\nNao deve permitir deposito com valor negativo\n")
    void naoDevePermitirDepositoNegativo() {
        Conta conta = new Conta("Lucas");

        IllegalArgumentException erro = assertThrows(
                IllegalArgumentException.class,
                () -> conta.depositar(-100),
                "\nDepositos negativos deveriam gerar uma excecao.\n"
        );

        assertEquals("\nValor invalido", erro.getMessage(), "A mensagem da excecao deveria explicar o erro.\n");
    }
}
