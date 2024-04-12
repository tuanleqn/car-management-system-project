package view;

import java.awt.EventQueue;
import javax.swing.ImageIcon;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JProgressBar;
import java.awt.Toolkit;

public class ProgressView extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProgressView frame = new ProgressView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JProgressBar progressBar;

	/**
	 * Create the frame.
	 */
	public ProgressView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ProgressView.class.getResource("/view/01_logobachkhoasang.png")));
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Car Management Software");
		lblNewLabel.setForeground(new Color(3, 43, 145));
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblNewLabel.setBounds(79, 10, 269, 26);
		getContentPane().add(lblNewLabel);
		
		progressBar = new JProgressBar();
		progressBar.setForeground(new Color(3, 43, 145));
		progressBar.setBounds(0, 175, 428, 11);
		getContentPane().add(progressBar);
		
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon(ProgressView.class.getResource("/view/Graphicloads-Transport-Car-5.48.png")));
		lblNewLabel_1.setBounds(190, 69, 48, 48);
		getContentPane().add(lblNewLabel_1);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(442, 223);
		this.setLocationRelativeTo(null);
	}
}
