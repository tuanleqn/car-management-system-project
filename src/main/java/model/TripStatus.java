package model;

import java.util.ArrayList;
import java.util.Objects;

public class TripStatus {
	private int tripStatusID;
	private String tripStatusName;

	public TripStatus() {

	}

	public TripStatus(int tripStatusID, String tripStatusName) {
		super();
		this.tripStatusID = tripStatusID;
		this.tripStatusName = tripStatusName;
	}

	public int getTripStatusID() {
		return tripStatusID;
	}

	public void setTripStatusID(int tripStatusID) {
		this.tripStatusID = tripStatusID;
	}

	public String getTripStatusName() {
		return tripStatusName;
	}

	public void setTripStatusName(String tripStatusName) {
		this.tripStatusName = tripStatusName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(tripStatusID, tripStatusName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TripStatus other = (TripStatus) obj;
		return tripStatusID == other.tripStatusID && Objects.equals(tripStatusName, other.tripStatusName);
	}

	@Override
	public String toString() {
		return "TripStatus [tripStatusID=" + tripStatusID + ", tripStatusName=" + tripStatusName + "]";
	}

	public static ArrayList<TripStatus> getTripStatusList() {
		String[] tripStatusArray = { "In progress", "Completed" };
		ArrayList<TripStatus> tripStatusList = new ArrayList<TripStatus>();
		int id = 0;
		for (String tripStatus : tripStatusArray) {
			TripStatus ts = new TripStatus(id, tripStatus);
			tripStatusList.add(ts);
		}
		return tripStatusList;
	}

	public static TripStatus getTripStatusById(int id) {
		return TripStatus.getTripStatusList().get(id);
	}

	public static TripStatus getTripStatusByName(String tripStatusName) {
		ArrayList<TripStatus> tripStatusList = TripStatus.getTripStatusList();
		for (TripStatus tripStatus : tripStatusList) {
			if (tripStatus.tripStatusName.equals(tripStatusName)) {
				return tripStatus;
			}
		}
		return null;
	}
}
