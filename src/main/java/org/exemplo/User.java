package org.exemplo;

public class User {
	private String id;
	private String name;
	private String email;
	
	public User(final String anId, final String aName, final String anEmail) {
		this.id=anId;
		this.name=aName;
		this.email=anEmail;
	}
	
	 

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void validate() {
		if(this.email.isEmpty()) {
			System.out.println("email nao pode ser em branco");
			throw new RuntimeException("email nao pode ser em branco");			
		}
	}
	

}
