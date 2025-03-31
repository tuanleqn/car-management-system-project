package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.DriverManagementView;

public class DriverManagementListener implements ActionListener {
    private DriverManagementView driverManagementView;

    public DriverManagementListener(DriverManagementView driverManagementView) {
        this.driverManagementView = driverManagementView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("Reset")) {
            this.driverManagementView.clearForm();
            this.driverManagementView.getLbNotification().setText("You just reset the form.");
        } else if (command.equals("Save")) {
            try {
                this.driverManagementView.saveTheDriverToModel();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(driverManagementView,
                        "Looks like you're leaving the information blank.\nPlease add it fully.",
                        "Missing Information", JOptionPane.WARNING_MESSAGE);
            }
        } else if (command.equals("Edit")) {
            this.driverManagementView.displaySelectedDriverInformation();
            this.driverManagementView.getLbNotification().setText("You have just selected a driver to edit.");
        } else if (command.equals("Delete")) {
            this.driverManagementView.deleteSelectedDriver();
            this.driverManagementView.getLbNotification().setText("You just deleted a driver.");
        }
    }

    public DriverManagementView getDriverManagementView() {
        return driverManagementView;
    }

    public void setDriverManagementView(DriverManagementView driverManagementView) {
        this.driverManagementView = driverManagementView;
    }
}
