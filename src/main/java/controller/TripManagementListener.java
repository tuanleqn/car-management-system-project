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
		String str = e.getActionCommand();

		if (str.equals("Reset")) {
			this.tripManagementView.clearForm();
			this.tripManagementView.getLbNotification().setText("You just reset the form.");
		} else if (str.equals("Save")) {

			this.tripManagementView.saveTheTripToModel();

//			JOptionPane.showMessageDialog(tripManagementView,
//					"Looks like you're leaving the information blank.\n Please add it fully.", "Missing Information",
//					JOptionPane.WARNING_MESSAGE);

		} else if (str.equals("Edit")) {
			this.tripManagementView.displaySelectedTripInformation();
			this.tripManagementView.getLbNotification().setText("You have just selected a trip to edit.");
		} else if (str.equals("Delete")) {
			this.tripManagementView.deleteSelectedTrip();
			this.tripManagementView.getLbNotification().setText("You just delete a trip.");
		}
	}

	public TripManagementView getTripManagementView() {
		return tripManagementView;
	}

	public void setTripManagementView(TripManagementView tripManagementView) {
		this.tripManagementView = tripManagementView;
	}

}
