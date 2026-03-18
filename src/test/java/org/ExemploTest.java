package org;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;

class ExemploTest {

    @Test
    @Tag("development")
    void testeSoma() {
        System.out.println("Teste de soma");
    }

    @Test
    @Tag("database")
    void testeBanco() {
        System.out.println("Teste que usa banco");
    }

}