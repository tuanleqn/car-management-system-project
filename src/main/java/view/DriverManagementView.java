package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

<<<<<<< HEAD
=======
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
>>>>>>> 9b91f8d6c6e8b3576918f233226d8e4f8a14c242
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

import controller.DriverManagementListener;
import model.DriverManagementModel;
import model.DriverModel;
import model.DriverStatus;
<<<<<<< HEAD
import model.TripModel;
=======
>>>>>>> 9b91f8d6c6e8b3576918f233226d8e4f8a14c242
import test.Init;
public class DriverManagementView extends JFrame {

<<<<<<< HEAD
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
	private JComboBox<String> comboBoxStatus;
	private JButton btnSave;
	private JButton btnEdit;
	private JButton btnDelete;
	private JButton btnReset;
	private JLabel lbNotification;
	private DriverManagementModel driverManagementModel;
=======
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
    private JComboBox<String> comboBoxStatus;
    private JButton btnSave;
    private JButton btnEdit;
    private JButton btnDelete;
    private JButton btnReset;
    private JLabel lbNotification;
>>>>>>> 9b91f8d6c6e8b3576918f233226d8e4f8a14c242

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

<<<<<<< HEAD
	/**
	 * Create the frame.
	 */
	public DriverManagementView() {
		driverManagementModel = new DriverManagementModel();
		driverManagementModel.get();
		
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(CarManagementView.class.getResource("/view/01_logobachkhoasang.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1224, 806);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
=======
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
>>>>>>> 9b91f8d6c6e8b3576918f233226d8e4f8a14c242

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

<<<<<<< HEAD
		lbLogout = new JLabel("Logout");
		lbLogout.setHorizontalAlignment(SwingConstants.CENTER);
		lbLogout.setForeground(Color.WHITE);
		lbLogout.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lbLogout.setBounds(87, 715, 66, 26);
		lbLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int choice = JOptionPane.showConfirmDialog(Init.driverManagementView, "Are you sure to logout?");
				if (choice == JOptionPane.YES_OPTION) {
					Init.loginView.setVisible(true);
					setVisible(false);
				}
			}
		});
		panel.add(lbLogout);
=======
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
>>>>>>> 9b91f8d6c6e8b3576918f233226d8e4f8a14c242

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

<<<<<<< HEAD
		textFieldDriverID = new JTextField();
		textFieldDriverID.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lbNotification.setText("Driver ID has the format \"DID-...\", with natural numbers after the dash");
			}
		});
		textFieldDriverID.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		textFieldDriverID.setBounds(10, 89, 134, 28);
		textFieldDriverID.setColumns(10);
		panel_2.add(textFieldDriverID);

		textFieldPhone = new JTextField();
		textFieldPhone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lbNotification
						.setText("Phone includes 10 numbers, and starts with \"03\" or \"05\" or \"07\" or \"09\".");
			}
		});
		textFieldPhone.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		textFieldPhone.setColumns(10);
		textFieldPhone.setBounds(334, 89, 134, 28);
		panel_2.add(textFieldPhone);

		textFieldAddress = new JTextField();
		textFieldAddress.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lbNotification.setText("");
			}
		});
		textFieldAddress.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		textFieldAddress.setColumns(10);
		textFieldAddress.setBounds(496, 89, 134, 28);
		panel_2.add(textFieldAddress);

		comboBoxStatus = new JComboBox<String>();
		ArrayList<DriverStatus> driverStatusList = DriverStatus.getDriverStatusList();
		comboBoxStatus.addItem("");
		for (DriverStatus driverStatus : driverStatusList) {
			comboBoxStatus.addItem(driverStatus.getDriverStatusName());
		}
		comboBoxStatus.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		comboBoxStatus.setBounds(820, 89, 134, 28);
		comboBoxStatus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lbNotification.setText("");
			}
		});
		panel_2.add(comboBoxStatus);
=======
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
>>>>>>> 9b91f8d6c6e8b3576918f233226d8e4f8a14c242

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

