package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import User.User;

public class UserTest {
	
	//given
	//when
	//then
	@Test
	public void userTest(){
		final String expectedID = "id";
		final String expectedName = "username";
	    final String expectedEmail = "bla@gmail.com";
	    
	    User usuario = new User(expectedID,expectedName,expectedEmail);
	    Assertions.assertEquals("id", usuario.getId());
	    Assertions.assertEquals(expectedName, usuario.getName());
	    Assertions.assertEquals(expectedEmail, usuario.getEmail());
	}
	
	
	
	
	
	@Disabled
	@Test
	public void userTest2(){
		final String expectedID = "id";
		final String expectedName = "username";
	    final String expectedEmail="";	    
	    
	    Assertions.assertThrows(RuntimeException.class,()->new User(expectedID,expectedName,expectedEmail));
	     
	}
	

}
