package com.cg.controller;

import com.cg.dto.EmployeeDto;
import com.cg.entity.Employee;
import com.cg.service.IEmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
//    @Autowired
    private IEmployeeService empService;

    public EmployeeController(IEmployeeService empService) {
        super();
        this.empService = empService;
    }

    @GetMapping("employees")
    public List<Employee> getXyz(){
        return empService.getAllEmployees();
    }

    //get employee by id: [HTTPS: get method is idempotent, it does not change data if called again and again]
    @GetMapping("employees/{id}")
    public EmployeeDto getEmployeeById(@PathVariable int id){
        return empService.getEmployee(id);
    }
    @GetMapping("employees/name/{name}")
    public List<Employee> getEmpByName(@PathVariable String name){
        return empService.getEmployeeByName(name);
    }

    @PostMapping("employees")
    public Employee createNewEmployee(@RequestBody Employee employee) {
        return empService.createEmployee(employee);
    }

    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        return empService.removeEmployee(id);
    }

    @PutMapping("employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return empService.updateEmployee(employee);
    }
}
