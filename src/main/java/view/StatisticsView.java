package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import test.Init;

public class StatisticsView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatisticsView frame = new StatisticsView();
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
	public StatisticsView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CarManagementView.class.getResource("/view/01_logobachkhoasang.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1224, 806);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(3, 43, 145));
		panel.setBounds(0, 0, 241, 769);
		contentPane.add(panel);
		
		JLabel lbCar = new JLabel("Car");
		lbCar.setHorizontalAlignment(SwingConstants.CENTER);
		lbCar.setForeground(Color.WHITE);
		lbCar.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lbCar.setBounds(92, 190, 56, 26);
		lbCar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Init.carManagementView.setVisible(true);
				setVisible(false);
			}
		});
		panel.add(lbCar);
		
		JLabel lbDriver = new JLabel("Driver");
		lbDriver.setHorizontalAlignment(SwingConstants.CENTER);
		lbDriver.setForeground(Color.WHITE);
		lbDriver.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lbDriver.setBounds(92, 238, 56, 26);
		lbDriver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Init.driverManagementView.setVisible(true);
				setVisible(false);
			}
		});
		panel.add(lbDriver);
		
		JLabel lbTrip = new JLabel("Trip");
		lbTrip.setHorizontalAlignment(SwingConstants.CENTER);
		lbTrip.setForeground(Color.WHITE);
		lbTrip.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lbTrip.setBounds(79, 286, 83, 26);
		lbTrip.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Init.tripManagementView.setVisible(true);
				setVisible(false);
			}
		});
		panel.add(lbTrip);
		
		JLabel lbLogout = new JLabel("Logout");
		lbLogout.setHorizontalAlignment(SwingConstants.CENTER);
		lbLogout.setForeground(Color.WHITE);
		lbLogout.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lbLogout.setBounds(87, 715, 66, 26);
		lbLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Init.loginView.setVisible(true);
				setVisible(false);
			}
		});
		panel.add(lbLogout);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(StatisticsView.class.getResource("/view/Graphicloads-Transport-Car-5.72.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(84, 41, 72, 72);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(242, 0, 968, 25);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(242, 744, 968, 25);
		contentPane.add(panel_1_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(new Color(3, 43, 145));
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 0, 87, 23);
		panel_1_1.add(lblNewLabel);
		
		JLabel lblText = new JLabel("");
		lblText.setForeground(new Color(64, 0, 64));
		lblText.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblText.setBounds(107, 0, 861, 23);
		panel_1_1.add(lblText);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(242, 27, 968, 718);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2_3 = new JLabel("Statistics");
		lblNewLabel_2_3.setBounds(439, 10, 90, 28);
		lblNewLabel_2_3.setForeground(new Color(3, 43, 145));
		lblNewLabel_2_3.setFont(new Font("Century Gothic", Font.BOLD, 22));
		panel_2.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_3_1_3 = new JLabel("Total Number Of Cars:");
		lblNewLabel_2_3_1_3.setForeground(new Color(3, 43, 145));
		lblNewLabel_2_3_1_3.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblNewLabel_2_3_1_3.setBounds(289, 91, 173, 21);
		panel_2.add(lblNewLabel_2_3_1_3);
		
		JLabel lbTotalNumberOfCars = new JLabel("0");
		lbTotalNumberOfCars.setForeground(new Color(255, 0, 0));
		lbTotalNumberOfCars.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lbTotalNumberOfCars.setBounds(512, 91, 82, 21);
		panel_2.add(lbTotalNumberOfCars);
		
		JLabel lblNewLabel_2_3_1_3_1 = new JLabel("Total Number Of Drivers:");
		lblNewLabel_2_3_1_3_1.setForeground(new Color(3, 43, 145));
		lblNewLabel_2_3_1_3_1.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblNewLabel_2_3_1_3_1.setBounds(289, 146, 189, 21);
		panel_2.add(lblNewLabel_2_3_1_3_1);
		
		JLabel lblNewLabel_2_3_1_3_2 = new JLabel("Total Number Of Trips:");
		lblNewLabel_2_3_1_3_2.setForeground(new Color(3, 43, 145));
		lblNewLabel_2_3_1_3_2.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblNewLabel_2_3_1_3_2.setBounds(289, 205, 173, 21);
		panel_2.add(lblNewLabel_2_3_1_3_2);
		
		JLabel lblNewLabel_2_3_1_3_3 = new JLabel("Total Revenue (USD):");
		lblNewLabel_2_3_1_3_3.setForeground(new Color(3, 43, 145));
		lblNewLabel_2_3_1_3_3.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblNewLabel_2_3_1_3_3.setBounds(289, 258, 173, 21);
		panel_2.add(lblNewLabel_2_3_1_3_3);
		
		JLabel lbTotalNumberOfDrivers = new JLabel("0");
		lbTotalNumberOfDrivers.setForeground(new Color(255, 0, 0));
		lbTotalNumberOfDrivers.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lbTotalNumberOfDrivers.setBounds(512, 146, 82, 21);
		panel_2.add(lbTotalNumberOfDrivers);
		
		JLabel lbTotalNumberOfTrips = new JLabel("0");
		lbTotalNumberOfTrips.setForeground(new Color(255, 0, 0));
		lbTotalNumberOfTrips.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lbTotalNumberOfTrips.setBounds(512, 205, 82, 21);
		panel_2.add(lbTotalNumberOfTrips);
		
		JLabel lbTotalRevenue = new JLabel("0");
		lbTotalRevenue.setForeground(new Color(255, 0, 0));
		lbTotalRevenue.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lbTotalRevenue.setBounds(512, 258, 82, 21);
		panel_2.add(lbTotalRevenue);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.LIGHT_GRAY);
		separator_1.setBounds(10, 323, 944, 1);
		panel_2.add(separator_1);
	}
}
