package com.cg.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class Employee {
    @Value("${empid}")
    private int empid;
    @Value("${ename}")
    private String ename;
   // @Autowired
    private Address address;

//    public Employee(){
//
//    }
    public Employee(Address address){
        this.address=address;
    }
//    public Employee(int empid, String ename, Address address) {
//        this.empid = empid;
//        this.ename = ename;
//        this.address = address;
//    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    public void printEmployeeDetails(){
        System.out.println("Employee id  "+empid);
        System.out.println("Name  "+ename);
        System.out.println("==================Address==========");
        System.out.println("city"+" "+address.getCity());
        System.out.println("zip"+" "+address.getZip());
        System.out.println("country"+" "+address.getCountry());
    }
}