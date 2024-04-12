package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.DriverManagementListener;
import test.Init;

public class DriverManagementView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldDriverID;
	private JTextField textFieldPhone;
	private JTextField textFieldAddress;
	private JTable tableDriverList;
	private JTextField textFieldFullName;
	private JTextField textFieldDLNumber;
	private JLabel lbCar;
	private JLabel lbTrip;
	private JLabel lbStatistics;
	private JLabel lbLogout;
	private JComboBox comboBoxStatus;
	private JButton btnSave;
	private JButton btnEdit;
	private JButton btnDelete;
	private JButton btnReset;
	private JLabel lbNotification;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DriverManagementView frame = new DriverManagementView();
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
	public DriverManagementView() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(CarManagementView.class.getResource("/view/01_logobachkhoasang.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1224, 806);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		DriverManagementListener driverManagementListener = new DriverManagementListener(this);

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

		lbTrip = new JLabel("Trip");
		lbTrip.setHorizontalAlignment(SwingConstants.CENTER);
		lbTrip.setForeground(Color.WHITE);
		lbTrip.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lbTrip.setBounds(103, 238, 34, 26);
		lbTrip.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Init.tripManagementView.setVisible(true);
				setVisible(false);
			}
		});
		panel.add(lbTrip);

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
				new ImageIcon(DriverManagementView.class.getResource("/view/Graphicloads-Transport-Car-5.72.png")));
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

		JLabel lblNewLabel_2_3 = new JLabel("Manage Drivers");
		lblNewLabel_2_3.setBounds(399, 10, 170, 28);
		lblNewLabel_2_3.setForeground(new Color(3, 43, 145));
		lblNewLabel_2_3.setFont(new Font("Century Gothic", Font.BOLD, 22));
		panel_2.add(lblNewLabel_2_3);

		JLabel lblNewLabel_2_3_1 = new JLabel("Driver ID");
		lblNewLabel_2_3_1.setBounds(10, 58, 134, 21);
		lblNewLabel_2_3_1.setForeground(new Color(3, 43, 145));
		lblNewLabel_2_3_1.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		panel_2.add(lblNewLabel_2_3_1);

		JLabel lblNewLabel_2_3_1_1 = new JLabel("Full Name");
		lblNewLabel_2_3_1_1.setBounds(172, 58, 134, 21);
		lblNewLabel_2_3_1_1.setForeground(new Color(3, 43, 145));
		lblNewLabel_2_3_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		panel_2.add(lblNewLabel_2_3_1_1);

		JLabel lblNewLabel_2_3_1_2 = new JLabel("Phone");
		lblNewLabel_2_3_1_2.setBounds(334, 58, 134, 21);
		lblNewLabel_2_3_1_2.setForeground(new Color(3, 43, 145));
		lblNewLabel_2_3_1_2.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		panel_2.add(lblNewLabel_2_3_1_2);

		JLabel lblNewLabel_2_3_1_3 = new JLabel("Address");
		lblNewLabel_2_3_1_3.setBounds(496, 58, 134, 21);
		lblNewLabel_2_3_1_3.setForeground(new Color(3, 43, 145));
		lblNewLabel_2_3_1_3.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		panel_2.add(lblNewLabel_2_3_1_3);

		JLabel lblNewLabel_2_3_1_3_1 = new JLabel("DL Number");
		lblNewLabel_2_3_1_3_1.setBounds(658, 58, 134, 21);
		lblNewLabel_2_3_1_3_1.setForeground(new Color(3, 43, 145));
		lblNewLabel_2_3_1_3_1.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		panel_2.add(lblNewLabel_2_3_1_3_1);

		JLabel lblNewLabel_2_3_1_3_1_1 = new JLabel("Status ");
		lblNewLabel_2_3_1_3_1_1.setBounds(820, 58, 134, 21);
		lblNewLabel_2_3_1_3_1_1.setForeground(new Color(3, 43, 145));
		lblNewLabel_2_3_1_3_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		panel_2.add(lblNewLabel_2_3_1_3_1_1);

		textFieldDriverID = new JTextField();
		textFieldDriverID.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		textFieldDriverID.setBounds(10, 89, 134, 28);
		textFieldDriverID.setColumns(10);
		panel_2.add(textFieldDriverID);

		textFieldPhone = new JTextField();
		textFieldPhone.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		textFieldPhone.setColumns(10);
		textFieldPhone.setBounds(334, 89, 134, 28);
		panel_2.add(textFieldPhone);

		textFieldAddress = new JTextField();
		textFieldAddress.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		textFieldAddress.setColumns(10);
		textFieldAddress.setBounds(496, 89, 134, 28);
		panel_2.add(textFieldAddress);

		comboBoxStatus = new JComboBox();
		comboBoxStatus.setModel(new DefaultComboBoxModel(new String[] { "", "Available", "Unavailable" }));
		comboBoxStatus.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		comboBoxStatus.setBounds(820, 89, 134, 28);
		panel_2.add(comboBoxStatus);

		btnSave = new JButton("Save");
		btnSave.setForeground(new Color(3, 43, 145));
		btnSave.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		btnSave.setBounds(259, 142, 108, 31);
		btnSave.addActionListener(driverManagementListener);
		panel_2.add(btnSave);

		btnEdit = new JButton("Edit");
		btnEdit.setForeground(new Color(3, 43, 145));
		btnEdit.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		btnEdit.setBounds(377, 143, 108, 28);
		btnEdit.addActionListener(driverManagementListener);
		panel_2.add(btnEdit);

		btnDelete = new JButton("Delete");
		btnDelete.setForeground(new Color(3, 43, 145));
		btnDelete.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		btnDelete.setBounds(497, 142, 108, 31);
		btnDelete.addActionListener(driverManagementListener);
		panel_2.add(btnDelete);

		btnReset = new JButton("Reset");
		btnReset.setForeground(new Color(3, 43, 145));
		btnReset.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		btnReset.setBounds(615, 142, 108, 31);
		btnReset.addActionListener(driverManagementListener);
		panel_2.add(btnReset);

		JLabel lblNewLabel_2_3_2 = new JLabel("Driver List");
		lblNewLabel_2_3_2.setForeground(new Color(3, 43, 145));
		lblNewLabel_2_3_2.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblNewLabel_2_3_2.setBounds(443, 209, 82, 23);
		panel_2.add(lblNewLabel_2_3_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setLocation(10, 247);
		scrollPane.setSize(948, 460);
		panel_2.add(scrollPane);
		tableDriverList = new JTable();
		scrollPane.setViewportView(tableDriverList);
		tableDriverList.setRowSelectionAllowed(false);
		tableDriverList.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null }, },
				new String[] { "Driver ID", "Full Name", "Phone", "Address", "Driver's License Number", "Status" }));
		tableDriverList.setForeground(Color.BLACK);
		tableDriverList.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		tableDriverList.setRowHeight(25);
		tableDriverList.setBorder(null);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(192, 192, 192));
		separator.setBounds(10, 194, 944, 1);
		panel_2.add(separator);

		textFieldFullName = new JTextField();
		textFieldFullName.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		textFieldFullName.setColumns(10);
		textFieldFullName.setBounds(172, 89, 134, 28);
		panel_2.add(textFieldFullName);

		textFieldDLNumber = new JTextField();
		textFieldDLNumber.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		textFieldDLNumber.setColumns(10);
		textFieldDLNumber.setBounds(658, 89, 134, 28);
		panel_2.add(textFieldDLNumber);

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

		lbNotification = new JLabel("No notifications");
		lbNotification.setForeground(new Color(64, 0, 64));
		lbNotification.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lbNotification.setBounds(107, 0, 861, 23);
		panel_1_1.add(lbNotification);
	}

	public JButton getBtnSave() {
		return btnSave;
	}

	public void setBtnSave(JButton btnSave) {
		this.btnSave = btnSave;
	}

	public JButton getBtnEdit() {
		return btnEdit;
	}

	public void setBtnEdit(JButton btnEdit) {
		this.btnEdit = btnEdit;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}

	public JButton getBtnReset() {
		return btnReset;
	}

	public void setBtnReset(JButton btnReset) {
		this.btnReset = btnReset;
	}

}