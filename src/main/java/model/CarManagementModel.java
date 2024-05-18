package model;

import com.mongodb.MongoException;
//import com.mongodb.client.MongoClients;
//import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;

import java.util.ArrayList;

import test.Init;

public class CarManagementModel {
	private ArrayList<CarModel> carList;
	private int totalNumberOfCars;

	public CarManagementModel() {
		this.carList = new ArrayList<CarModel>();
		this.setTotalNumberOfCars(0);
	}

	public CarManagementModel(ArrayList<CarModel> carList) {
		this.carList = carList;
	}
	
//	Begin to MongoDB Database here:
	public void save(CarModel carModel) {
		try {
			MongoDatabase database = MongoDBConnection.getInstance().getDatabase();
			MongoCollection<Document> collection = database.getCollection("carModels");
			Document modelDoc = new Document("Registration Number", carModel.getRegistrationNum())
					.append("Car Type ID", carModel.getCarType().getCarTypeID())
					.append("Car Type Name", carModel.getCarType().getCarTypeName())
					.append("Size", carModel.getSize())
					.append("Tonnage", carModel.getTonnage())
					.append("Fuel Type ID", carModel.getFuelType().getFuelTypeID())
					.append("Fuel Type Name", carModel.getFuelType().getFuelTypeName())
					.append("Car Status ID", carModel.getStatus().getCarStatusID())
					.append("Car Status Name", carModel.getStatus().getCarStatusName());
			collection.insertOne(modelDoc);
//			MongoDBConnection.getInstance().closeConnection();
		}
		catch (MongoException e) {
			System.err.println("Error saving carModel to MongoDB: " + e.getMessage());
		}
		this.carList.add(carModel);
		this.totalNumberOfCars++;
		Init.statisticsView.getLbTotalNumberOfCars().setText(totalNumberOfCars + "");
	}
	
	public void get() {
		try {
			MongoDatabase database = MongoDBConnection.getInstance().getDatabase();
			MongoCollection<Document> collection = database.getCollection("carModels");
			FindIterable<Document> findIterable = collection.find();
			MongoCursor<Document> cursor = findIterable.iterator();
			while (cursor.hasNext()) {
				Document document = cursor.next();
				CarModel carModel = documentToCarModel(document);
				carList.add(carModel);
			}
			this.setTotalNumberOfCars((int) collection.countDocuments());
			cursor.close();
//			MongoDBConnection.getInstance().closeConnection();
		}
		catch (MongoException e){
			System.err.println("Error retrieving carList from MongoDB: " + e.getMessage());
		}
	}
	
	public void delete(CarModel carModel) {
		try {
			MongoDatabase database = MongoDBConnection.getInstance().getDatabase();
			MongoCollection<Document> collection = database.getCollection("carModels");
			collection.deleteOne(new Document("Registration Number", carModel.getRegistrationNum()));
//			MongoDBConnection.getInstance().closeConnection();
		}
		catch (MongoException e) {
            System.err.println("Error deleting carModel from MongoDB: " + e.getMessage());
        }
		this.carList.remove(carModel);
		this.totalNumberOfCars--;
		Init.statisticsView.getLbTotalNumberOfCars().setText(totalNumberOfCars + "");
	}

	public void update(CarModel carModel) {
		try {
			MongoDatabase database = MongoDBConnection.getInstance().getDatabase();
			MongoCollection<Document> collection = database.getCollection("carModels");
			Document filter = new Document("Registration Number", carModel.getRegistrationNum());
			Document updateDocument = new Document("$set", new Document()
	                .append("Car Type ID", carModel.getCarType().getCarTypeID())
	                .append("Car Type Name", carModel.getCarType().getCarTypeName())
	                .append("Size", carModel.getSize())
	                .append("Tonnage", carModel.getTonnage())
	                .append("Fuel Type ID", carModel.getFuelType().getFuelTypeID())
	                .append("Fuel Type Name", carModel.getFuelType().getFuelTypeName())
	                .append("Car Status ID", carModel.getStatus().getCarStatusID())
	                .append("Car Status Name", carModel.getStatus().getCarStatusName()));
			// Update the document in the MongoDB collection
            collection.updateOne(filter, updateDocument);
//            MongoDBConnection.getInstance().closeConnection();
		}
		catch (MongoException e) {
			System.err.println("Error updating carModel from MongoDB: " + e.getMessage());
		}
		this.carList.remove(carModel);
		this.carList.add(carModel);
	}
	
	private CarModel documentToCarModel(Document document) {
		String registrationNum = document.getString("Registration Number");
		int carTypeId = document.getInteger("Car Type ID");
		String carTypeName = document.getString("Car Type Name");
		String size = document.getString("Size");
		double tonnage = document.getDouble("Tonnage");
		int fuelTypeId = document.getInteger("Fuel Type ID");
	    String fuelTypeName = document.getString("Fuel Type Name");
	    int carStatusId = document.getInteger("Car Status ID");
	    String carStatusName = document.getString("Car Status Name");
	    
	    CarType carType = new CarType(carTypeId, carTypeName);
	    FuelType fuelType = new FuelType(fuelTypeId, fuelTypeName);
	    CarStatus carStatus = new CarStatus(carStatusId, carStatusName);
	    
	    return new CarModel(registrationNum, carType, size, tonnage, fuelType, carStatus);
	}
	
	public ArrayList<CarModel> getCarList() {
		return carList;
	}

	public void setCarList(ArrayList<CarModel> carList) {
		this.carList = carList;
	}
	
	public boolean existenceCheck(CarModel cM) {
		for (CarModel carModel : carList) {
			if (carModel.getRegistrationNum().equals(cM.getRegistrationNum())) {
				return true;
			}
		}
		return false;
	}

	public int getTotalNumberOfCars() {
		return totalNumberOfCars;
	}

	public void setTotalNumberOfCars(int totalNumberOfCars) {
		this.totalNumberOfCars = totalNumberOfCars;
	}

}
