package com.example.shreevaka.tourism;

public class Car {

    private int ID = 0;
    private String Car;
    private String City;
    private String Facilities;
    private String Drivername;
    private String Contactnumber;
    private String Discription;

    public Car() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCar() {
        return Car;
    }

    public void setCar(String car) {
        Car = car;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getFacilities() {
        return Facilities;
    }

    public void setFacilities(String facilities) {
        Facilities = facilities;
    }

    public String getDrivername() {
        return Drivername;
    }

    public void setDrivername(String drivername) {
        Drivername = drivername;
    }

    public String getContactnumber() {
        return Contactnumber;
    }

    public void setContactnumber(String contactnumber) {
        Contactnumber = contactnumber;
    }

    public String getDiscription() {
        return Discription;
    }

    public void setDiscription(String discription) {
        Discription = discription;
    }
}
