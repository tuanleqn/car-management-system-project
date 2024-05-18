package model;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;

import java.util.ArrayList;

import test.Init;

public class DriverManagementModel {
	private ArrayList<DriverModel> driverList;
	private int totalNumberOfDrivers;

	public DriverManagementModel() {
		this.driverList = new ArrayList<DriverModel>();
		this.setTotalNumberOfDrivers(0);
	}

	public DriverManagementModel(ArrayList<DriverModel> driverList) {
		this.driverList = driverList;
	}

	public ArrayList<DriverModel> getDriverList() {
		return driverList;
	}

	public void setDriverList(ArrayList<DriverModel> driverList) {
		this.driverList = driverList;
	}
	
	//	Begin to MongoDB Database here:
	public void save(DriverModel driverModel) {
		try {
			MongoDatabase database = MongoDBConnection.getInstance().getDatabase();
			MongoCollection<Document> collection = database.getCollection("driverModels");
			Document modelDoc = new Document("Driver ID", driverModel.getDriverID())
					.append("Full Name", driverModel.getFullName())
					.append("Phone", driverModel.getPhone())
					.append("Address", driverModel.getAddress())
					.append("DL Number", driverModel.getDLNumber())
					.append("Driver Status ID", driverModel.getStatus().getDriverStatusID())
					.append("Driver Status Name", driverModel.getStatus().getDriverStatusName());
			collection.insertOne(modelDoc);
//			MongoDBConnection.getInstance().closeConnection();
		}
		catch (MongoException e) {
			System.err.println("Error saving driverModel to MongoDB: " + e.getMessage());
		}
		this.driverList.add(driverModel);
		this.totalNumberOfDrivers++;
		Init.statisticsView.getLbTotalNumberOfDrivers().setText(totalNumberOfDrivers + "");
	}
	
	public void get() {
		try {
			MongoDatabase database = MongoDBConnection.getInstance().getDatabase();
			MongoCollection<Document> collection = database.getCollection("driverModels");
			FindIterable<Document> findIterable = collection.find();
			MongoCursor<Document> cursor = findIterable.iterator();
			while (cursor.hasNext()) {
				Document document = cursor.next();
				DriverModel driverModel = documentToDriverModel(document);
				driverList.add(driverModel);
			}
			this.setTotalNumberOfDrivers((int) collection.countDocuments());
			cursor.close();
//			MongoDBConnection.getInstance().closeConnection();
		}
		catch (MongoException e){
			System.err.println("Error retrieving driverList from MongoDB: " + e.getMessage());
		}
	}

	public void delete(DriverModel driverModel) {
		try {
			MongoDatabase database = MongoDBConnection.getInstance().getDatabase();
			MongoCollection<Document> collection = database.getCollection("driverModels");
			collection.deleteOne(new Document("Driver ID", driverModel.getDriverID()));
//			MongoDBConnection.getInstance().closeConnection();
		}
		catch (MongoException e) {
            System.err.println("Error deleting driverModel from MongoDB: " + e.getMessage());
        }
		this.driverList.remove(driverModel);
		this.totalNumberOfDrivers--;
		Init.statisticsView.getLbTotalNumberOfDrivers().setText(totalNumberOfDrivers + "");
	}

	public void update(DriverModel driverModel) {
		try {
			MongoDatabase database = MongoDBConnection.getInstance().getDatabase();
			MongoCollection<Document> collection = database.getCollection("driverModels");
			Document filter = new Document("Driver ID", driverModel.getDriverID());
			Document updateDocument = new Document("$set", new Document()
					.append("Full Name", driverModel.getFullName())
					.append("Phone", driverModel.getPhone())
					.append("Address", driverModel.getAddress())
					.append("DL Number", driverModel.getDLNumber())
					.append("Driver Status ID", driverModel.getStatus().getDriverStatusID())
					.append("Driver Status Name", driverModel.getStatus().getDriverStatusName()));
			// Update the document in the MongoDB collection
			collection.updateOne(filter, updateDocument);
//			MongoDBConnection.getInstance().closeConnection();
		}
		catch (MongoException e) {
			System.err.println("Error updating driverModel from MongoDB: " + e.getMessage());
		}
		this.driverList.remove(driverModel);
		this.driverList.add(driverModel);
	}
	
	private DriverModel documentToDriverModel(Document document) {
		String driverID = document.getString("Driver ID");
		String fullName = document.getString("Full Name");
		String phone = document.getString("Phone");
		String address = document.getString("Address");
		String dLNumber = document.getString("DL Number");
		int driverStatusID = document.getInteger("Driver Status ID");
		String driverStatusName = document.getString("Driver Status Name");
		
		DriverStatus status = new DriverStatus(driverStatusID, driverStatusName);
		return new DriverModel(driverID, fullName, phone, address, dLNumber, status);
	}

	public boolean existenceCheck(DriverModel dM) {
		for (DriverModel driverModel : driverList) {
			if (driverModel.getDriverID().equals(dM.getDriverID())) {
				return true;
			}
		}
		return false;
	}

	public int getTotalNumberOfDrivers() {
		return totalNumberOfDrivers;
	}

	public void setTotalNumberOfDrivers(int totalNumberOfDrivers) {
		this.totalNumberOfDrivers = totalNumberOfDrivers;
	}

}