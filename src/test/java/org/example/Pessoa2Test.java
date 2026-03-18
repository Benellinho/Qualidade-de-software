package org.example;

import User.Pessoa;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("A special test case")
class Pessoa2Test {

	@BeforeAll
	static void inicializa() {
		System.out.println("executando testes");
	}
	
	 

    @BeforeEach
    void init() {
    	//System.out.println("init");
	}
    

    @Test
    void succeedingTest() {
    }

    @Test
    void failingTest() {
        //fail("a failing test");
    }

    @Test
    @Disabled("for demonstration purposes")
    void skippedTest() {
        // not executed
    }

   

    @AfterEach
    void tearDown() {
    }

    @AfterAll
    static void tearDownAll() {
    }
    
    @Test
    @DisplayName("Custom test name containing spaces")
    void testWithDisplayNameContainingSpaces() {
    }

    @Test
    @DisplayName("bla")
    void testWithDisplayNameContainingSpecialCharacters() {
    }

    @Test
    @DisplayName("kkkkk")
    void testWithDisplayNameContainingEmoji() {
    }
    
    @Test
    @Tag("userManagement")
    void testCaseA( ) {
    }
    
   
    @Test
    @Tag("development")
    void testCaseC( ) {
    }

}
