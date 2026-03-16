package com.cg.bean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Address {
    @Value("${city}")
    private String city;
    @Value(("${country}"))
    private String country;
    @Value("${zip}")
    private String zip;


//    public Address(){
//
//    }
//
//    public Address(String city, String country, String zip) {
//        this.city = city;
//        this.country = country;
//        this.zip = zip;
//    }

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
