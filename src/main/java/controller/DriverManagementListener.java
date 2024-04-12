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
		

	}

	public DriverManagementView getDriverManagementView() {
		return driverManagementView;
	}

	public void setDriverManagementView(DriverManagementView driverManagementView) {
		this.driverManagementView = driverManagementView;
	}

}
