package test;

import java.util.ArrayList;

import model.CarManagementModel;
import model.CarModel;
import model.CarStatus;
import model.CarType;
import model.FuelType;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class testMongoDB {
	private static ArrayList<CarModel> test;

	public static void main(String[] args) {
		CarManagementModel model = new CarManagementModel();
		CarType carType = new CarType(1, "Sedan");
		FuelType fuelType = new FuelType(1, "Gasoline");
		CarStatus carStatus = new CarStatus(1, "Available");
		CarModel car1 = new CarModel("ABC123", carType, "Medium", 1500.0, fuelType, carStatus);
		CarModel car2 = new CarModel("XYZ789", carType, "Small", 150.0, fuelType, carStatus);
		CarModel car3 = new CarModel("HJK521", carType, "Big", 150000.0, fuelType, carStatus);
		CarModel car4 = new CarModel("TYD940", carType, "Medium", 3000.0, fuelType, carStatus);
		CarModel car5 = new CarModel("GRT730", carType, "Big", 100000.0, fuelType, carStatus);

		// Using "read" method:
//		 model.get();
//		 System.out.println(model.getTotalNumberOfCars());
//		 test = model.getCarList();
//		 for(int i = 0; i < test.size(); i++) {
//			 System.out.println(test.get(i));
//		 }

		// Using "update" method:
//		 car1.setTonnage(2000.0);
//		 model.update(car1);

		// Using "delete" method:
//		 model.delete(car5);

		// Using "save" method:
//		 model.save(car5);
	}
}
