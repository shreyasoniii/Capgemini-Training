package com.cg.bean;

public class Address {
    String city;
    String country;
    String zip;

    public Address(String city, String country, String zip) {
        this.city = city;
        this.country = country;
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
