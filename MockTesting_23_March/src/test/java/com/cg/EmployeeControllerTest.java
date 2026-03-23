package com.cg;

import com.cg.controller.EmployeeController;
import com.cg.dto.EmployeeDTO;
import com.cg.entity.Employee;
import com.cg.service.IEmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebMvcTest(controllers= EmployeeController.class)
public class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;


    @MockitoBean
    private IEmployeeService service;

    private ObjectMapper objectMapper = new ObjectMapper();
    @Test
    void TestgetAll() throws Exception {
        EmployeeDTO dto = new EmployeeDTO("Raghav",
                LocalDate.of(2003, 2, 1), 23000.0);
        dto.setEmployeeId(1);
        //make service mock
        when(service.getEmployee(1)).thenReturn(dto);
        //now we will check api
        mockMvc.perform(get("/api/employee/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fullName").value("Raghav"));


    }

    @Test
    void getAllEmployeeTest() throws Exception {
        EmployeeDTO e1 = new EmployeeDTO("Shreya",
                LocalDate.of(2003, 02, 01), 23000.00);
        EmployeeDTO e2 = new EmployeeDTO("Raghav",
                LocalDate.of(2003, 02, 07), 28000.00);
        EmployeeDTO e3 = new EmployeeDTO("Raam",
                LocalDate.of(2004, 02, 05), 23600.00);
        when(service.getAllEmployee()).thenReturn(List.of(e1, e2, e3));
        mockMvc.perform(get("/api/employee"))
                .andExpect(status().isOk()).andExpect(jsonPath("$[2].fullName").value("Raam"));
    }

    @Test
    void getEmployeeByName() throws Exception {
        EmployeeDTO e1 = new EmployeeDTO("Shreya",
                LocalDate.of(2003, 02, 01), 23000.00);
        when(service.getEmployeeByName("Shreya")).thenReturn(List.of(e1));

        mockMvc.perform(get("/api/employee/name/{name}", "Shreya"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].fullName").value("Shreya"));
    }

    @Test
    void deleteEmployeeById() throws Exception {
        EmployeeDTO e1 = new EmployeeDTO("Shreya",
                LocalDate.of(2003, 02, 01), 23000.00);
        e1.setEmployeeId(1);
        //when(service.getEmployee(e1.getEmployeeId())).thenReturn(e1);
        when(service.removeEmployee(1)).thenReturn("Employee Deletetd");

        mockMvc.perform(delete("/api/employee/{id}", e1.getEmployeeId()))
                .andExpect(status().isOk());
    }

//    @Test
//    void createEmployeeTest() throws Exception {
//        EmployeeDTO e1=new EmployeeDTO("Saksham",LocalDate.of(2003, 11, 12), 45000.0);
//        when(service.createEmployee(any(EmployeeDTO.class))).thenReturn(e1);
//
//        mockMvc.perform(post("/api/employee").contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(e1))).andExpect(status().isOk())
//                .andExpect(jsonPath("$.fullName").value("Saksham"));
//    }

//
//    @Test
//    void updateEmployeeTest() throws Exception{
//        EmployeeDTO e1=new EmployeeDTO("Saksham",LocalDate.of(2003, 11, 12), 45000.0);
//        when(service.updateEmployee(any(EmployeeDTO.class))).thenReturn(e1);
//        mockMvc.perform(put("/api/employee").contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(e1))).andExpect(status().isOk());
//
//    }

}
