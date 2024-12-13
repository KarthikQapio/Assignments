package com.Qapitol.model;

public class AddressPage{
    private String streetName;
    private String completeAddress;
    private String pincode;



    public void Address(String streetName, String completeAddress, String pincode) {
        this.streetName = streetName;
        this.completeAddress = completeAddress;
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return String.format("Address: %s, %s, %s", streetName, completeAddress, pincode);
    }

    public void addAddress(String hi, String hello, String address) {
        this.streetName = streetName;
        this.completeAddress = completeAddress;
        this.pincode = pincode;
    }
}
