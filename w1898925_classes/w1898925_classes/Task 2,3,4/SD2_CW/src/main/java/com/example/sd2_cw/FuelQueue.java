package com.example.sd2_cw;

public class FuelQueue {
    private String fName;
    private String sName;
    private String vehicleNo;
    private int  noOfLiters;

    public FuelQueue(String fName, String sName, String vehicleNo, int noOfLiters) {
        this.fName = fName;
        this.sName = sName;
        this.vehicleNo = vehicleNo;
        this.noOfLiters = noOfLiters;
    }


    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public int getNoOfLiters() {
        return noOfLiters;
    }

    public void setNoOfLiters(int noOfLiters) {
        this.noOfLiters = noOfLiters;
    }

}



