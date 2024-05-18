package view;

import java.awt.EventQueue;

import controller.TripManagementListener;
import model.CarModel;
import model.DriverModel;
import model.TripManagementModel;
import model.TripModel;
import model.TripStatus;
import test.Init;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class TripManagementView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldTripID;
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
	private JComboBox<String> cbTripStatus;
	private JButton btnReset;
	private JButton btnDelete;
	private JButton btnEdit;
	private JButton btnSave;
	private JLabel lbNotification;
	private TripManagementModel tripManagementModel;

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
	@SuppressWarnings("deprecation")
	public TripManagementView() {
		tripManagementModel = new TripManagementModel();
		tripManagementModel.get();

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
				int choice = JOptionPane.showConfirmDialog(Init.tripManagementView, "Are you sure to logout?");
				if (choice == JOptionPane.YES_OPTION) {
					Init.loginView.setVisible(true);
					setVisible(false);
				}
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

		textFieldTripID = new JTextField();
		textFieldTripID.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lbNotification.setText("Trip ID has the format \"TID-...\", with natural numbers after the dash");
			}
		});
		textFieldTripID.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		textFieldTripID.setBounds(10, 89, 134, 28);
		textFieldTripID.setColumns(10);
		panel_2.add(textFieldTripID);

		textFieldArrivalPoint = new JTextField();
		textFieldArrivalPoint.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		textFieldArrivalPoint.setColumns(10);
		textFieldArrivalPoint.setBounds(334, 89, 134, 28);
		panel_2.add(textFieldArrivalPoint);

		textFieldDepartureTime = new JTextField();
		textFieldDepartureTime.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lbNotification.setText("Departure time has the format dd/mm/yyyy, it must be less than Arrival time.");
			}
		});
		textFieldDepartureTime.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		textFieldDepartureTime.setColumns(10);
		textFieldDepartureTime.setBounds(496, 89, 134, 28);
		panel_2.add(textFieldDepartureTime);

		cbTripStatus = new JComboBox<String>();
		ArrayList<TripStatus> tripStaList = TripStatus.getTripStatusList();
		cbTripStatus.addItem("");
		for (TripStatus tripStatus : tripStaList) {
			cbTripStatus.addItem(tripStatus.getTripStatusName());
		}
		cbTripStatus.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		cbTripStatus.setBounds(820, 89, 134, 28);
		cbTripStatus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lbNotification.setText("");
			}
		});
		panel_2.add(cbTripStatus);

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
		String[][] tableData = new String[tripManagementModel.getTripList().size()][9];
		int row = 0;
		for (TripModel tripModel : tripManagementModel.getTripList()) {
			tableData[row][0] = tripModel.getTripID() + "";
			tableData[row][1] = tripModel.getDeparturePoint() + "";
			tableData[row][2] = tripModel.getArrivalPoint() + "";
			tableData[row][3] = tripModel.getDepartureTime().getDate() + "/" + (tripModel.getDepartureTime().getMonth() + 1)
					+ "/" + (tripModel.getDepartureTime().getYear() + 1900);
			tableData[row][4] = tripModel.getArrivalTime().getDate() + "/" + (tripModel.getArrivalTime().getMonth() + 1)
					+ "/" + (tripModel.getArrivalTime().getYear() + 1900);
			tableData[row][5] = tripModel.getStatus().getTripStatusName() + "";
			tableData[row][6] = tripModel.getDriverID() + "";
			tableData[row][7] = tripModel.getCarID() + "";
			tableData[row][8] = tripModel.getPrice() + "";
			row++;
		}
		tableTripList.setModel(new DefaultTableModel(tableData, new String[] { "Trip ID", "Departure Point",
				"Arrival Point", "Departure Time", "Arrival Time", "Status", "Driver ID", "Car ID", "Price" }));
		tableTripList.setForeground(Color.BLACK);
		tableTripList.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		tableTripList.setRowHeight(25);
		tableTripList.setBorder(null);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(192, 192, 192));
		separator.setBounds(14, 429, 944, 1);
		panel_2.add(separator);

		textFieldDeparturePoint = new JTextField();
		textFieldDeparturePoint.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lbNotification.setText("");
			}
		});
		textFieldDeparturePoint.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		textFieldDeparturePoint.setColumns(10);
		textFieldDeparturePoint.setBounds(172, 89, 134, 28);
		panel_2.add(textFieldDeparturePoint);

		textFieldArrivalTime = new JTextField();
		textFieldArrivalTime.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lbNotification
						.setText("Arrival time has the format dd/mm/yyyy, it must be greater than Departure time.");
			}
		});
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
		textFieldDriverID.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lbNotification.setText("");
			}
		});
		textFieldDriverID.setEditable(false);
		textFieldDriverID.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		textFieldDriverID.setColumns(10);
		textFieldDriverID.setBounds(141, 161, 134, 28);
		panel_2.add(textFieldDriverID);

		textFieldCarID = new JTextField();
		textFieldCarID.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lbNotification.setText("");
			}
		});
		textFieldCarID.setEditable(false);
		textFieldCarID.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		textFieldCarID.setColumns(10);
		textFieldCarID.setBounds(416, 161, 134, 28);
		panel_2.add(textFieldCarID);

		textFieldPrice = new JTextField();
		textFieldPrice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lbNotification.setText("Price can be a real number and must be greater than zero.");
			}
		});
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
		tableDriverList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel tableModel = (DefaultTableModel) tableDriverList.getModel();
				int row = tableDriverList.getSelectedRow();

				String driverID = tableModel.getValueAt(row, 0) + "";
				Init.tripManagementView.textFieldDriverID.setText(driverID);
			}
		});
		scrollPane_1.setViewportView(tableDriverList);
		tableDriverList.setRowSelectionAllowed(false);
		String[][] tableDataDriverList = new String[Init.driverManagementView.getDriverManagementModel().getDriverList().size()][2]; 
		int rowDriverList = 0;
		for (DriverModel driverModel : Init.driverManagementView.getDriverManagementModel().getDriverList()) {			
			tableDataDriverList[rowDriverList][0] = driverModel.getDriverID() + "";
			tableDataDriverList[rowDriverList][1] = driverModel.getStatus().getDriverStatusName() + "";
			rowDriverList++; 
		}
		tableDriverList.setModel(new DefaultTableModel(tableDataDriverList, new String[] { "Driver ID", "Status" }));
		tableDriverList.setForeground(Color.BLACK);
		tableDriverList.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		tableDriverList.setRowHeight(25);
		tableDriverList.setBorder(null);

		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(496, 309, 462, 110);
		panel_2.add(scrollPane_1_1);
		tableCarList = new JTable();
		tableCarList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel tableModel = (DefaultTableModel) tableCarList.getModel();
				int row = tableCarList.getSelectedRow();

				String carID = tableModel.getValueAt(row, 0) + "";
				Init.tripManagementView.textFieldCarID.setText(carID);
			}
		});
		scrollPane_1_1.setViewportView(tableCarList);
		tableCarList.setRowSelectionAllowed(false);
		String[][] tableDataCarList = new String[Init.carManagementView.getCarManagementModel().getCarList().size()][2]; 
		int rowCarList = 0;
		for (CarModel carModel : Init.carManagementView.getCarManagementModel().getCarList()) {			
			tableDataCarList[rowCarList][0] = carModel.getRegistrationNum() + "";
			tableDataCarList[rowCarList][1] = carModel.getStatus().getCarStatusName() + "";
			rowCarList++; 
		}
		tableCarList.setModel(new DefaultTableModel(tableDataCarList, new String[] { "Car ID", "Status" }));
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

	public JLabel getLbNotification() {
		return lbNotification;
	}

	public void setLbNotification(JLabel lbNotification) {
		this.lbNotification = lbNotification;
	}

	public TripManagementModel getTripManagementModel() {
		return tripManagementModel;
	}

	public JTable getTableTripList() {
		return tableTripList;
	}

	public void setTableTripList(JTable tableTripList) {
		this.tableTripList = tableTripList;
	}

	public void setTripManagementModel(TripManagementModel tripManagementModel) {
		this.tripManagementModel = tripManagementModel;
	}

	public void saveTheCarToTableInTripManagement(CarModel cm) {
		DefaultTableModel tableModel = (DefaultTableModel) tableCarList.getModel();
		tableModel.addRow(new Object[] { cm.getRegistrationNum() + "", cm.getStatus().getCarStatusName() + "", });
	}

	public void updateTheCarToTableInTripManagement(CarModel cm) {
		DefaultTableModel tableModel = (DefaultTableModel) tableCarList.getModel();
		int numberOfRows = tableModel.getRowCount();
		for (int i = 0; i < numberOfRows; i++) {
			String id = tableModel.getValueAt(i, 0) + "";
			if (id.equals(cm.getRegistrationNum() + "")) {
				tableModel.setValueAt(cm.getRegistrationNum() + "", i, 0);
				tableModel.setValueAt(cm.getStatus().getCarStatusName() + "", i, 1);
			}
		}
	}

	public void deleteTheCarToTableInTripManagement(int row) {
		DefaultTableModel tableModel = (DefaultTableModel) tableCarList.getModel();
		tableModel.removeRow(row);
	}

	public void clearForm() {
		this.textFieldTripID.setText("");
		this.textFieldDeparturePoint.setText("");
		this.textFieldArrivalPoint.setText("");
		this.textFieldDepartureTime.setText("");
		this.textFieldArrivalTime.setText("");
		this.textFieldPrice.setText("");
		this.textFieldCarID.setText("");
		this.textFieldDriverID.setText("");
		this.cbTripStatus.setSelectedIndex(-1);
	}

	public void saveTheTripToModel() {
		String tripID = this.textFieldTripID.getText();
		String departurePoint = this.textFieldDeparturePoint.getText();
		String arrivalPoint = this.textFieldArrivalPoint.getText();
		int tripStatusID = this.cbTripStatus.getSelectedIndex() - 1;
		TripStatus tripStatus = TripStatus.getTripStatusById(tripStatusID);
		if (convertDateFormat(this.textFieldDepartureTime.getText()).equals("Error")) {
			return;
		}
		@SuppressWarnings("deprecation")
		Date departureTime = new Date(convertDateFormat(this.textFieldDepartureTime.getText()));
		if (convertDateFormat(this.textFieldArrivalTime.getText()).equals("Error")) {
			return;
		}
		@SuppressWarnings("deprecation")
		Date arrivalTime = new Date(convertDateFormat(this.textFieldArrivalTime.getText()));
		float price = Float.valueOf(this.textFieldPrice.getText());
		String carID = this.textFieldCarID.getText();
		String driverID = this.textFieldDriverID.getText();

		/*
		 * xu ly ngoai le
		 */

		if (tripID == "" || departurePoint == "" || arrivalPoint == "" || tripStatus.getTripStatusName() == ""
				|| this.textFieldDepartureTime.getText() == "" || this.textFieldArrivalTime.getText() == ""
				|| this.textFieldPrice.getText() == "" || carID == "" || driverID == "") {
			JOptionPane.showMessageDialog(this,
					"Looks like you're leaving the information blank.\n Please add it fully.", "Missing Information",
					JOptionPane.WARNING_MESSAGE);
		}

		if (!this.isValidDateFormat(departureTime)) {
			JOptionPane.showMessageDialog(this, "Date format is incorrect.", "Format Error",
					JOptionPane.WARNING_MESSAGE);
			return;
		} else if (!this.isValidDateFormat(arrivalTime)) {
			JOptionPane.showMessageDialog(this, "Date format is incorrect.", "Format Error",
					JOptionPane.WARNING_MESSAGE);
			return;
		} else if (departureTime.compareTo(arrivalTime) > 0) {
			JOptionPane.showMessageDialog(this, "Arrival time must be greater than or equal to departure time.",
					"Logic Error", JOptionPane.WARNING_MESSAGE);
			return;
		} else if (isCarStatusMaintenance(carID)) {
			JOptionPane.showMessageDialog(this, "This car is under maintenance.");
			return;
		} else if (isCarStatusInactive(carID)) {
			JOptionPane.showMessageDialog(this, "This car is under inactive.");
			return;
		} else if (!isValidTripID(tripID)) {
			JOptionPane.showMessageDialog(this, "Trip ID is invalid.");
			return;
		} else if (!checkTheLegalizationOfCarIDInTableTripList(carID)) {
			JOptionPane.showMessageDialog(this, "This car was used.");
			return;
		} else if (price <= 0.0) {
			JOptionPane.showMessageDialog(this, "The price must be greater than zero.");
			return;
		} else if (isDriverStatusUnavailable(driverID)) {
			JOptionPane.showMessageDialog(this, "This driver is unavailable.");
			return;
		} else if (!checkTheLegalizationOfDriverIDInTableTripList(driverID)) {
			JOptionPane.showMessageDialog(this, "This driver was busy.");
			return;
		}

		TripModel tm = new TripModel(tripID, departurePoint, arrivalPoint, departureTime, arrivalTime, tripStatus,
				driverID, carID, price);
		this.saveOrUpdateTheTrip(tm);
	}

	private boolean isCarStatusInactive(String carID) {
		DefaultTableModel tableModel = (DefaultTableModel) tableCarList.getModel();
		int numberOfRows = tableCarList.getRowCount();

		for (int i = 0; i < numberOfRows; i++) {
			String id = carID;
			if (id.equals(tableModel.getValueAt(i, 0) + "")) {
				if ((tableModel.getValueAt(i, 1) + "").equals("Inactive")) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean checkTheLegalizationOfDriverIDInTableTripList(String driverID) {
		DefaultTableModel tableModel = (DefaultTableModel) tableTripList.getModel();
		int numberOfRows = tableTripList.getRowCount();
		for (int i = 0; i < numberOfRows; i++) {
			String id = tableModel.getValueAt(i, 6) + "";
			if (id.equals(driverID)) {
				if (tableModel.getValueAt(i, 5).equals("In progess")) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean isDriverStatusUnavailable(String driverID) {
		DefaultTableModel tableModel = (DefaultTableModel) tableDriverList.getModel();
		int numberOfRows = tableDriverList.getRowCount();

		for (int i = 0; i < numberOfRows; i++) {
			String id = driverID;
			if (id.equals(tableModel.getValueAt(i, 0) + "")) {
				if ((tableModel.getValueAt(i, 1) + "").equals("Unavailable")) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean checkTheLegalizationOfCarIDInTableTripList(String carID) {
		DefaultTableModel tableModel = (DefaultTableModel) tableTripList.getModel();
		int numberOfRows = tableTripList.getRowCount();
		for (int i = 0; i < numberOfRows; i++) {
			String id = tableModel.getValueAt(i, 7) + "";
			if (id.equals(carID)) {
				if (tableModel.getValueAt(i, 5).equals("In progess")) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean isValidTripID(String tripID) {
		if (tripID.length() < 5) {
			return false;
		}
		if (!tripID.substring(0, 4).equals("TID-")) {
			return false;
		}
		for (int i = 4; i < tripID.length(); i++) {
			char c = tripID.charAt(i);
			if (!(c >= '0' && c <= '9')) {
				return false;
			}
		}
		return true;
	}

	private boolean isCarStatusMaintenance(String carID) {
		DefaultTableModel tableModel = (DefaultTableModel) tableCarList.getModel();
		int numberOfRows = tableCarList.getRowCount();

		for (int i = 0; i < numberOfRows; i++) {
			String id = carID;
			if (id.equals(tableModel.getValueAt(i, 0) + "")) {
				if ((tableModel.getValueAt(i, 1) + "").equals("Maintenance")) {
					return true;
				}
			}
		}

		return false;
	}

	@SuppressWarnings("deprecation")
	private boolean isValidDateFormat(Date date) {
		int day = date.getDate();
		int month = date.getMonth() + 1;
		int year = date.getYear() + 1900;
		if (!(year >= 0 && year <= 9999)) {
			return false;
		} else if (!(month >= 1 && month <= 12)) {
			return false;
		} else if (!(day >= 1 && day <= 31)) {
			return false;
		} else if (month == 2) {
			if (!(day >= 1 && day <= 29))
				return false;
		} else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			if (day == 31)
				return false;
		}
		return true;
	}

	private String convertDateFormat(String str) {
		String inputDateStr = str;
		SimpleDateFormat oldDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date inputDate = null;
		try {
			inputDate = oldDateFormat.parse(inputDateStr);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(this, "Date format is incorrect.", "Format Error",
					JOptionPane.WARNING_MESSAGE);
			return "Error";
		}
		SimpleDateFormat newDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		String newDateStr = newDateFormat.format(inputDate);
		return newDateStr;

	}

	@SuppressWarnings("deprecation")
	private void saveOrUpdateTheTrip(TripModel tm) {
		DefaultTableModel tableModel = (DefaultTableModel) tableTripList.getModel();
		if (!this.tripManagementModel.existenceCheck(tm)) {
			this.tripManagementModel.save(tm);
			this.saveTheTripToTable(tm);
			this.clearForm();
			this.lbNotification.setText("You just add a trip");
		} else {
			this.tripManagementModel.update(tm);
			int numberOfRows = tableModel.getRowCount();
			for (int i = 0; i < numberOfRows; i++) {
				String id = tableModel.getValueAt(i, 0) + "";
				if (id.equals(tm.getTripID() + "")) {
					tableModel.setValueAt(tm.getTripID() + "", i, 0);
					tableModel.setValueAt(tm.getDeparturePoint() + "", i, 1);
					tableModel.setValueAt(tm.getArrivalPoint() + "", i, 2);
					tableModel.setValueAt(tm.getDepartureTime().getDate() + "/" + (tm.getDepartureTime().getMonth() + 1)
							+ "/" + (tm.getDepartureTime().getYear() + 1900), i, 3);
					tableModel.setValueAt(tm.getArrivalTime().getDate() + "/" + (tm.getArrivalTime().getMonth() + 1)
							+ "/" + (tm.getArrivalTime().getYear() + 1900), i, 4);
					tableModel.setValueAt(tm.getStatus().getTripStatusName() + "", i, 5);
					tableModel.setValueAt(tm.getDriverID() + "", i, 6);
					tableModel.setValueAt(tm.getCarID() + "", i, 7);
					tableModel.setValueAt(tm.getPrice() + "", i, 8);

					String status = "";
					String status2 = "";
					if (tm.getStatus().getTripStatusName().equals("In progress")) {
						status = "Inactive";
						status2 = "Unavailable";
					} else {
						status = "Active";
						status2 = "Available";
					}

					Init.carManagementView.updateTheStatusOfCarIdInCarManagement(tm, status);
					Init.driverManagementView.updateTheStatusOfDriverIdInDriverManagement(tm, status2);
				}
			}
			this.clearForm();
			this.lbNotification.setText("You just update the trip.");
		}

	}

	@SuppressWarnings("deprecation")
	private void saveTheTripToTable(TripModel tm) {
		DefaultTableModel tableModel = (DefaultTableModel) tableTripList.getModel();
		tableModel.addRow(new Object[] { tm.getTripID() + "", tm.getDeparturePoint() + "", tm.getArrivalPoint() + "",
				tm.getDepartureTime().getDate() + "/" + (tm.getDepartureTime().getMonth() + 1) + "/"
						+ (tm.getDepartureTime().getYear() + 1900),
				tm.getArrivalTime().getDate() + "/" + (tm.getArrivalTime().getMonth() + 1) + "/"
						+ (tm.getArrivalTime().getYear() + 1900),
				tm.getStatus().getTripStatusName() + "", tm.getDriverID() + "", tm.getCarID() + "", tm.getPrice() });

		String status = "";
		String status22 = "";
		if (tm.getStatus().getTripStatusName().equals("In progress")) {
			status = "Inactive";
			status22 = "Unavailable";
		} else {
			status = "Active";
			status22 = "Available";
		}
		Init.carManagementView.updateTheStatusOfCarIdInCarManagement(tm, status);
		Init.driverManagementView.updateTheStatusOfDriverIdInDriverManagement(tm, status22);
	}

	@SuppressWarnings("deprecation")
	public void displaySelectedTripInformation() {
		TripModel tm = getSelectedTripInformation();

		this.textFieldTripID.setText(tm.getTripID() + "");
		this.textFieldDeparturePoint.setText(tm.getDeparturePoint() + "");
		this.textFieldArrivalPoint.setText(tm.getArrivalPoint() + "");
		this.textFieldArrivalTime.setText(tm.getArrivalTime().getDate() + "/" + (tm.getArrivalTime().getMonth() + 1)
				+ "/" + (tm.getArrivalTime().getYear() + 1900));
		this.textFieldDepartureTime.setText(tm.getDepartureTime().getDate() + "/"
				+ (tm.getDepartureTime().getMonth() + 1) + "/" + (tm.getDepartureTime().getYear() + 1900));
		this.cbTripStatus.setSelectedItem(tm.getStatus().getTripStatusName());
		this.textFieldDriverID.setText(tm.getDriverID() + "");
		this.textFieldCarID.setText(tm.getCarID() + "");
		this.textFieldPrice.setText(tm.getPrice() + "");
	}

	private TripModel getSelectedTripInformation() {
		DefaultTableModel tableModel = (DefaultTableModel) tableTripList.getModel();
		int row = tableTripList.getSelectedRow();

		String tripID = tableModel.getValueAt(row, 0) + "";
		String departurePoint = tableModel.getValueAt(row, 1) + "";
		String arrivalPoint = tableModel.getValueAt(row, 2) + "";
		String s_departureTime = tableModel.getValueAt(row, 3) + "";
		@SuppressWarnings("deprecation")
		Date departureTime = new Date(convertDateFormat(s_departureTime));
		String s_arrivalTime = tableModel.getValueAt(row, 4) + "";
		@SuppressWarnings("deprecation")
		Date arrivalTime = new Date(convertDateFormat(s_arrivalTime));
		TripStatus status = TripStatus.getTripStatusByName(tableModel.getValueAt(row, 5) + "");
		String driverID = tableModel.getValueAt(row, 6) + "";
		String carID = tableModel.getValueAt(row, 7) + "";
		float price = Float.valueOf(tableModel.getValueAt(row, 8) + "");

		TripModel tm = new TripModel(tripID, departurePoint, arrivalPoint, departureTime, arrivalTime, status, driverID,
				carID, price);
		return tm;
	}

	public void deleteSelectedTrip() {
		DefaultTableModel tableModel = (DefaultTableModel) tableTripList.getModel();
		int row = tableTripList.getSelectedRow();
		int choice = JOptionPane.showConfirmDialog(this, "Are you sure to delete the selected row?");
		if (choice == JOptionPane.YES_OPTION) {
			TripModel tm = getSelectedTripInformation();
			this.tripManagementModel.delete(tm);
			tableModel.removeRow(row);

			String status = "";
			String status2 = "";
			status = "Active";
			status2 = "Available";

			Init.carManagementView.updateTheStatusOfCarIdInCarManagement(tm, status);
			Init.driverManagementView.updateTheStatusOfDriverIdInDriverManagement(tm, status2);
		}

	}

	public void updateTheDriverToTableInTripManagement(DriverModel dm) {
		DefaultTableModel tableModel = (DefaultTableModel) tableDriverList.getModel();
		int numberOfRows = tableModel.getRowCount();
		for (int i = 0; i < numberOfRows; i++) {
			String id = tableModel.getValueAt(i, 0) + "";
			if (id.equals(dm.getDriverID() + "")) {
				tableModel.setValueAt(dm.getDriverID() + "", i, 0);
				tableModel.setValueAt(dm.getStatus().getDriverStatusName() + "", i, 1);
			}
		}

	}

	public void saveTheTripToTableInTripManagement(DriverModel dm) {
		DefaultTableModel tableModel = (DefaultTableModel) tableDriverList.getModel();
		tableModel.addRow(new Object[] { dm.getDriverID() + "", dm.getStatus().getDriverStatusName() + "", });
	}

	public void deleteTheDriverToTableInTripManagement(int row) {
		DefaultTableModel tableModel = (DefaultTableModel) tableDriverList.getModel();
		tableModel.removeRow(row);
	}

}
