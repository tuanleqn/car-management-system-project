package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.CarManagementView;

public class CarManagementListener implements ActionListener {
	private CarManagementView carManagementView;

	public CarManagementListener(CarManagementView carManagementView) {
		this.setCarManagementView(carManagementView);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	public CarManagementView getCarManagementView() {
		return carManagementView;
	}

	public void setCarManagementView(CarManagementView carManagementView) {
		this.carManagementView = carManagementView;
	}
}
