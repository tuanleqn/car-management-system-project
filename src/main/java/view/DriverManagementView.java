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
import model.TripModel;
import test.Init;

public class DriverManagementView extends JFrame {

    private DriverManagementModel driverManagementModel;
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
        // Initialize the model
        driverManagementModel = new DriverManagementModel();
        // Optionally, load existing data:
        // driverManagementModel.get();

        // Use DriverManagementView.class instead of CarManagementView for the icon
        setIconImage(Toolkit.getDefaultToolkit()
                .getImage(DriverManagementView.class.getResource("/view/01_logobachkhoasang.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1224, 806);
        this.setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        DriverManagementListener driverManagementListener = new DriverManagementListener(this);

        // Left panel with navigation labels
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

        JLabel lblIcon = new JLabel("");
        lblIcon.setIcon(
                new ImageIcon(DriverManagementView.class.getResource("/view/Graphicloads-Transport-Car-5.72.png")));
        lblIcon.setHorizontalAlignment(SwingConstants.CENTER);
        lblIcon.setBounds(84, 41, 72, 72);
        panel.add(lblIcon);

        // Top panel
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 255, 255));
        panel_1.setBounds(242, 0, 968, 25);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        // Main panel
        JPanel panel_2 = new JPanel();
        panel_2.setBounds(242, 27, 968, 717);
        contentPane.add(panel_2);
        panel_2.setLayout(null);

        JLabel lblTitle = new JLabel("Manage Drivers");
        lblTitle.setBounds(399, 10, 170, 28);
        lblTitle.setForeground(new Color(3, 43, 145));
        lblTitle.setFont(new Font("Century Gothic", Font.BOLD, 22));
        panel_2.add(lblTitle);

        JLabel lblDriverID = new JLabel("Driver ID");
        lblDriverID.setBounds(10, 58, 134, 21);
        lblDriverID.setForeground(new Color(3, 43, 145));
        lblDriverID.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        panel_2.add(lblDriverID);

        JLabel lblFullName = new JLabel("Full Name");
        lblFullName.setBounds(172, 58, 134, 21);
        lblFullName.setForeground(new Color(3, 43, 145));
        lblFullName.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        panel_2.add(lblFullName);

        JLabel lblPhone = new JLabel("Phone");
        lblPhone.setBounds(334, 58, 134, 21);
        lblPhone.setForeground(new Color(3, 43, 145));
        lblPhone.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        panel_2.add(lblPhone);

        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(496, 58, 134, 21);
        lblAddress.setForeground(new Color(3, 43, 145));
        lblAddress.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        panel_2.add(lblAddress);

        JLabel lblDLNumber = new JLabel("DL Number");
        lblDLNumber.setBounds(658, 58, 134, 21);
        lblDLNumber.setForeground(new Color(3, 43, 145));
        lblDLNumber.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        panel_2.add(lblDLNumber);

        JLabel lblStatus = new JLabel("Status ");
        lblStatus.setBounds(820, 58, 134, 21);
        lblStatus.setForeground(new Color(3, 43, 145));
        lblStatus.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        panel_2.add(lblStatus);

        textFieldDriverID = new JTextField();
        textFieldDriverID.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        textFieldDriverID.setBounds(10, 89, 134, 28);
        textFieldDriverID.setColumns(10);
        panel_2.add(textFieldDriverID);

        textFieldFullName = new JTextField();
        textFieldFullName.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        textFieldFullName.setColumns(10);
        textFieldFullName.setBounds(172, 89, 134, 28);
        panel_2.add(textFieldFullName);

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

        textFieldDLNumber = new JTextField();
        textFieldDLNumber.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        textFieldDLNumber.setColumns(10);
        textFieldDLNumber.setBounds(658, 89, 134, 28);
        panel_2.add(textFieldDLNumber);

        comboBoxStatus = new JComboBox<String>();
        comboBoxStatus.setModel(new DefaultComboBoxModel<String>(new String[] { "", "Available", "Unavailable" }));
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

        JLabel lblDriverList = new JLabel("Driver List");
        lblDriverList.setForeground(new Color(3, 43, 145));
        lblDriverList.setFont(new Font("Century Gothic", Font.BOLD, 18));
        lblDriverList.setBounds(443, 209, 82, 23);
        panel_2.add(lblDriverList);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setLocation(10, 247);
        scrollPane.setSize(948, 460);
        panel_2.add(scrollPane);
        tableDriverList = new JTable();
        scrollPane.setViewportView(tableDriverList);
        tableDriverList.setRowSelectionAllowed(false);
        tableDriverList.setModel(new DefaultTableModel(
            new Object[][] { { null, null, null, null, null, null }, },
            new String[] { "Driver ID", "Full Name", "Phone", "Address", "Driver's License Number", "Status" }
        ));
        tableDriverList.setForeground(Color.BLACK);
        tableDriverList.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        tableDriverList.setRowHeight(25);
        tableDriverList.setBorder(null);

        JSeparator separator = new JSeparator();
        separator.setForeground(new Color(192, 192, 192));
        separator.setBounds(10, 194, 944, 1);
        panel_2.add(separator);

        JPanel panel_1_1 = new JPanel();
        panel_1_1.setLayout(null);
        panel_1_1.setBackground(Color.WHITE);
        panel_1_1.setBounds(242, 744, 968, 25);
        contentPane.add(panel_1_1);

        JLabel lblNotificationTitle = new JLabel("Notification: ");
        lblNotificationTitle.setForeground(new Color(3, 43, 145));
        lblNotificationTitle.setFont(new Font("Century Gothic", Font.BOLD, 14));
        lblNotificationTitle.setBounds(10, 0, 87, 23);
        panel_1_1.add(lblNotificationTitle);

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

        if (DriverID.equals("") || FullName.equals("") || Phone.equals("") || Address.equals("") || DLNumber.equals("")
                || driverStatus == null || driverStatus.getDriverStatusName().equals("")) {
            JOptionPane.showMessageDialog(this,
                    "Looks like you're leaving the information blank.\nPlease add it fully.", "Missing Information",
                    JOptionPane.WARNING_MESSAGE);
            return;
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
        this.saveOrUpdateTheDriver(dm);
    }

    private boolean isValidDriverID(String DriverID) {
        // Check driver ID format: should start with "DID-" and be at least 5 characters long
        if (DriverID.length() < 5) {
            return false;
        }
        if (!DriverID.startsWith("DID-")) {
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
        String[] prefixes = { "03", "05", "07", "08", "09" };
        for (String prefix : prefixes) {
            if (Phone.startsWith(prefix)) {
                return true;
            }
        }
        return false;
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
            this.lbNotification.setText("You just added a new driver.");
        } else {
            if (checkTheExistenceOfThedriverInTheTrip(dm.getDriverID())) {
                JOptionPane.showMessageDialog(this, "The driver is on a trip, the status cannot be modified.");
                return;
            }
            this.driverManagementModel.update(dm);
            int numberOfRows = tableModel.getRowCount();
            for (int i = 0; i < numberOfRows; i++) {
                String id = tableModel.getValueAt(i, 0).toString();
                if (id.equals(dm.getDriverID())) {
                    tableModel.setValueAt(dm.getDriverID(), i, 0);
                    tableModel.setValueAt(dm.getFullName(), i, 1);
                    tableModel.setValueAt(dm.getPhone(), i, 2);
                    tableModel.setValueAt(dm.getAddress(), i, 3);
                    tableModel.setValueAt(dm.getDLNumber(), i, 4);
                    tableModel.setValueAt(dm.getStatus().getDriverStatusName(), i, 5);
                    Init.tripManagementView.updateTheDriverToTableInTripManagement(dm);
                }
            }
            this.clearForm();
            this.lbNotification.setText("You just updated the driver.");
        }
    }

    private boolean checkTheExistenceOfThedriverInTheTrip(String driverID) {
        DefaultTableModel tableModel = (DefaultTableModel) Init.tripManagementView.getTableTripList().getModel();
        int numberOfRows = tableModel.getRowCount();
        for (int i = 0; i < numberOfRows; i++) {
            String id = tableModel.getValueAt(i, 6).toString();
            if (id.equals(driverID)) {
                if (tableModel.getValueAt(i, 5).toString().equals("In progress")) {
                    return true;
                }
            }
        }
        return false;
    }

    private void saveTheDriverToTable(DriverModel dm) {
        DefaultTableModel tableModel = (DefaultTableModel) tableDriverList.getModel();
        tableModel.addRow(new Object[] { dm.getDriverID(), dm.getFullName(), dm.getPhone(),
                dm.getAddress(), dm.getDLNumber(), dm.getStatus().getDriverStatusName() });
        Init.tripManagementView.saveTheTripToTableInTripManagement(dm);
    }

    public void displaySelectedDriverInformation() {
        DriverModel dm = getSelectedDriverInformation();
        this.textFieldDriverID.setText(dm.getDriverID());
        this.textFieldFullName.setText(dm.getFullName());
        this.textFieldPhone.setText(dm.getPhone());
        this.textFieldAddress.setText(dm.getAddress());
        this.textFieldDLNumber.setText(dm.getDLNumber());
        this.comboBoxStatus.setSelectedItem(dm.getStatus().getDriverStatusName());
    }

    private DriverModel getSelectedDriverInformation() {
        DefaultTableModel tableModel = (DefaultTableModel) tableDriverList.getModel();
        int row = tableDriverList.getSelectedRow();
        String DriverID = tableModel.getValueAt(row, 0).toString();
        String FullName = tableModel.getValueAt(row, 1).toString();
        String Phone = tableModel.getValueAt(row, 2).toString();
        String Address = tableModel.getValueAt(row, 3).toString();
        String DLNumber = tableModel.getValueAt(row, 4).toString();
        DriverStatus driverStatus = DriverStatus.getDriverStatusByName(tableModel.getValueAt(row, 5).toString());
        return new DriverModel(DriverID, FullName, Phone, Address, DLNumber, driverStatus);
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
            String id = tm.getDriverID();
            if (id.equals(tableModel.getValueAt(i, 0).toString())) {
                String driverID = tableModel.getValueAt(i, 0).toString();
                String fullName = tableModel.getValueAt(i, 1).toString();
                String phone = tableModel.getValueAt(i, 2).toString();
                String address = tableModel.getValueAt(i, 3).toString();
                String dlNumber = tableModel.getValueAt(i, 4).toString();
                DriverStatus currentStatus = DriverStatus.getDriverStatusByName(tableModel.getValueAt(i, 5).toString());
                DriverStatus newStatus = new DriverStatus(currentStatus.getDriverStatusID(), status);
                DriverModel dm = new DriverModel(driverID, fullName, phone, address, dlNumber, newStatus);
                updateTheDriver(dm);
            }
        }
    }

    private void updateTheDriver(DriverModel dm) {
        DefaultTableModel tableModel = (DefaultTableModel) tableDriverList.getModel();
        this.driverManagementModel.update(dm);
        int numberOfRows = tableModel.getRowCount();
        for (int i = 0; i < numberOfRows; i++) {
            String id = tableModel.getValueAt(i, 0).toString();
            if (id.equals(dm.getDriverID())) {
                tableModel.setValueAt(dm.getDriverID(), i, 0);
                tableModel.setValueAt(dm.getFullName(), i, 1);
                tableModel.setValueAt(dm.getPhone(), i, 2);
                tableModel.setValueAt(dm.getAddress(), i, 3);
                tableModel.setValueAt(dm.getDLNumber(), i, 4);
                tableModel.setValueAt(dm.getStatus().getDriverStatusName(), i, 5);
                Init.tripManagementView.updateTheDriverToTableInTripManagement(dm);
            }
        }
    }
}
