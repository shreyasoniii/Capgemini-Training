package com;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int deptId;
    String deptName;
    @OneToMany( mappedBy ="department",cascade = CascadeType.ALL)
    private List<Employee> emp;

    public Department(){

    }

    public Department(String deptName) {

        this.deptName = deptName;
    }

    public int getDeptId() {

        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    public List<Employee> getEmp() {
        return emp;
    }

    public void setEmp(List<Employee> emp) {
        this.emp = emp;
    }


}
