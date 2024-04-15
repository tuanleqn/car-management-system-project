package model;

import java.util.ArrayList;

public class CarManagementModel {
	private ArrayList<CarModel> carList;
	private String choice;

	public CarManagementModel() {
		this.carList = new ArrayList<CarModel>();
	}

	public CarManagementModel(ArrayList<CarModel> carList) {
		this.carList = carList;
	}

	public ArrayList<CarModel> getCarList() {
		return carList;
	}

	public void setCarList(ArrayList<CarModel> carList) {
		this.carList = carList;
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	public void save(CarModel carModel) {
		this.carList.add(carModel);
	}

	public void delete(CarModel carModel) {
		this.carList.remove(carModel);
	}

	public void update(CarModel carModel) {
		this.carList.remove(carModel);
		this.carList.add(carModel);
	}

	public boolean existenceCheck(CarModel cM) {
		for (CarModel carModel : carList) {
			if (carModel.getRegistrationNum().equals( cM.getRegistrationNum())) {
				return true;
			}
		}
		return false;
	}
	
}
