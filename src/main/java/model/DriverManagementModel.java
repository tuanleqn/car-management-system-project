package model;

import java.util.ArrayList;
public class DriverManagementModel {
    private ArrayList<DriverModel> driverList;
    private String choice;
    public DriverManagementModel() {
        this.driverList = new ArrayList<DriverModel>();
    }

    public DriverManagementModel(ArrayList<DriverModel> driverList) {
        this.driverList= driverList;
    }

    public ArrayList<DriverModel> getDriverList() {
        return driverList;
    }

    public void setCarList(ArrayList<DriverModel> driverList) {
        this.driverList= driverList;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public void save(DriverModel driverModel) {
        this.driverList.add(driverModel);
    }

    public void delete(DriverModel driverModel) {
        this.driverList.remove(driverModel);
    }

    public void update(DriverModel driverModel) {
        this.driverList.remove(driverModel);
        this.driverList.add(driverModel);
    }

    public boolean existenceCheck(DriverModel dM) {
        for (DriverModel driverModel : driverList) {
            if (driverModel.getDriverID().equals( dM.getDriverID())) {
                return true;
            }
        }
        return false;
    }

}
