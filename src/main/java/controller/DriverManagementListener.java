package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.DriverManagementView;

public class DriverManagementListener implements ActionListener {
	private DriverManagementView driverManagementView;

	public DriverManagementListener(DriverManagementView driverManagementView) {
		this.setDriverManagementView(driverManagementView);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();

		if (str.equals("Reset")) {
			this.driverManagementView.clearForm();
			this.driverManagementView.getLbNotification().setText("You just reset the form.");
		} else if (str.equals("Save")) {

			this.driverManagementView.saveTheDriverToModel();

//			JOptionPane.showMessageDialog(driverManagementView,
//					"Looks like you're leaving the information blank.\n Please add it fully.", "Missing Information",
//					JOptionPane.WARNING_MESSAGE);

		} else if (str.equals("Edit")) {
			this.driverManagementView.displaySelectedDriverInformation();
			this.driverManagementView.getLbNotification().setText("You have just selected a car to edit.");
		} else if (str.equals("Delete")) {
			this.driverManagementView.deleteSelectedDriver();
			this.driverManagementView.getLbNotification().setText("You just delete a car.");
		}
	}

	public DriverManagementView getDriverManagementView() {
		return driverManagementView;
	}

	public void setDriverManagementView(DriverManagementView driverManagementView) {
		this.driverManagementView = driverManagementView;
	}

}