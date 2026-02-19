package com.careerit.dto;

public class AuthResponse {

	
	private String login;
	private String access_token;
	public AuthResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AuthResponse(String login, String access_token) {
		super();
		this.login = login;
		this.access_token = access_token;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	@Override
	public String toString() {
		return "AuthResponse [login=" + login + ", access_token=" + access_token + "]";
	}
	
	
	
}
