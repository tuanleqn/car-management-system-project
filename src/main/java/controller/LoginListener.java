package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.LoginView;

public class LoginListener implements ActionListener {
	private LoginView loginView;

	public LoginListener(LoginView loginView) {
		this.setLoginView(loginView);
	}

	public LoginView getLoginView() {
		return loginView;
	}

	public void setLoginView(LoginView loginView) {
		this.loginView = loginView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();

		if (str.equals("Login")) {
			this.loginView.verify();
		} else if (str.equals("Reset")) {
			this.loginView.clearForm();
		}

	}

}
