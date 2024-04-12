package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginListener;
import model.LoginModel;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;

public class LoginView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldUserName;
	private JTextField textFieldPassword;
	private JButton btnLogin;
	private JButton btnReset;
	private LoginModel loginModel;
	private boolean comfirmLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public LoginView() {
		this.setLoginModel(new LoginModel());

		setIconImage(
				Toolkit.getDefaultToolkit().getImage(LoginView.class.getResource("/view/01_logobachkhoasang.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(718, 443);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		LoginListener loginListener = new LoginListener(this);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(3, 43, 145));
		panel.setBounds(0, 0, 278, 406);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("With You");
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2.setBounds(96, 121, 86, 26);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("On");
		lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2_1.setBounds(124, 169, 30, 26);
		panel.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel("Every Journey");
		lblNewLabel_2_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_2.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2_2.setBounds(64, 217, 149, 26);
		panel.add(lblNewLabel_2_2);

		JLabel lblNewLabel = new JLabel("Car Management Software");
		lblNewLabel.setForeground(new Color(3, 43, 145));
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 24));
		lblNewLabel.setBounds(341, 27, 330, 31);
		contentPane.add(lblNewLabel);

		JLabel lblUserName = new JLabel("UserName");
		lblUserName.setForeground(new Color(3, 43, 145));
		lblUserName.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblUserName.setBounds(295, 187, 101, 26);
		contentPane.add(lblUserName);

		JLabel lblNewLabel_1 = new JLabel(
				new ImageIcon(LoginView.class.getResource("/view/Graphicloads-Transport-Car-5.64.png")));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(474, 76, 64, 64);
		contentPane.add(lblNewLabel_1);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(3, 43, 145));
		lblPassword.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblPassword.setBounds(295, 257, 101, 26);
		contentPane.add(lblPassword);

		textFieldUserName = new JTextField();
		textFieldUserName.setBounds(421, 184, 239, 34);
		textFieldUserName.setColumns(10);
		contentPane.add(textFieldUserName);

		textFieldPassword = new JTextField();
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(421, 249, 239, 34);
		contentPane.add(textFieldPassword);

		btnLogin = new JButton("Login");
		btnLogin.setForeground(new Color(3, 43, 145));
		btnLogin.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		btnLogin.setBounds(480, 325, 110, 28);
		btnLogin.addActionListener(loginListener);
		contentPane.add(btnLogin);

		btnReset = new JButton("Reset");
		btnReset.setForeground(new Color(3, 43, 145));
		btnReset.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		btnReset.setBounds(480, 373, 110, 28);
		btnReset.addActionListener(loginListener);
		contentPane.add(btnReset);
	}

	public JTextField getTextFieldUserName() {
		return textFieldUserName;
	}

	public void setTextFieldUserName(JTextField textFieldUserName) {
		this.textFieldUserName = textFieldUserName;
	}

	public JTextField getTextFieldPassword() {
		return textFieldPassword;
	}

	public void setTextFieldPassword(JTextField textFieldPassword) {
		this.textFieldPassword = textFieldPassword;
	}

	public JButton getBtnLogin() {
		return btnLogin;
	}

	public void setBtnLogin(JButton btnLogin) {
		this.btnLogin = btnLogin;
	}

	public JButton getBtnReset() {
		return btnReset;
	}

	public void setBtnReset(JButton btnReset) {
		this.btnReset = btnReset;
	}

	public LoginModel getLoginModel() {
		return loginModel;
	}

	public void setLoginModel(LoginModel loginModel) {
		this.loginModel = loginModel;
	}

	public boolean isComfirmed() throws InterruptedException {
		Thread.sleep(10); // Làm chậm luồng thực thi trong 10 mili giây
		return comfirmLogin;
	}

	public void setComfirm(boolean comfirm) {
		this.comfirmLogin = comfirm;
	}

	public void verify() {
		String userName = this.getTextFieldUserName().getText();
		String password = this.getTextFieldPassword().getText();

		if (this.loginModel.verifyInfo(userName, password) == true) {
			this.comfirmLogin = true;
		} else {
			this.comfirmLogin = false;
			JOptionPane.showMessageDialog(this, "Looks like you entered username or password incorrectly.\n Please enter again",
					"Verify Information", JOptionPane.WARNING_MESSAGE);
		}
	}

	public void clearForm() {
		this.getTextFieldUserName().setText("");
		this.getTextFieldPassword().setText("");
	}

}
