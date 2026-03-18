package org.exemplo;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ContaTest {

    static int saldo = 0;

    @Test
    @Order(1)
    void depositar() {
        saldo += 100;
        System.out.println("Saldo após depósito: " + saldo);
    }

    @Test
    @Order(2)
    void sacar() {
        saldo -= 150;
        System.out.println("Saldo após saque: " + saldo);
    }

}