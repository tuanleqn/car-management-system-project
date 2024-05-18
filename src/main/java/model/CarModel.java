package model;

import java.util.Objects;

public class CarModel {
	private String registrationNum;
	private CarType carType;
	private String Size;
	private double Tonnage;
	private FuelType fuelType;
	private CarStatus status;

	public CarModel() {

	}

	public CarModel(String registrationNum, CarType carType, String size, double tonnage, FuelType fuelType,
			CarStatus status) {
		this.registrationNum = registrationNum;
		this.carType = carType;
		this.Size = size;
		this.Tonnage = tonnage;
		this.fuelType = fuelType;
		this.status = status;
	}

	public String getRegistrationNum() {
		return registrationNum;
	}

	public void setRegistrationNum(String registrationNum) {
		this.registrationNum = registrationNum;
	}

	public CarType getCarType() {
		return carType;
	}

	public void setCarType(CarType carType) {
		this.carType = carType;
	}

	public String getSize() {
		return Size;
	}

	public void setSize(String size) {
		Size = size;
	}

	public double getTonnage() {
		return Tonnage;
	}

	public void setTonnage(double tonnage) {
		Tonnage = tonnage;
	}

	public FuelType getFuelType() {
		return fuelType;
	}

	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}

	public CarStatus getStatus() {
		return status;
	}

	public void setStatus(CarStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CarModel [registrationNum=" + registrationNum + ", carType=" + carType + ", Size=" + Size + ", Tonnage="
				+ Tonnage + ", fuelType=" + fuelType + ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Size, Tonnage, carType, fuelType, registrationNum, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarModel other = (CarModel) obj;
		return Objects.equals(Size, other.Size) && Objects.equals(Tonnage, other.Tonnage)
				&& Objects.equals(carType, other.carType) && Objects.equals(fuelType, other.fuelType)
				&& Objects.equals(registrationNum, other.registrationNum) && Objects.equals(status, other.status);
	}

}