<<<<<<< HEAD
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setLocation(10, 247);
		scrollPane.setSize(948, 460);
		panel_2.add(scrollPane);
		tableDriverList = new JTable();
		scrollPane.setViewportView(tableDriverList);
		tableDriverList.setRowSelectionAllowed(false);
		String[][] tableData = new String[driverManagementModel.getDriverList().size()][6]; 
		int row = 0;
		for (DriverModel driverModel : driverManagementModel.getDriverList()) {			
			tableData[row][0] = driverModel.getDriverID() + "";
			tableData[row][1] = driverModel.getFullName() + "";
			tableData[row][2] = driverModel.getPhone() + "";
			tableData[row][3] = driverModel.getAddress() + "";
			tableData[row][4] = driverModel.getDLNumber() + "";
			tableData[row][5] = driverModel.getStatus().getDriverStatusName() + "";
			row++; 
		}
		tableDriverList.setModel(new DefaultTableModel(tableData,
				new String[] { "Driver ID", "Full Name", "Phone", "Address", "Driver's License Number", "Status" }));
		tableDriverList.setForeground(Color.BLACK);
		tableDriverList.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		tableDriverList.setRowHeight(25);
		tableDriverList.setBorder(null);
=======
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
>>>>>>> 9b91f8d6c6e8b3576918f233226d8e4f8a14c242

        JSeparator separator = new JSeparator();
        separator.setForeground(new Color(192, 192, 192));
        separator.setBounds(10, 194, 944, 1);
        panel_2.add(separator);

<<<<<<< HEAD
		textFieldFullName = new JTextField();
		textFieldFullName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lbNotification.setText("");
			}
		});
		textFieldFullName.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		textFieldFullName.setColumns(10);
		textFieldFullName.setBounds(172, 89, 134, 28);
		panel_2.add(textFieldFullName);

		textFieldDLNumber = new JTextField();
		textFieldDLNumber.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lbNotification.setText("DL Number includes 12 numbers and starts with \"0\".");
			}
		});
		textFieldDLNumber.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		textFieldDLNumber.setColumns(10);
		textFieldDLNumber.setBounds(658, 89, 134, 28);
		panel_2.add(textFieldDLNumber);
