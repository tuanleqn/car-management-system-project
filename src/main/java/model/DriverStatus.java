package model;
import java.util.ArrayList;
import java.util.Objects;

public class DriverStatus {
    private int driverStatusID;
    private String driverStatusName;
    public DriverStatus(){
    }
    public DriverStatus(int driverStatusID,String driverStatusName){
        this.driverStatusID=driverStatusID;
        this.driverStatusName=driverStatusName;
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
        return Objects.hash(driverStatusID,driverStatusName);
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
        ArrayList<DriverStatus> driverStatusList = new ArrayList<DriverStatus>();
        int id = 0;
        for (String driverStatus : driverStatusArray) {
            DriverStatus ds = new DriverStatus(id, driverStatus);
            driverStatusList.add(ds);
        }
        return driverStatusList;
    }
    public static DriverStatus getDriverStatusById(int id) {
        return DriverStatus.getDriverStatusList().get(id);
    }

    public static DriverStatus getDriverStatusByName(String driverStatusName) {
        ArrayList<DriverStatus> driverStatusList = DriverStatus.getDriverStatusList();
        for (DriverStatus driverStatus : driverStatusList) {
            if (driverStatus.driverStatusName.equals(driverStatusName)) {
                return driverStatus;
            }
        }
        return null;
    }



}

