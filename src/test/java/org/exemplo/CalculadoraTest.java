package org.exemplo;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(OrderAnnotation.class)
class CalculadoraTest {

    Calculadora calc = new Calculadora();

    @Test
    @Order(1)
    @Tag("development")
    void testSoma() {
        assertEquals(4, calc.somar(2, 2));
    }

    @Test
    @Order(2)
    @Tag("database")
    void testOutroExemplo() {
        assertEquals(10, calc.somar(5, 5));
    }
}
