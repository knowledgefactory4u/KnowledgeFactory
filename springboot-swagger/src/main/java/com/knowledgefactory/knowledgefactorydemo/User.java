package com.knowledgefactory.knowledgefactorydemo;

public class User {

	private String id;
	private String name;
	private String mail;

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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public User(String id, String name, String mail) {
		super();
		this.id = id;
		this.name = name;
		this.mail = mail;
	}

}
