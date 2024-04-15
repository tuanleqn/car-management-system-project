package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.CarManagementView;

public class CarManagementListener implements ActionListener {
	private CarManagementView carManagementView;

	public CarManagementListener(CarManagementView carManagementView) {
		this.setCarManagementView(carManagementView);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();

		if (str.equals("Reset")) {
			this.carManagementView.clearForm();
			this.carManagementView.getLbNotification().setText("You just reset the form.");
		} else if (str.equals("Save")) {
			try {
				this.carManagementView.saveTheCarToModel();
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(carManagementView,
						"Looks like you're leaving the information blank.\n Please add it fully.",
						"Missing Information", JOptionPane.WARNING_MESSAGE);
			}
		} else if (str.equals("Edit")) {
			this.carManagementView.displaySelectedCarInformation();
			this.carManagementView.getLbNotification().setText("You have just selected a vehicle to edit.");
		} else if (str.equals("Delete")) {
			this.carManagementView.deleteSelectedCar();
			this.carManagementView.getLbNotification().setText("You just delete a car.");
		}
	}

	public CarManagementView getCarManagementView() {
		return carManagementView;
	}

	public void setCarManagementView(CarManagementView carManagementView) {
		this.carManagementView = carManagementView;
	}
}
