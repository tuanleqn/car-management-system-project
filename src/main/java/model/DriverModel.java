package model;

import java.util.Objects;

public class DriverModel {
    private String DriverID;
    private String FullName;
    private String Phone;
    private String Address;
    private String DLNumber;
    private DriverStatus status;

    public DriverModel() {
    }

    public DriverModel(String driverID, String fullName, String phone, String address, String dlNumber, DriverStatus status) {
        this.DriverID = driverID;
        this.FullName = fullName;
        this.Phone = phone;
        this.Address = address;
        this.DLNumber = dlNumber;
        this.status = status;
    }

    public String getDriverID() {
        return DriverID;
    }

    public void setDriverID(String driverID) {
        DriverID = driverID;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getDLNumber() {
        return DLNumber;
    }

    public void setDLNumber(String DLNumber) {
        this.DLNumber = DLNumber;
    }

    public DriverStatus getStatus() {
        return status;
    }

    public void setStatus(DriverStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "DriverModel [DriverID=" + DriverID + ", FullName=" + FullName + ", Phone=" + Phone
                + ", Address=" + Address + ", DLNumber=" + DLNumber + ", status=" + status + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(DriverID, FullName, Phone, Address, DLNumber, status);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DriverModel other = (DriverModel) obj;
        return Objects.equals(DriverID, other.DriverID) && Objects.equals(FullName, other.FullName)
                && Objects.equals(Phone, other.Phone) && Objects.equals(Address, other.Address)
                && Objects.equals(DLNumber, other.DLNumber) && Objects.equals(status, other.status);
    }
}
