package model;

import java.util.ArrayList;
import java.util.Objects;

public class CarStatus {
	private int carStatusID;
	private String carStatusName;

	public CarStatus() {

	}

	public CarStatus(int carStatusID, String carStatusName) {
		this.carStatusID = carStatusID;
		this.carStatusName = carStatusName;
	}

	public int getCarStatusID() {
		return carStatusID;
	}

	public void setCarStatusID(int carStatusID) {
		this.carStatusID = carStatusID;
	}

	public String getCarStatusName() {
		return carStatusName;
	}

	public void setCarStatusName(String carStatusName) {
		this.carStatusName = carStatusName;
	}

	@Override
	public String toString() {
		return "CarStatus [carStatusID=" + carStatusID + ", carStatusName=" + carStatusName + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(carStatusID, carStatusName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarStatus other = (CarStatus) obj;
		return carStatusID == other.carStatusID && Objects.equals(carStatusName, other.carStatusName);
	}
	public static ArrayList<CarStatus> getCarStatusList() {
		String[] carStatusArray = { "Active", "Inactive", "Maintenance" };
		ArrayList<CarStatus> carStatusList = new ArrayList<CarStatus>();
		int id = 0;
		for (String carStatus : carStatusArray) {
			CarStatus cs = new CarStatus(id, carStatus);
			carStatusList.add(cs);
		}
		return carStatusList;
	}

	public static CarStatus getCarStatusById(int id) {
		return CarStatus.getCarStatusList().get(id);
	}

	public static CarStatus getCarStatusByName(String carStatusName) {
		ArrayList<CarStatus> carStatusList = CarStatus.getCarStatusList();
		for (CarStatus carStatus : carStatusList) {
			if (carStatus.carStatusName.equals(carStatusName)) {
				return carStatus;
			}
		}
		return null;
	}
}
