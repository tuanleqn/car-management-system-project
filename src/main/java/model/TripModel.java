package model;

import java.util.Date;
import java.util.Objects;

public class TripModel {
	private String tripID;
	private String departurePoint;
	private String arrivalPoint;
	private Date departureTime;
	private Date arrivalTime;
	private TripStatus status;
	private String driverID;
	private String carID;
	private double price;

	public TripModel() {
		
	}

	public TripModel(String tripID, String departurePoint, String arrivalPoint, Date departureTime, Date arrivalTime,
			TripStatus status, String driverID, String carID, double price) {
		this.tripID = tripID;
		this.departurePoint = departurePoint;
		this.arrivalPoint = arrivalPoint;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.status = status;
		this.driverID = driverID;
		this.carID = carID;
		this.price = price;
	}

	public String getTripID() {
		return tripID;
	}

	public void setTripID(String tripID) {
		this.tripID = tripID;
	}

	public String getDeparturePoint() {
		return departurePoint;
	}

	public void setDeparturePoint(String departurePoint) {
		this.departurePoint = departurePoint;
	}

	public String getArrivalPoint() {
		return arrivalPoint;
	}

	public void setArrivalPoint(String arrivalPoint) {
		this.arrivalPoint = arrivalPoint;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public TripStatus getStatus() {
		return status;
	}

	public void setStatus(TripStatus status) {
		this.status = status;
	}

	public String getDriverID() {
		return driverID;
	}

	public void setDriverID(String driverID) {
		this.driverID = driverID;
	}

	public String getCarID() {
		return carID;
	}

	public void setCarID(String carID) {
		this.carID = carID;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "TripModel [tripID=" + tripID + ", departurePoint=" + departurePoint + ", arrivalPoint=" + arrivalPoint
				+ ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", status=" + status
				+ ", driverID=" + driverID + ", carID=" + carID + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(arrivalPoint, arrivalTime, carID, departurePoint, departureTime, driverID, price, status,
				tripID);
	}

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		TripModel other = (TripModel) obj;
//		return Objects.equals(arrivalPoint, other.arrivalPoint) && Objects.equals(arrivalTime, other.arrivalTime)
//				&& Objects.equals(carID, other.carID) && Objects.equals(departurePoint, other.departurePoint)
//				&& Objects.equals(departureTime, other.departureTime) && Objects.equals(driverID, other.driverID)
//				&& Double.doubleToIntBits(price) == Double.doubleToIntBits(other.price)
//				&& Objects.equals(status, other.status) && Objects.equals(tripID, other.tripID);
//	}
	
}
