package test;

import javax.swing.UIManager;

import view.CarManagementView;
import view.DriverManagementView;
import view.LoginView;
import view.ProgressView;
import view.StatisticsView;
import view.TripManagementView;

public class Init {

	public static LoginView loginView;
	public static ProgressView progressView;
	public static CarManagementView carManagementView;
	public static DriverManagementView driverManagementView;
	public static TripManagementView tripManagementView;
	public static StatisticsView statisticsView;

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			progressView = new ProgressView();
			progressView.setVisible(true);
			try {
				for (int i = 0; i <= 100; i++) {
					Thread.sleep(25);
					progressView.progressBar.setValue(i);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

			loginView = new LoginView();
			loginView.setVisible(true);
			progressView.dispose();
			while (true) {
				if (loginView.isComfirmed()) {
					loginView.setVisible(false);
					loginView.clearForm();
					break;
				} else {
				}
			}
			if (carManagementView == null) {
				carManagementView = new CarManagementView();
				carManagementView.setVisible(true);
			} else {
				carManagementView.setVisible(true);
			}
			if (driverManagementView == null) {
				driverManagementView = new DriverManagementView();
				driverManagementView.setVisible(false);
			} else {
				driverManagementView.setVisible(true);
			}
			if (tripManagementView == null) {
				tripManagementView = new TripManagementView();
				tripManagementView.setVisible(false);
			} else {
				tripManagementView.setVisible(true);
			}
			if (statisticsView == null) {
				statisticsView = new StatisticsView();
				statisticsView.setVisible(false);

			} else {
				statisticsView.setVisible(true);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
