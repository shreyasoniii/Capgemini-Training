package com.cg.dto;

import com.cg.entity.Employee;
import com.cg.dto.EmployeeDto;

public class EntityMapper {
    public static EmployeeDto convertEmpToDto(Employee emp){
        EmployeeDto edto=new EmployeeDto(emp.getEmpid(), emp.getEmpname(), emp.getDob(),emp.getSalary());
        return edto;
    }
    public static Employee covertDtoToEmp(EmployeeDto edto){
        Employee emp=new Employee(edto.getEmployeename(),edto.getDobemp(),edto.getSalaryemp());
        return emp;
    }
}
