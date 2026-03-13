package com.cg.bean;

import java.util.List;

public class SBU {
    int sbuid;
    String sbuName;
    String sbuHead;
    private List<Employee> empList;

    public SBU() {
    }


    public SBU(int sbuid, String sbuName, String sbuHead) {
        this.sbuid = sbuid;
        this.sbuName = sbuName;
        this.sbuHead = sbuHead;
    }

    public List<Employee> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Employee> empList) {
        this.empList = empList;
    }

    public int getSbuid() {
        return sbuid;
    }

    public void setSbuid(int sbuid) {
        this.sbuid = sbuid;
    }

    public String getSbuName() {
        return sbuName;
    }

    public void setSbuName(String sbuName) {
        this.sbuName = sbuName;
    }

    public String getSbuHead() {
        return sbuHead;
    }

    public void setSbuHead(String sbuHead) {
        this.sbuHead = sbuHead;
    }
    public void displaySbuWithEmployees() {
        System.out.println("SBU details");
        System.out.println("--------------");
        System.out.println("sbuCode=" + sbuid + ", sbuHead=" + sbuHead + ", sbuName=" + sbuName);
        System.out.println("Employee details:----------------");
        System.out.println(empList);
    }
}
