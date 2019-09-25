package com.example.shreevaka.tourism;

public class Hotel {

    private int ID = 0;
    private String HName;
    private String HId;
    private String Address;
    private String City;
    private String District;
    private String Province;
    private String Description;
    private String CNumber;

    public String getHName() {
        return HName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setHName(String HName) {
        this.HName = HName;
    }

    public String getHId() {
        return HId;
    }

    public void setHId(String HId) {
        this.HId = HId;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public String getProvince() {
        return Province;
    }

    public void setProvince(String province) {
        Province = province;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getCNumber() {
        return CNumber;
    }

    public void setCNumber(String CNumber) {
        this.CNumber = CNumber;
    }

}