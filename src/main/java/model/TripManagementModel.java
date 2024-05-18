package model;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import java.util.ArrayList;
import java.util.Date;

import test.Init;

public class TripManagementModel {
	private ArrayList<TripModel> tripList;
	private int totalNumberOfTrips;
	private double totalRevenue;

	public TripManagementModel() {
		this.tripList = new ArrayList<TripModel>();
		this.setTotalNumberOfTrips(this.getTotalNumberOfTrips());
		this.setTotalRevenue(0);
	}

	public TripManagementModel(ArrayList<TripModel> tripList) {
		this.tripList = tripList;
	}

	public ArrayList<TripModel> getTripList() {
		return tripList;
	}

	public void setTripList(ArrayList<TripModel> tripList) {
		this.tripList = tripList;
	}
	
	//	Begin to MongoDB Database here:
	public void save(TripModel tripModel) {
		try {
			MongoDatabase database = MongoDBConnection.getInstance().getDatabase();
			MongoCollection<Document> collection = database.getCollection("tripModels");
			Document modelDoc = new Document("Trip ID", tripModel.getTripID())
					.append("Departure Point", tripModel.getDeparturePoint())
					.append("Arrival Point", tripModel.getArrivalPoint())
					.append("Departure Time", tripModel.getDepartureTime())
					.append("Arrival Time", tripModel.getArrivalTime())
					.append("Trip Status ID", tripModel.getStatus().getTripStatusID())
					.append("Trip Status Name", tripModel.getStatus().getTripStatusName())
					.append("Driver ID", tripModel.getDriverID())
					.append("Car ID", tripModel.getCarID())
					.append("Price", tripModel.getPrice());
			collection.insertOne(modelDoc);
//			MongoDBConnection.getInstance().closeConnection();
		}
		catch (MongoException e) {
			System.err.println("Error saving tripModel to MongoDB: " + e.getMessage());
		}
		this.tripList.add(tripModel);
		this.totalNumberOfTrips++;
		this.totalRevenue += tripModel.getPrice();
		Init.statisticsView.getLbTotalNumberOfTrips().setText(totalNumberOfTrips + "");
		Init.statisticsView.getLbTotalRevenue().setText(totalRevenue + "");
	}
	
	public void get() {
		try {
			MongoDatabase database = MongoDBConnection.getInstance().getDatabase();
			MongoCollection<Document> collection = database.getCollection("tripModels");
			FindIterable<Document> findIterable = collection.find();
			MongoCursor<Document> cursor = findIterable.iterator();
			this.totalRevenue = 0;
			while (cursor.hasNext()) {
				Document document = cursor.next();
				TripModel tripModel = documentToTripModel(document);
				tripList.add(tripModel);
				this.totalRevenue += tripModel.getPrice();
			}
			this.setTotalNumberOfTrips((int) collection.countDocuments());
			cursor.close();
//			MongoDBConnection.getInstance().closeConnection();
		}
		catch (MongoException e){
			System.err.println("Error retrieving tripList from MongoDB: " + e.getMessage());
		}
	}

	public void delete(TripModel tripModel) {
		try {
			MongoDatabase database = MongoDBConnection.getInstance().getDatabase();
			MongoCollection<Document> collection = database.getCollection("tripModels");
			collection.deleteOne(new Document("Trip ID", tripModel.getTripID()));
//			MongoDBConnection.getInstance().closeConnection();
		}
		catch (MongoException e) {
            System.err.println("Error deleting tripModel from MongoDB: " + e.getMessage());
        }
		this.tripList.remove(tripModel);
		this.totalNumberOfTrips--;
		Init.statisticsView.getLbTotalNumberOfTrips().setText(totalNumberOfTrips + "");
	}

	public void update(TripModel tripModel) {
		try {
			MongoDatabase database = MongoDBConnection.getInstance().getDatabase();
			MongoCollection<Document> collection = database.getCollection("tripModels");
			Document filter = new Document("Trip ID", tripModel.getTripID());
			Document updateDocument = new Document("$set", new Document()
					.append("Departure Point", tripModel.getDeparturePoint())
					.append("Arrival Point", tripModel.getArrivalPoint())
					.append("Departure Time", tripModel.getDepartureTime())
					.append("Arrival Time", tripModel.getArrivalTime())
					.append("Trip Status ID", tripModel.getStatus().getTripStatusID())
					.append("Trip Status Name", tripModel.getStatus().getTripStatusName())
					.append("Driver ID", tripModel.getDriverID())
					.append("Car ID", tripModel.getCarID())
					.append("Price", tripModel.getPrice()));
			// Update the document in the MongoDB collection
			collection.updateOne(filter, updateDocument);
//			MongoDBConnection.getInstance().closeConnection();
		}
		catch (MongoException e) {
			System.err.println("Error updating tripModel from MongoDB: " + e.getMessage());
		}
		int idx = this.tripList.indexOf(tripModel);
		double firstPrice = this.tripList.get(idx).getPrice();
		this.totalRevenue -= firstPrice;

		this.tripList.remove(tripModel);
		this.tripList.add(tripModel);

		this.totalRevenue += tripModel.getPrice();
		Init.statisticsView.getLbTotalRevenue().setText(totalRevenue + "");
	}
	
	private TripModel documentToTripModel(Document document) {
		String tripID = document.getString("Trip ID");
		String departurePoint = document.getString("Departure Point");
		String arrivalPoint = document.getString("Arrival Point");
		Date departureTime = document.getDate("Departure Time");
		Date arrivalTime = document.getDate("Arrival Time");
		int tripStatusID = document.getInteger("Trip Status ID");
		String tripStatusName = document.getString("Trip Status Name");
		String driverID = document.getString("Driver ID");
		String carID = document.getString("Car ID");
		double price = document.getDouble("Price");
		
		TripStatus status = new TripStatus(tripStatusID, tripStatusName);
		return new TripModel(tripID, departurePoint, arrivalPoint, departureTime, arrivalTime, status, driverID, carID, price);
	}

	public boolean existenceCheck(TripModel tm) {
		for (TripModel tripModel : tripList) {
			if (tripModel.getTripID().equals(tm.getTripID())) {
				return true;
			}
		}
		return false;
	}

	public int getTotalNumberOfTrips() {
		return totalNumberOfTrips;
	}

	public void setTotalNumberOfTrips(int totalNumberOfTrips) {
		this.totalNumberOfTrips = totalNumberOfTrips;
	}

	public double getTotalRevenue() {
		return totalRevenue;
	}

	public void setTotalRevenue(double totalRevenue) {
		this.totalRevenue = totalRevenue;
	}
}
