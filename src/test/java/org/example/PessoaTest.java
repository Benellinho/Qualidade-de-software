package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import User.Pessoa;

class PessoaTest {
	
	Pessoa obj1 = new Pessoa("Ana", 20);

	@Test
	void testGetIdade() {
		assertEquals(20, obj1.getIdade());		
	}

	@Test
	void testGetNome() {
		assertEquals("Ana", obj1.getNome());	
	}

}
