package model;

import java.util.ArrayList;
import java.util.Objects;

public class CarType {
	private int carTypeID;
	private String carTypeName;

	public CarType() {

	}

	public int getCarTypeID() {
		return carTypeID;
	}

	public CarType(int carTypeID, String carType) {
		this.carTypeID = carTypeID;
		this.carTypeName = carType;
	}

	public void setCarTypeID(int carTypeID) {
		this.carTypeID = carTypeID;
	}

	public String getCarTypeName() {
		return carTypeName;
	}

	public void setCarTypeName(String carType) {
		this.carTypeName = carType;
	}

	@Override
	public String toString() {
		return "CarType [carTypeID=" + carTypeID + ", carType=" + carTypeName + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(carTypeName, carTypeID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarType other = (CarType) obj;
		return Objects.equals(carTypeName, other.carTypeName) && carTypeID == other.carTypeID;
	}

	public static ArrayList<CarType> getCarTypeList() {
		String[] carTypeArray = { "Bus", "Truck", "Container Truck" };
		ArrayList<CarType> carTypeList = new ArrayList<CarType>();
		int id = 0;
		for (String carType : carTypeArray) {
			CarType ct = new CarType(id, carType);
			carTypeList.add(ct);
		}
		return carTypeList;
	}

	public static CarType getCarTypeById(int id) {
		return CarType.getCarTypeList().get(id);
	}

	public static CarType getCarTypeByName(String carTypeName) {
		ArrayList<CarType> carTypeList = CarType.getCarTypeList();
		for (CarType carType : carTypeList) {
			if (carType.carTypeName.equals(carTypeName)) {
				return carType;
			}
		}
		return null;
	}
}
