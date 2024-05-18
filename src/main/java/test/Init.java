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
					Thread.sleep(15);
					progressView.progressBar.setValue(i);
				}
			} catch (Exception e) {
				System.exit(1);
			}
			progressView.dispose();

			carManagementView = new CarManagementView();
			carManagementView.setVisible(false);

			driverManagementView = new DriverManagementView();
			driverManagementView.setVisible(false);

			tripManagementView = new TripManagementView();
			tripManagementView.setVisible(false);

			statisticsView = new StatisticsView();
			statisticsView.setVisible(false);

			loginView = new LoginView();
			loginView.setVisible(true);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
