package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.CarManagementListener;
import model.CarManagementModel;
import model.CarModel;
import model.CarStatus;
import model.CarType;
import model.FuelType;
import model.TripModel;
import test.Init;

public class CarManagementView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldRegistrationNum;
	private JTextField textFieldSize;
	private JTextField textFieldTonnage;
	private JTable tableCarList;
	private JLabel lbNotification;
	private JButton btnSave;
	private JButton btnEdit;
	private JButton btnDelete;
	private JButton btnReset;
	private JComboBox<String> cbCarType;
	private JComboBox<String> cbStatus;
	private JComboBox<String> cbFuelType;
	private JLabel lbDriver;
	private JLabel lbTrip;
	private JLabel lbStatistics;
	private JLabel lbLogout;
	private CarManagementModel carManagementModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarManagementView frame = new CarManagementView();
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
	public CarManagementView() {
		carManagementModel = new CarManagementModel();
		carManagementModel.get();

		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(CarManagementView.class.getResource("/view/01_logobachkhoasang.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1224, 806);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		CarManagementListener carManagementListener = new CarManagementListener(this);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(3, 43, 145));
		panel.setBounds(0, 0, 241, 769);
		contentPane.add(panel);

		lbDriver = new JLabel("Driver");
		lbDriver.setHorizontalAlignment(SwingConstants.CENTER);
		lbDriver.setForeground(Color.WHITE);
		lbDriver.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lbDriver.setBounds(92, 190, 56, 26);
		lbDriver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Init.driverManagementView.setVisible(true);
				setVisible(false);
			}
		});
		panel.add(lbDriver);

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
				int choice = JOptionPane.showConfirmDialog(Init.carManagementView, "Are you sure to logout?");
				if (choice == JOptionPane.YES_OPTION) {
					Init.loginView.setVisible(true);
					setVisible(false);
				}
			}
		});
		panel.add(lbLogout);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(
				new ImageIcon(CarManagementView.class.getResource("/view/Graphicloads-Transport-Car-5.72.png")));
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

		JLabel lblNewLabel_2_3 = new JLabel("Manage Cars");
		lblNewLabel_2_3.setBounds(411, 10, 146, 28);
		lblNewLabel_2_3.setForeground(new Color(3, 43, 145));
		lblNewLabel_2_3.setFont(new Font("Century Gothic", Font.BOLD, 22));
		panel_2.add(lblNewLabel_2_3);

		JLabel lblNewLabel_2_3_1 = new JLabel("Registration Num");
		lblNewLabel_2_3_1.setBounds(10, 58, 134, 21);
		lblNewLabel_2_3_1.setForeground(new Color(3, 43, 145));
		lblNewLabel_2_3_1.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		panel_2.add(lblNewLabel_2_3_1);

		JLabel lblNewLabel_2_3_1_1 = new JLabel("Car Type");
		lblNewLabel_2_3_1_1.setBounds(172, 58, 134, 21);
		lblNewLabel_2_3_1_1.setForeground(new Color(3, 43, 145));
		lblNewLabel_2_3_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		panel_2.add(lblNewLabel_2_3_1_1);

		JLabel lblNewLabel_2_3_1_2 = new JLabel("Size (m)");
		lblNewLabel_2_3_1_2.setBounds(334, 58, 134, 21);
		lblNewLabel_2_3_1_2.setForeground(new Color(3, 43, 145));
		lblNewLabel_2_3_1_2.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		panel_2.add(lblNewLabel_2_3_1_2);

		JLabel lblNewLabel_2_3_1_3 = new JLabel("Tonnage (T)");
		lblNewLabel_2_3_1_3.setBounds(496, 58, 134, 21);
		lblNewLabel_2_3_1_3.setForeground(new Color(3, 43, 145));
		lblNewLabel_2_3_1_3.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		panel_2.add(lblNewLabel_2_3_1_3);

		JLabel lblNewLabel_2_3_1_3_1 = new JLabel("Fuel Type");
		lblNewLabel_2_3_1_3_1.setBounds(658, 58, 134, 21);
		lblNewLabel_2_3_1_3_1.setForeground(new Color(3, 43, 145));
		lblNewLabel_2_3_1_3_1.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		panel_2.add(lblNewLabel_2_3_1_3_1);

		JLabel lblNewLabel_2_3_1_3_1_1 = new JLabel("Status ");
		lblNewLabel_2_3_1_3_1_1.setBounds(820, 58, 134, 21);
		lblNewLabel_2_3_1_3_1_1.setForeground(new Color(3, 43, 145));
		lblNewLabel_2_3_1_3_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		panel_2.add(lblNewLabel_2_3_1_3_1_1);

		textFieldRegistrationNum = new JTextField();
		textFieldRegistrationNum.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		textFieldRegistrationNum.setBounds(10, 89, 134, 28);
		textFieldRegistrationNum.setColumns(10);
		textFieldRegistrationNum.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lbNotification.setText("The registration number is in the format xxBKU-xxxx, "
						+ "where x is any number from 0 to 9. " + "For example, 76BKU-1234.");
			}
		});
		panel_2.add(textFieldRegistrationNum);

		textFieldSize = new JTextField();
		textFieldSize.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		textFieldSize.setColumns(10);
		textFieldSize.setBounds(334, 89, 134, 28);
		textFieldSize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lbNotification.setText("Size consists of length, width, and height. " + "They are separated by '-'.");
			}
		});
		panel_2.add(textFieldSize);

		textFieldTonnage = new JTextField();
		textFieldTonnage.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		textFieldTonnage.setColumns(10);
		textFieldTonnage.setBounds(496, 89, 134, 28);
		textFieldTonnage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lbNotification.setText("The tonnage value can be a real number and must be greater than zero.");
			}
		});
		panel_2.add(textFieldTonnage);

		cbCarType = new JComboBox<String>();
		ArrayList<CarType> carTypeList = CarType.getCarTypeList();
		cbCarType.addItem("");
		for (CarType carType : carTypeList) {
			cbCarType.addItem(carType.getCarTypeName());
		}
		cbCarType.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		cbCarType.setBounds(172, 89, 134, 28);
		cbCarType.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lbNotification.setText("Compatibility:  " + "Bus = {Diesel, CNG, LNG, Electricity} | "
						+ "Truck = {Diesel, Gasoline, CNG, LNG} | " + "Container Truck = {Diesel, CNG, LNG}.");
			}
		});
		panel_2.add(cbCarType);

		cbStatus = new JComboBox<String>();
		ArrayList<CarStatus> carStatusList = CarStatus.getCarStatusList();
		cbStatus.addItem("");
		for (CarStatus carStatus : carStatusList) {
			cbStatus.addItem(carStatus.getCarStatusName());
		}
		cbStatus.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		cbStatus.setBounds(820, 89, 134, 28);
		cbStatus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lbNotification.setText("");
			}
		});
		panel_2.add(cbStatus);

		cbFuelType = new JComboBox<String>();
		ArrayList<FuelType> fuelTypeList = FuelType.getFuelTypeList();
		cbFuelType.addItem("");
		for (FuelType fuelType : fuelTypeList) {
			cbFuelType.addItem(fuelType.getFuelTypeName());
		}
		cbFuelType.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		cbFuelType.setBounds(658, 89, 134, 28);
		cbFuelType.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lbNotification.setText("Compatibility:  " + "Diesel, CNG, LNG = {Bus, Truck, Container Truck} | "
						+ "Gasoline = {Truck} | " + "Electricity = {Bus}.");
			}
		});
		panel_2.add(cbFuelType);

		btnSave = new JButton("Save");
		btnSave.setForeground(new Color(3, 43, 145));
		btnSave.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		btnSave.setBounds(259, 142, 108, 31);
		btnSave.addActionListener(carManagementListener);
		panel_2.add(btnSave);

		btnEdit = new JButton("Edit");
		btnEdit.setForeground(new Color(3, 43, 145));
		btnEdit.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		btnEdit.setBounds(377, 143, 108, 28);
		btnEdit.addActionListener(carManagementListener);
		panel_2.add(btnEdit);

		btnDelete = new JButton("Delete");
		btnDelete.setForeground(new Color(3, 43, 145));
		btnDelete.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		btnDelete.setBounds(497, 142, 108, 31);
		btnDelete.addActionListener(carManagementListener);
		panel_2.add(btnDelete);

		btnReset = new JButton("Reset");
		btnReset.setForeground(new Color(3, 43, 145));
		btnReset.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		btnReset.setBounds(615, 142, 108, 31);
		btnReset.addActionListener(carManagementListener);
		panel_2.add(btnReset);

		JLabel lblNewLabel_2_3_2 = new JLabel("Cars List");
		lblNewLabel_2_3_2.setForeground(new Color(3, 43, 145));
		lblNewLabel_2_3_2.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblNewLabel_2_3_2.setBounds(446, 209, 76, 28);
		panel_2.add(lblNewLabel_2_3_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setLocation(10, 247);
		scrollPane.setSize(948, 460);
		panel_2.add(scrollPane);
		tableCarList = new JTable();
		scrollPane.setViewportView(tableCarList);
		tableCarList.setRowSelectionAllowed(false);
		String[][] tableData = new String[carManagementModel.getCarList().size()][6];
		int row = 0;
		for (CarModel carModel : carManagementModel.getCarList()) {
			tableData[row][0] = carModel.getRegistrationNum() + "";
			tableData[row][1] = carModel.getCarType().getCarTypeName() + "";
			tableData[row][2] = carModel.getSize() + "";
			tableData[row][3] = carModel.getTonnage() + "";
			tableData[row][4] = carModel.getFuelType().getFuelTypeName() + "";
			tableData[row][5] = carModel.getStatus().getCarStatusName() + "";
			row++;
		}
		tableCarList.setModel(new DefaultTableModel(tableData,
				new String[] { "Registration Number", "Car Type", "Size", "Tonnage", "Fuel Type", "Status" }));
		tableCarList.setForeground(Color.BLACK);
		tableCarList.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		tableCarList.setRowHeight(25);
		tableCarList.setBorder(null);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(192, 192, 192));
		separator.setBounds(10, 194, 944, 1);
		panel_2.add(separator);

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
		lbNotification.setFont(new Font("Century Gothic", Font.BOLD, 13));
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

	public CarManagementModel getCarManagementModel() {
		return carManagementModel;
	}

	public void setCarManagementModel(CarManagementModel carManagementModel) {
		this.carManagementModel = carManagementModel;
	}

	public JLabel getLbNotification() {
		return lbNotification;
	}

	public void setLbNotification(JLabel lbNotification) {
		this.lbNotification = lbNotification;
	}

	public JTable getTableCarList() {
		return tableCarList;
	}

	public void setTableCarList(JTable tableCarList) {
		this.tableCarList = tableCarList;
	}

	public void clearForm() {
		this.textFieldRegistrationNum.setText("");
		this.textFieldSize.setText("");
		this.textFieldTonnage.setText("");
		this.cbCarType.setSelectedIndex(-1);
		this.cbFuelType.setSelectedIndex(-1);
		this.cbStatus.setSelectedIndex(-1);
	}

	public void saveTheCarToModel() {
		String registrationNum = this.textFieldRegistrationNum.getText();
		String size = this.textFieldSize.getText();
		float tonnange = Float.valueOf(this.textFieldTonnage.getText());
		int carTypeID = this.cbCarType.getSelectedIndex() - 1;
		CarType carType = CarType.getCarTypeById(carTypeID);
		int fuelTypeID = this.cbFuelType.getSelectedIndex() - 1;
		FuelType fuelType = FuelType.getFuelTypeById(fuelTypeID);
		int carStatusID = this.cbStatus.getSelectedIndex() - 1;
		CarStatus carStatus = CarStatus.getCarStatusById(carStatusID);

		if (registrationNum == "" || size == "" || this.textFieldTonnage.getText() == ""
				|| carType.getCarTypeName() == "" || fuelType.getFuelTypeName() == ""
				|| carStatus.getCarStatusName() == "") {
			JOptionPane.showMessageDialog(this,
					"Looks like you're leaving the information blank.\n Please add it fully.", "Missing Information",
					JOptionPane.WARNING_MESSAGE);
		}

		if (!this.isValidCarRegistrationNum(registrationNum)) {
			JOptionPane.showMessageDialog(this, "Registration number is invalid.");
			return;
		} else if (tonnange <= 0.0) {
			JOptionPane.showMessageDialog(this, "The tonnage be greater than zero.");
			return;
		} else if ((carType.getCarTypeName().equals("Bus") && fuelType.getFuelTypeName().equals("Gasoline"))
				|| (carType.getCarTypeName().equals("Truck") && fuelType.getFuelTypeName().equals("Electricity"))
				|| (carType.getCarTypeName().equals("Container Truck") && fuelType.getFuelTypeName().equals("Gasoline"))
				|| (carType.getCarTypeName().equals("Container Truck")
						&& fuelType.getFuelTypeName().equals("Electricity"))) {
			JOptionPane.showMessageDialog(this, "Car type and fuel type are incompatible.");
			return;
		}

		CarModel cm = new CarModel(registrationNum, carType, size, tonnange, fuelType, carStatus);
		this.saveOrUpdateTheCar(cm);
	}

	private boolean isValidCarRegistrationNum(String registrationNum) {
		// Kiểm tra độ dài của biển số xe
		if (registrationNum.length() != 10)
			return false;
		// Kiểm tra các ký tự theo vị trí cụ thể
		for (int i = 0; i < registrationNum.length(); i++) {
			char c = registrationNum.charAt(i);
			if (i == 5) {
				if (c != '-')
					return false;
			} else if (i == 0 || i == 1 || i == 6 || i == 7 || i == 8 || i == 9) { // Các vị trí còn lại là số từ 0 đến
																					// 9
				if (!(c >= '0' && c <= '9'))
					return false;
			} else if (i == 2) {
				if (c != 'B')
					return false;
			} else if (i == 3) {
				if (c != 'K')
					return false;
			} else if (i == 4) {
				if (c != 'U')
					return false;
			}
		}
		return true;
	}

	private void saveOrUpdateTheCar(CarModel cm) {
		DefaultTableModel tableModel = (DefaultTableModel) tableCarList.getModel();
		if (!this.carManagementModel.existenceCheck(cm)) {
			this.carManagementModel.save(cm);
			this.saveTheCarToTable(cm);
			this.clearForm();
			this.lbNotification.setText("You just add a new car");
		} else {
			if (checkTheExistenceOfTheCarInTheTrip(cm.getRegistrationNum() + "")) {
				JOptionPane.showMessageDialog(this, "The car is on a trip, the status cannot be modified.");
				return;
			}

			this.carManagementModel.update(cm);
			int numberOfRows = tableModel.getRowCount();
			for (int i = 0; i < numberOfRows; i++) {
				String id = tableModel.getValueAt(i, 0) + "";
				if (id.equals(cm.getRegistrationNum() + "")) {
					tableModel.setValueAt(cm.getRegistrationNum() + "", i, 0);
					tableModel.setValueAt(cm.getCarType().getCarTypeName() + "", i, 1);
					tableModel.setValueAt(cm.getSize() + "", i, 2);
					tableModel.setValueAt(cm.getTonnage() + "", i, 3);
					tableModel.setValueAt(cm.getFuelType().getFuelTypeName() + "", i, 4);
					tableModel.setValueAt(cm.getStatus().getCarStatusName() + "", i, 5);

					Init.tripManagementView.updateTheCarToTableInTripManagement(cm);
				}
			}
			this.clearForm();
			this.lbNotification.setText("You just update the car.");
		}
	}

	private boolean checkTheExistenceOfTheCarInTheTrip(String registrationNum) {
		DefaultTableModel tableModel = (DefaultTableModel) Init.tripManagementView.getTableTripList().getModel();
		int numberOfRows = tableModel.getRowCount();
		for (int i = 0; i < numberOfRows; i++) {
			String id = tableModel.getValueAt(i, 7) + "";
			if (id.equals(registrationNum)) {
				if (tableModel.getValueAt(i, 5).equals("In progress")) {
					return true;
				}
			}
		}
		return false;
	}

	private void saveTheCarToTable(CarModel cm) {
		DefaultTableModel tableModel = (DefaultTableModel) tableCarList.getModel();
		tableModel.addRow(new Object[] { cm.getRegistrationNum() + "", cm.getCarType().getCarTypeName() + "",
				cm.getSize() + "", cm.getTonnage() + "", cm.getFuelType().getFuelTypeName() + "",
				cm.getStatus().getCarStatusName() + "", });
		Init.tripManagementView.saveTheCarToTableInTripManagement(cm);
	}

	public void displaySelectedCarInformation() {
		CarModel cm = getSelectedCarInformation();

		this.textFieldRegistrationNum.setText(cm.getRegistrationNum() + "");
		this.textFieldSize.setText(cm.getSize() + "");
		this.textFieldTonnage.setText(cm.getTonnage() + "");
		this.cbCarType.setSelectedItem(cm.getCarType().getCarTypeName());
		this.cbFuelType.setSelectedItem(cm.getFuelType().getFuelTypeName());
		this.cbStatus.setSelectedItem(cm.getStatus().getCarStatusName());
	}

	private CarModel getSelectedCarInformation() {
		DefaultTableModel tableModel = (DefaultTableModel) tableCarList.getModel();
		int row = tableCarList.getSelectedRow();

		String registrationNum = tableModel.getValueAt(row, 0) + "";
		CarType carType = CarType.getCarTypeByName(tableModel.getValueAt(row, 1) + "");
		String size = tableModel.getValueAt(row, 2) + "";
		float tonnage = Float.valueOf(tableModel.getValueAt(row, 3) + "");
		FuelType fuelType = FuelType.getFuelTypeByName(tableModel.getValueAt(row, 4) + "");
		CarStatus carStatus = CarStatus.getCarStatusByName(tableModel.getValueAt(row, 5) + "");

		CarModel cm = new CarModel(registrationNum, carType, size, tonnage, fuelType, carStatus);
		return cm;
	}

	public void deleteSelectedCar() {
		DefaultTableModel tableModel = (DefaultTableModel) tableCarList.getModel();
		int row = tableCarList.getSelectedRow();
		int choice = JOptionPane.showConfirmDialog(this, "Are you sure to delete the selected row?");
		if (choice == JOptionPane.YES_OPTION) {
			CarModel cm = getSelectedCarInformation();
			this.carManagementModel.delete(cm);
			tableModel.removeRow(row);
			Init.tripManagementView.deleteTheCarToTableInTripManagement(row);
		}
	}

	public void updateTheStatusOfCarIdInCarManagement(TripModel tm, String status) {
		DefaultTableModel tableModel = (DefaultTableModel) tableCarList.getModel();
		int numberOfRows = tableModel.getRowCount();

		for (int i = 0; i < numberOfRows; i++) {
			String id = tm.getCarID() + "";
			if (id.equals(tableModel.getValueAt(i, 0) + "")) {
				String registrationNum = tableModel.getValueAt(i, 0) + "";
				CarType carType = CarType.getCarTypeByName(tableModel.getValueAt(i, 1) + "");
				String size = tableModel.getValueAt(i, 2) + "";
				float tonnage = Float.valueOf(tableModel.getValueAt(i, 3) + "");
				FuelType fuelType = FuelType.getFuelTypeByName(tableModel.getValueAt(i, 4) + "");
				CarStatus carStatus = CarStatus.getCarStatusByName(tableModel.getValueAt(i, 5) + "");
				CarStatus carStatus2 = new CarStatus(carStatus.getCarStatusID(), status);

				CarModel cm = new CarModel(registrationNum, carType, size, tonnage, fuelType, carStatus2);
				UpdateTheCar(cm);
			}
		}
	}

	private void UpdateTheCar(CarModel cm) {
		DefaultTableModel tableModel = (DefaultTableModel) tableCarList.getModel();
		this.carManagementModel.update(cm);
		int numberOfRows = tableModel.getRowCount();
		for (int i = 0; i < numberOfRows; i++) {
			String id = tableModel.getValueAt(i, 0) + "";
			if (id.equals(cm.getRegistrationNum() + "")) {
				tableModel.setValueAt(cm.getRegistrationNum() + "", i, 0);
				tableModel.setValueAt(cm.getCarType().getCarTypeName() + "", i, 1);
				tableModel.setValueAt(cm.getSize() + "", i, 2);
				tableModel.setValueAt(cm.getTonnage() + "", i, 3);
				tableModel.setValueAt(cm.getFuelType().getFuelTypeName() + "", i, 4);
				tableModel.setValueAt(cm.getStatus().getCarStatusName() + "", i, 5);

				Init.tripManagementView.updateTheCarToTableInTripManagement(cm);
			}
		}

	}
}
