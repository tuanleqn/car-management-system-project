package model;

import java.util.ArrayList;
import java.util.Objects;

public class DriverStatus {
    private int driverStatusID;
    private String driverStatusName;

    public DriverStatus() {
    }

    public DriverStatus(int driverStatusID, String driverStatusName) {
        this.driverStatusID = driverStatusID;
        this.driverStatusName = driverStatusName;
    }

    public int getDriverStatusID() {
        return driverStatusID;
    }

    public void setDriverStatusID(int driverStatusID) {
        this.driverStatusID = driverStatusID;
    }

    public String getDriverStatusName() {
        return driverStatusName;
    }

    public void setDriverStatusName(String driverStatusName) {
        this.driverStatusName = driverStatusName;
    }

    @Override
    public String toString() {
        return "DriverStatus [driverStatusID=" + driverStatusID + ", driverStatusName=" + driverStatusName + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(driverStatusID, driverStatusName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DriverStatus other = (DriverStatus) obj;
        return driverStatusID == other.driverStatusID && Objects.equals(driverStatusName, other.driverStatusName);
    }

    public static ArrayList<DriverStatus> getDriverStatusList() {
        String[] driverStatusArray = { "Available", "Unavailable" };
        ArrayList<DriverStatus> driverStatusList = new ArrayList<>();
        int id = 0;
        for (String driverStatus : driverStatusArray) {
            driverStatusList.add(new DriverStatus(id, driverStatus));
            id++;
        }
        return driverStatusList;
    }

    public static DriverStatus getDriverStatusById(int id) {
        for (DriverStatus status : getDriverStatusList()) {
            if (status.getDriverStatusID() == id) {
                return status;
            }
        }
        return null;
    }

    public static DriverStatus getDriverStatusByName(String driverStatusName) {
        for (DriverStatus status : getDriverStatusList()) {
            if (status.getDriverStatusName().equals(driverStatusName)) {
                return status;
            }
        }
        return null;
    }
}
