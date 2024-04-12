package view;

import java.awt.EventQueue;

import controller.TripManagementListener;
import test.Init;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class TripManagementView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldTrip;
	private JTextField textFieldArrivalPoint;
	private JTextField textFieldDepartureTime;
	private JTable tableTripList;
	private JTextField textFieldDeparturePoint;
	private JTextField textFieldArrivalTime;
	private JTextField textFieldDriverID;
	private JTextField textFieldCarID;
	private JTextField textFieldPrice;
	private JTable tableDriverList;
	private JTable tableCarList;
	private JLabel lbCar;
	private JLabel lbDriver;
	private JLabel lbStatistics;
	private JLabel lbLogout;
	private JComboBox comboBoxStatus;
	private JButton btnReset;
	private JButton btnDelete;
	private JButton btnEdit;
	private JButton btnSave;
	private JLabel lbNotification;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TripManagementView frame = new TripManagementView();
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
	public TripManagementView() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(CarManagementView.class.getResource("/view/01_logobachkhoasang.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1224, 806);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		TripManagementListener tripMangementListener = new TripManagementListener(this);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(3, 43, 145));
		panel.setBounds(0, 0, 241, 769);
		contentPane.add(panel);

		lbCar = new JLabel("Car");
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

		lbDriver = new JLabel("Driver");
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

		lbStatistics = new JLabel("Statistics");
		lbStatistics.setHorizontalAlignment(SwingConstants.CENTER);
		lbStatistics.setForeground(Color.WHITE);
		lbStatistics.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lbStatistics.setBounds(79, 286, 83, 26);
		lbStatistics.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Init.statisticsView.setVisible(true);
				setVisible(false);
			}
		});
		panel.add(lbStatistics);

		lbLogout = new JLabel("Logout");
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
		lblNewLabel_1.setIcon(
				new ImageIcon(TripManagementView.class.getResource("/view/Graphicloads-Transport-Car-5.72.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(84, 41, 72, 72);
		panel.add(lblNewLabel_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(242, 0, 968, 25);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(242, 27, 968, 717);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_2_3 = new JLabel("Manage Trip");
		lblNewLabel_2_3.setBounds(399, 10, 170, 28);
		lblNewLabel_2_3.setForeground(new Color(3, 43, 145));
		lblNewLabel_2_3.setFont(new Font("Century Gothic", Font.BOLD, 22));
		panel_2.add(lblNewLabel_2_3);

		JLabel lblNewLabel_2_3_1 = new JLabel("Trip ID");
		lblNewLabel_2_3_1.setBounds(10, 58, 134, 21);
		lblNewLabel_2_3_1.setForeground(new Color(3, 43, 145));
		lblNewLabel_2_3_1.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		panel_2.add(lblNewLabel_2_3_1);

		JLabel lblNewLabel_2_3_1_1 = new JLabel("Departure Point");
		lblNewLabel_2_3_1_1.setBounds(172, 58, 134, 21);
		lblNewLabel_2_3_1_1.setForeground(new Color(3, 43, 145));
		lblNewLabel_2_3_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		panel_2.add(lblNewLabel_2_3_1_1);

		JLabel lblNewLabel_2_3_1_2 = new JLabel("Arrival Point");
		lblNewLabel_2_3_1_2.setBounds(334, 58, 134, 21);
		lblNewLabel_2_3_1_2.setForeground(new Color(3, 43, 145));
		lblNewLabel_2_3_1_2.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		panel_2.add(lblNewLabel_2_3_1_2);

		JLabel lblNewLabel_2_3_1_3 = new JLabel("Departure Time");
		lblNewLabel_2_3_1_3.setBounds(496, 58, 134, 21);
		lblNewLabel_2_3_1_3.setForeground(new Color(3, 43, 145));
		lblNewLabel_2_3_1_3.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		panel_2.add(lblNewLabel_2_3_1_3);

		JLabel lblNewLabel_2_3_1_3_1 = new JLabel("Arrival Time");
		lblNewLabel_2_3_1_3_1.setBounds(658, 58, 134, 21);
		lblNewLabel_2_3_1_3_1.setForeground(new Color(3, 43, 145));
		lblNewLabel_2_3_1_3_1.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		panel_2.add(lblNewLabel_2_3_1_3_1);

		JLabel lblNewLabel_2_3_1_3_1_1 = new JLabel("Status");
		lblNewLabel_2_3_1_3_1_1.setBounds(820, 58, 134, 21);
		lblNewLabel_2_3_1_3_1_1.setForeground(new Color(3, 43, 145));
		lblNewLabel_2_3_1_3_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		panel_2.add(lblNewLabel_2_3_1_3_1_1);

		textFieldTrip = new JTextField();
		textFieldTrip.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		textFieldTrip.setBounds(10, 89, 134, 28);
		panel_2.add(textFieldTrip);
		textFieldTrip.setColumns(10);

		textFieldArrivalPoint = new JTextField();
		textFieldArrivalPoint.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		textFieldArrivalPoint.setColumns(10);
		textFieldArrivalPoint.setBounds(334, 89, 134, 28);
		panel_2.add(textFieldArrivalPoint);

		textFieldDepartureTime = new JTextField();
		textFieldDepartureTime.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		textFieldDepartureTime.setColumns(10);
		textFieldDepartureTime.setBounds(496, 89, 134, 28);
		panel_2.add(textFieldDepartureTime);

		comboBoxStatus = new JComboBox();
		comboBoxStatus.setModel(new DefaultComboBoxModel(new String[] { "", "In progress", "Completed" }));
		comboBoxStatus.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		comboBoxStatus.setBounds(820, 89, 134, 28);
		panel_2.add(comboBoxStatus);

		btnSave = new JButton("Save");

		btnSave.setForeground(new Color(3, 43, 145));
		btnSave.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		btnSave.setBounds(264, 214, 108, 31);
		btnSave.addActionListener(tripMangementListener);
		panel_2.add(btnSave);

		btnEdit = new JButton("Edit");
		btnEdit.setForeground(new Color(3, 43, 145));
		btnEdit.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		btnEdit.setBounds(382, 215, 108, 28);
		btnEdit.addActionListener(tripMangementListener);
		panel_2.add(btnEdit);

		btnDelete = new JButton("Delete");
		btnDelete.setForeground(new Color(3, 43, 145));
		btnDelete.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		btnDelete.setBounds(502, 214, 108, 31);
		btnDelete.addActionListener(tripMangementListener);
		panel_2.add(btnDelete);

		btnReset = new JButton("Reset");
		btnReset.setForeground(new Color(3, 43, 145));
		btnReset.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		btnReset.setBounds(620, 214, 108, 31);
		btnReset.addActionListener(tripMangementListener);
		panel_2.add(btnReset);

		JLabel lblNewLabel_2_3_2 = new JLabel("Trip List");
		lblNewLabel_2_3_2.setForeground(new Color(3, 43, 145));
		lblNewLabel_2_3_2.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblNewLabel_2_3_2.setBounds(449, 440, 69, 23);
		panel_2.add(lblNewLabel_2_3_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setLocation(10, 473);
		scrollPane.setSize(948, 234);
		panel_2.add(scrollPane);
		tableTripList = new JTable();
		scrollPane.setViewportView(tableTripList);
		tableTripList.setRowSelectionAllowed(false);
		tableTripList.setModel(
				new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null, null, null }, },
						new String[] { "Trip ID", "Departure Point", "Arrival Point", "Departure Time", "Arrival Time",
								"Status", "Driver ID", "Car ID", "Price" }));
		tableTripList.setForeground(Color.BLACK);
		tableTripList.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		tableTripList.setRowHeight(25);
		tableTripList.setBorder(null);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(192, 192, 192));
		separator.setBounds(14, 429, 944, 1);
		panel_2.add(separator);

		textFieldDeparturePoint = new JTextField();
		textFieldDeparturePoint.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		textFieldDeparturePoint.setColumns(10);
		textFieldDeparturePoint.setBounds(172, 89, 134, 28);
		panel_2.add(textFieldDeparturePoint);

		textFieldArrivalTime = new JTextField();
		textFieldArrivalTime.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		textFieldArrivalTime.setColumns(10);
		textFieldArrivalTime.setBounds(658, 89, 134, 28);
		panel_2.add(textFieldArrivalTime);

		JLabel lblNewLabel_2_3_1_1_1 = new JLabel("Driver ID");
		lblNewLabel_2_3_1_1_1.setForeground(new Color(3, 43, 145));
		lblNewLabel_2_3_1_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblNewLabel_2_3_1_1_1.setBounds(141, 131, 134, 21);
		panel_2.add(lblNewLabel_2_3_1_1_1);

		JLabel lblNewLabel_2_3_1_1_1_1 = new JLabel("Car ID");
		lblNewLabel_2_3_1_1_1_1.setForeground(new Color(3, 43, 145));
		lblNewLabel_2_3_1_1_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblNewLabel_2_3_1_1_1_1.setBounds(416, 131, 134, 21);
		panel_2.add(lblNewLabel_2_3_1_1_1_1);

		JLabel lblNewLabel_2_3_1_1_1_2 = new JLabel("Price");
		lblNewLabel_2_3_1_1_1_2.setForeground(new Color(3, 43, 145));
		lblNewLabel_2_3_1_1_1_2.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblNewLabel_2_3_1_1_1_2.setBounds(691, 131, 134, 21);
		panel_2.add(lblNewLabel_2_3_1_1_1_2);

		textFieldDriverID = new JTextField();
		textFieldDriverID.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		textFieldDriverID.setColumns(10);
		textFieldDriverID.setBounds(141, 161, 134, 28);
		panel_2.add(textFieldDriverID);

		textFieldCarID = new JTextField();
		textFieldCarID.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		textFieldCarID.setColumns(10);
		textFieldCarID.setBounds(416, 161, 134, 28);
		panel_2.add(textFieldCarID);

		textFieldPrice = new JTextField();
		textFieldPrice.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		textFieldPrice.setColumns(10);
		textFieldPrice.setBounds(691, 161, 134, 28);
		panel_2.add(textFieldPrice);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.LIGHT_GRAY);
		separator_1.setBounds(10, 266, 944, 1);
		panel_2.add(separator_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 309, 458, 110);
		panel_2.add(scrollPane_1);
		tableDriverList = new JTable();
		scrollPane_1.setViewportView(tableDriverList);
		tableDriverList.setRowSelectionAllowed(false);
		tableDriverList.setModel(
				new DefaultTableModel(new Object[][] { { null, null }, }, new String[] { "Car ID", "Status", }));
		tableDriverList.setForeground(Color.BLACK);
		tableDriverList.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		tableDriverList.setRowHeight(25);
		tableDriverList.setBorder(null);

		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(496, 309, 462, 110);
		panel_2.add(scrollPane_1_1);
		tableCarList = new JTable();
		scrollPane_1_1.setViewportView(tableCarList);
		tableCarList.setRowSelectionAllowed(false);
		tableCarList.setModel(
				new DefaultTableModel(new Object[][] { { null, null }, }, new String[] { "Driver ID", "Status", }));
		tableCarList.setForeground(Color.BLACK);
		tableCarList.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		tableCarList.setRowHeight(25);
		tableCarList.setBorder(null);

		JLabel lblNewLabel_2_3_2_1 = new JLabel("Car List");
		lblNewLabel_2_3_2_1.setForeground(new Color(3, 43, 145));
		lblNewLabel_2_3_2_1.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblNewLabel_2_3_2_1.setBounds(693, 277, 82, 23);
		panel_2.add(lblNewLabel_2_3_2_1);

		JLabel lblNewLabel_2_3_2_2 = new JLabel("Driver List");
		lblNewLabel_2_3_2_2.setForeground(new Color(3, 43, 145));
		lblNewLabel_2_3_2_2.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblNewLabel_2_3_2_2.setBounds(200, 276, 82, 23);
		panel_2.add(lblNewLabel_2_3_2_2);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(242, 744, 968, 25);
		contentPane.add(panel_1_1);

		JLabel lblNewLabel = new JLabel("Notification: ");
		lblNewLabel.setForeground(new Color(3, 43, 145));
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 0, 87, 23);
		panel_1_1.add(lblNewLabel);

		lbNotification = new JLabel("No Notifications");
		lbNotification.setForeground(new Color(64, 0, 64));
		lbNotification.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lbNotification.setBounds(107, 0, 861, 23);
		panel_1_1.add(lbNotification);
	}

	public JButton getBtnReset() {
		return btnReset;
	}

	public void setBtnReset(JButton btnReset) {
		this.btnReset = btnReset;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}

	public JButton getBtnEdit() {
		return btnEdit;
	}

	public void setBtnEdit(JButton btnEdit) {
		this.btnEdit = btnEdit;
	}

	public JButton getBtnSave() {
		return btnSave;
	}

	public void setBtnSave(JButton btnSave) {
		this.btnSave = btnSave;
	}

}
