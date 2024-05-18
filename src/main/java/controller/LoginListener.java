package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import test.Init;
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
			while (true) {
				try {
					if (this.loginView.isComfirmed()) {
						this.loginView.setComfirm(false);
						this.loginView.setVisible(false);
						this.loginView.clearForm();
						// goi carview cho nay
						Init.carManagementView.setVisible(true);
						break;
					} else {
						break;
					}
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		} else if (str.equals("Reset")) {
			this.loginView.clearForm();
		}

	}

}
