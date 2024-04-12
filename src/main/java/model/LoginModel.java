package model;

public class LoginModel {
	private String username;
	private String password;

	public LoginModel() {
		this.username = "admin"; // co the dinh db vao day
		this.password = "admin"; // co the dinh db vao day
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean verifyInfo(String userName, String password) {
		return ((this.username.equals(userName)) && (this.password.equals(password)));
	}

}
