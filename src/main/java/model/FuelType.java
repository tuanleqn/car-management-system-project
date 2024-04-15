package model;

import java.util.ArrayList;
import java.util.Objects;

public class FuelType {
	private int fuelTypeID;
	private String fuelTypeName;

	public FuelType() {

	}

	public FuelType(int fuelTypeID, String fuelTypeName) {
		this.fuelTypeID = fuelTypeID;
		this.fuelTypeName = fuelTypeName;
	}

	public int getFuelTypeID() {
		return fuelTypeID;
	}

	public void setFuelTypeID(int fuelTypeID) {
		this.fuelTypeID = fuelTypeID;
	}

	public String getFuelTypeName() {
		return fuelTypeName;
	}

	public void setFuelTypeName(String fuelTypeName) {
		this.fuelTypeName = fuelTypeName;
	}

	@Override
	public String toString() {
		return "FuelType [fuelTypeID=" + fuelTypeID + ", fuelTypeName=" + fuelTypeName + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(fuelTypeID, fuelTypeName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FuelType other = (FuelType) obj;
		return fuelTypeID == other.fuelTypeID && Objects.equals(fuelTypeName, other.fuelTypeName);
	}

	public static ArrayList<FuelType> getFuelTypeList() {
		String[] fuelTypeArray = { "Diesel", "Gasoline", "CNG", "LNG", "Electricity" };
		ArrayList<FuelType> fuelTypeList = new ArrayList<FuelType>();
		int id = 0;
		for (String fuelType : fuelTypeArray) {
			FuelType ft = new FuelType(id, fuelType);
			fuelTypeList.add(ft);
		}
		return fuelTypeList;
	}

	public static FuelType getFuelTypeById(int id) {
		return FuelType.getFuelTypeList().get(id);
	}

	public static FuelType getFuelTypeByName(String fuelTypeName) {
		ArrayList<FuelType> fuelTypeList = FuelType.getFuelTypeList();
		for (FuelType fuelType : fuelTypeList) {
			if (fuelType.fuelTypeName.equals(fuelTypeName)) {
				return fuelType;
			}
		}
		return null;
	}
}
