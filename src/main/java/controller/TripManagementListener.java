package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.TripManagementView;

public class TripManagementListener implements ActionListener {
	private TripManagementView tripManagementView;

	public TripManagementListener(TripManagementView tripManagementView) {
		this.setTripManagementView(tripManagementView);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	public TripManagementView getTripManagementView() {
		return tripManagementView;
	}

	public void setTripManagementView(TripManagementView tripManagementView) {
		this.tripManagementView = tripManagementView;
	}

}