=======
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
>>>>>>> 9b91f8d6c6e8b3576918f233226d8e4f8a14c242

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
    public DriverManagementModel getDriverManagementModel() {
        return driverManagementModel;
    }

    public void setDriverManagementModel(DriverManagementModel driverManagementModel) {
        this.driveManagementModel = driverManagementModel;
    }

    public JLabel getLbNotification() {
        return lbNotification;
    }

    public void setLbNotification(JLabel lbNotification) {
        this.lbNotification = lbNotification;
    }

    public void clearForm() {
        this.textFieldDriverID.setText("");
        this.textFieldPhone.setText("");
        this.textFieldAddress.setText("");
        this.textFieldFullName.setText("");
        this.textFieldDLNumber.setText("");
        this.comboBoxStatus.setSelectedIndex(-1);
    }

    public void saveTheCarToModel() {
        String DriverID = this.textFieldDriverID.getText();
        String FullName = this.textFieldFullName.getText();
        String Phone = this.textFieldPhone.getText();
        String Address = this.textFieldAddress.getText();
        String DLNumber = this.textFieldDLNumber.getText();
        int driverStatusID = this.comboBoxStatus.getSelectedIndex() - 1;
        DriverStatus driverStatus = DriverStatus.getDriverStatusById(driverStatusID);

        if (!this.isValidDriverID(DriverID)) {
            JOptionPane.showMessageDialog(this, "DriverID is invalid.");
            return;
        } else if (!this.isValidPhone(Phone)){
            JOptionPane.showMessageDialog(this, "Phone is invalid.");
            return;
        }else if (!this.isValidDLNumber(DLNumber)){
            JOptionPane.showMessageDialog(this, "Driver's License is invalid.");
            return;
        }

        DriverModel dm = new DriverModel(DriverID, FullName,Phone, Address,DLNumber, driverStatus);
        this.saveOrUpdateTheDriver(dm);
    }
    private boolean isValidDriverID(String DriverID){
        //Kiem tra ID cua tai xe
        if (DriverID.length() != 5) return false;
        return true;
    }
    private boolean isValidPhone(String Phone) {
        if (Phone.length() != 10) return false;
        String[] Dauso = {"03", "05", "07", "08","09"};
        boolean kt = false;
        for (String prefix : Dauso) {
            if (Phone.startsWith(prefix)) {
                kt = true;
                break;
            }
        }

        return kt;
    }
    private boolean isValidDLNumber(String DLNumber) {
        if (DLNumber.length() != 12) return false;
        if (!DLNumber.startsWith("0")) return false;
        return true;
    }
    private void saveOrUpdateTheDriver(DriverModel dm) {
        DefaultTableModel tableModel = (DefaultTableModel) tableDriverList.getModel();
        if (!this.driverManagementModel.existenceCheck(dm)) {
            this.driverManagementModel.save(dm);
            this.saveTheDriverToTable(dm);
            this.clearForm();
            this.lbNotification.setText("You just add a new driver");
        } else {
            this.driverManagementModel.update(dm);
            int numberOfRows = tableModel.getRowCount();
            for (int i = 0; i < numberOfRows; i++) {
                String id = tableModel.getValueAt(i, 0) + "";
                if (id.equals(dm.getDriverID() + "")) {
                    tableModel.setValueAt(dm.getDriverID() + "", i, 0);
                    tableModel.setValueAt(dm.getFullName + "", i, 1);
                    tableModel.setValueAt(dm.getPhone() + "", i, 2);
                    tableModel.setValueAt(dm.getAddress() + "", i, 3);
                    tableModel.setValueAt(dm.getDLNUmber() + "", i, 4);
                    tableModel.setValueAt(dm.getStatus().getDriverStatusName() + "", i, 5);
                }
            }
            this.clearForm();
            this.lbNotification.setText("You just update the driver.");
        }
    }

    private void saveTheDriverToTable(DriverModel dm) {
        DefaultTableModel tableModel = (DefaultTableModel) tableDriverList.getModel();
        tableModel.addRow(new Object[] { dm.getDriverID() + "", dm.getFullName() + "",
                dm.getPhone() + "", dm.getAddress() + "", dm.getDLNUmber() + "",
                dm.getStatus().getDriverStatusName() + "", });
    }

    public void displaySelectedDriverInformation() {
        DriverModel dm = getSelectedDriverInformation();

        this.textFieldDriverID.setText(dm.getDriverID() + "");
        this.textFieldFullName.setText(dm.getFullName() + "");
        this.textFieldPhone.setText(dm.getPhone() + "");
        this.textFieldAddress.setText(dm.getAddress() + "");
        this.textFieldDLNumber.setText(dm.getDLNumber() + "");
        this.comboBoxStatus.setSelectedItem(dm.getStatus().getDriverStatusName());
    }

    private DriverModel getSelectedDriverInformation() {
        DefaultTableModel tableModel = (DefaultTableModel) tableDriverList.getModel();
        int row = tableDriverList.getSelectedRow();

        String DriverID = tableModel.getValueAt(row, 0) + "";
        String FullName = tableModel.getValueAt(row, 1) + "";
        String Phone = tableModel.getValueAt(row, 2) + "";
        String Address = tableModel.getValueAt(row, 3) + "";
        String DLNumber = tableModel.getValueAt(row, 4) + "";
        DriverStatus driverStatus = DriverStatus.getDriverStatusByName(tableModel.getValueAt(row, 5) + "");

        DriverModel dm = new DriverModel(DriverID,FullName,Phone,Address,DLNumber,driverStatus);
        return dm;
    }

    public void deleteSelectedDriver() {
        DefaultTableModel tableModel = (DefaultTableModel) tableDriverList.getModel();
        int row = tableDriverList.getSelectedRow();
        int choice = JOptionPane.showConfirmDialog(this, "Are you sure to delete the selected row?");
        if (choice == JOptionPane.YES_OPTION) {
            DriverModel dm = getSelectedDriverInformation();
            this.driverManagementModel.delete(dm);
            tableModel.removeRow(row);
        }
    }


	public DriverManagementModel getDriverManagementModel() {
		return driverManagementModel;
	}

	public void setDriverManagementModel(DriverManagementModel driverManagementModel) {
		this.driverManagementModel = driverManagementModel;
	}

	public JLabel getLbNotification() {
		return lbNotification;
	}

	public void setLbNotification(JLabel lbNotification) {
		this.lbNotification = lbNotification;
	}

	public void clearForm() {
		this.textFieldDriverID.setText("");
		this.textFieldPhone.setText("");
		this.textFieldAddress.setText("");
		this.textFieldFullName.setText("");
		this.textFieldDLNumber.setText("");
		this.comboBoxStatus.setSelectedIndex(-1);
	}

	public void saveTheDriverToModel() {
		String DriverID = this.textFieldDriverID.getText();
		String FullName = this.textFieldFullName.getText();
		String Phone = this.textFieldPhone.getText();
		String Address = this.textFieldAddress.getText();
		String DLNumber = this.textFieldDLNumber.getText();
		int driverStatusID = this.comboBoxStatus.getSelectedIndex() - 1;
		DriverStatus driverStatus = DriverStatus.getDriverStatusById(driverStatusID);

		if (DriverID == "" || FullName == "" || Phone == "" || Address == "" || DLNumber == ""
				|| driverStatus.getDriverStatusName() == "") {
			JOptionPane.showMessageDialog(this,
					"Looks like you're leaving the information blank.\n Please add it fully.", "Missing Information",
					JOptionPane.WARNING_MESSAGE);
		}

		if (!this.isValidDriverID(DriverID)) {
			JOptionPane.showMessageDialog(this, "DriverID is invalid.");
			return;
		} else if (!this.isValidPhone(Phone)) {
			JOptionPane.showMessageDialog(this, "Phone is invalid.");
			return;
		} else if (!this.isValidDLNumber(DLNumber)) {
			JOptionPane.showMessageDialog(this, "Driver's License is invalid.");
			return;
		}

		DriverModel dm = new DriverModel(DriverID, FullName, Phone, Address, DLNumber, driverStatus);
//		System.out.println(dm.toString());
		this.saveOrUpdateTheDriver(dm);
	}

	private boolean isValidDriverID(String DriverID) {
		// Kiem tra ID cua tai xe
		if (DriverID.length() < 5) {
//			System.out.println("1");
			return false;

		}
		if (!((DriverID.substring(0, 4)).equals("DID-"))) {
			System.out.println(DriverID.substring(0, 3));
			return false;

		}
		for (int i = 4; i < DriverID.length(); i++) {
			char c = DriverID.charAt(i);
			if (!(c >= '0' && c <= '9')) {
				return false;
			}
		}

		return true;
	}

	private boolean isValidPhone(String Phone) {
		if (Phone.length() != 10)
			return false;
		String[] Dauso = { "03", "05", "07", "08", "09" };
		boolean kt = false;
		for (String prefix : Dauso) {
			if (Phone.startsWith(prefix)) {
				kt = true;
				break;
			}
		}

		return kt;
	}

	private boolean isValidDLNumber(String DLNumber) {
		if (DLNumber.length() != 12)
			return false;
		if (!DLNumber.startsWith("0"))
			return false;
		return true;
	}

	private void saveOrUpdateTheDriver(DriverModel dm) {
		DefaultTableModel tableModel = (DefaultTableModel) tableDriverList.getModel();
		if (!this.driverManagementModel.existenceCheck(dm)) {
			this.driverManagementModel.save(dm);
			this.saveTheDriverToTable(dm);
			this.clearForm();
			this.lbNotification.setText("You just add a new driver");
		} else {
			if (checkTheExistenceOfThedriverInTheTrip(dm.getDriverID() + "")) {
				JOptionPane.showMessageDialog(this, "The driver is on a trip, the status cannot be modified.");
				return;
			}

			this.driverManagementModel.update(dm);
			int numberOfRows = tableModel.getRowCount();
			for (int i = 0; i < numberOfRows; i++) {
				String id = tableModel.getValueAt(i, 0) + "";
				if (id.equals(dm.getDriverID() + "")) {
					tableModel.setValueAt(dm.getDriverID() + "", i, 0);
					tableModel.setValueAt(dm.getFullName() + "", i, 1);
					tableModel.setValueAt(dm.getPhone() + "", i, 2);
					tableModel.setValueAt(dm.getAddress() + "", i, 3);
					tableModel.setValueAt(dm.getDLNumber() + "", i, 4);
					tableModel.setValueAt(dm.getStatus().getDriverStatusName() + "", i, 5);

					Init.tripManagementView.updateTheDriverToTableInTripManagement(dm);
				}
			}
			this.clearForm();
			this.lbNotification.setText("You just update the driver.");
		}
	}

	private boolean checkTheExistenceOfThedriverInTheTrip(String driverID) {
		DefaultTableModel tableModel = (DefaultTableModel) Init.tripManagementView.getTableTripList().getModel();
		int numberOfRows = tableModel.getRowCount();
		for (int i = 0; i < numberOfRows; i++) {
			String id = tableModel.getValueAt(i, 6) + "";
			if (id.equals(driverID)) {
				if (tableModel.getValueAt(i, 5).equals("In progress")) {
					return true;
				}
			}
		}
		return false;
	}

	private void saveTheDriverToTable(DriverModel dm) {
		DefaultTableModel tableModel = (DefaultTableModel) tableDriverList.getModel();
		tableModel.addRow(new Object[] { dm.getDriverID() + "", dm.getFullName() + "", dm.getPhone() + "",
				dm.getAddress() + "", dm.getDLNumber() + "", dm.getStatus().getDriverStatusName() + "", });
		Init.tripManagementView.saveTheTripToTableInTripManagement(dm);
	}

	public void displaySelectedDriverInformation() {
		DriverModel dm = getSelectedDriverInformation();

		this.textFieldDriverID.setText(dm.getDriverID() + "");
		this.textFieldFullName.setText(dm.getFullName() + "");
		this.textFieldPhone.setText(dm.getPhone() + "");
		this.textFieldAddress.setText(dm.getAddress() + "");
		this.textFieldDLNumber.setText(dm.getDLNumber() + "");
		this.comboBoxStatus.setSelectedItem(dm.getStatus().getDriverStatusName());
	}

	private DriverModel getSelectedDriverInformation() {
		DefaultTableModel tableModel = (DefaultTableModel) tableDriverList.getModel();
		int row = tableDriverList.getSelectedRow();

		String DriverID = tableModel.getValueAt(row, 0) + "";
		String FullName = tableModel.getValueAt(row, 1) + "";
		String Phone = tableModel.getValueAt(row, 2) + "";
		String Address = tableModel.getValueAt(row, 3) + "";
		String DLNumber = tableModel.getValueAt(row, 4) + "";
		DriverStatus driverStatus = DriverStatus.getDriverStatusByName(tableModel.getValueAt(row, 5) + "");

		DriverModel dm = new DriverModel(DriverID, FullName, Phone, Address, DLNumber, driverStatus);
		return dm;
	}

	public void deleteSelectedDriver() {
		DefaultTableModel tableModel = (DefaultTableModel) tableDriverList.getModel();
		int row = tableDriverList.getSelectedRow();
		int choice = JOptionPane.showConfirmDialog(this, "Are you sure to delete the selected row?");
		if (choice == JOptionPane.YES_OPTION) {
			DriverModel dm = getSelectedDriverInformation();
			this.driverManagementModel.delete(dm);
			tableModel.removeRow(row);
			Init.tripManagementView.deleteTheDriverToTableInTripManagement(row);
		}
	}

	public void updateTheStatusOfDriverIdInDriverManagement(TripModel tm, String status) {
		DefaultTableModel tableModel = (DefaultTableModel) tableDriverList.getModel();
		int numberOfRows = tableModel.getRowCount();

		for (int i = 0; i < numberOfRows; i++) {
			String id = tm.getDriverID() + "";
			if (id.equals(tableModel.getValueAt(i, 0) + "")) {
				String driverID = tableModel.getValueAt(i, 0) + "";
				String fullName = tableModel.getValueAt(i, 1) + "";
				String phone = tableModel.getValueAt(i, 2) + "";
				String address = tableModel.getValueAt(i, 3) + "";
				String dlNumber = tableModel.getValueAt(i, 4) + "";
				DriverStatus driverStatus = DriverStatus.getDriverStatusByName(tableModel.getValueAt(i, 5) + "");
				DriverStatus driverStatus2 = new DriverStatus(driverStatus.getDriverStatusID(), status);

				DriverModel dm = new DriverModel(driverID, fullName, phone, address, dlNumber, driverStatus2);
				UpdateTheDriver(dm);
			}
		}
	}

	private void UpdateTheDriver(DriverModel dm) {
		DefaultTableModel tableModel = (DefaultTableModel) tableDriverList.getModel();
		this.driverManagementModel.update(dm);
		int numberOfRows = tableModel.getRowCount();
		for (int i = 0; i < numberOfRows; i++) {
			String id = tableModel.getValueAt(i, 0) + "";
			if (id.equals(dm.getDriverID() + "")) {
				tableModel.setValueAt(dm.getDriverID() + "", i, 0);
				tableModel.setValueAt(dm.getFullName() + "", i, 1);
				tableModel.setValueAt(dm.getPhone() + "", i, 2);
				tableModel.setValueAt(dm.getAddress() + "", i, 3);
				tableModel.setValueAt(dm.getDLNumber() + "", i, 4);
				tableModel.setValueAt(dm.getStatus().getDriverStatusName() + "", i, 5);

				Init.tripManagementView.updateTheDriverToTableInTripManagement(dm);
			}
		}

	}

}