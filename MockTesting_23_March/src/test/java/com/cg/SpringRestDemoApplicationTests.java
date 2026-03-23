package com.cg;

import com.cg.controller.EmployeeController;
import com.cg.dao.IEmployeeRepo;
import com.cg.dto.EmployeeDTO;
import com.cg.dto.EntityMapper;
import com.cg.entity.Employee;
import com.cg.exception.EmployeNotFoundException;
import com.cg.service.EmployeeService;
import com.cg.service.IEmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SpringRestDemoApplicationTests {

	@Mock
	private IEmployeeRepo repo;

	@InjectMocks
	private EmployeeService service;

	@Test
	void testEmployeeById() {
		when(repo.findById(222))
				.thenThrow(new EmployeNotFoundException("Not Found"));

		assertThrows(EmployeNotFoundException.class,
				() -> service.getEmployee(222));
	}

	@Test
	void testEmployeeById2() {
		EmployeeDTO edto = new EmployeeDTO("Raghav",
				LocalDate.of(2003, 02, 01), 23000.00);
		edto.setEmployeeId(100);

		Employee emp = EntityMapper.convertObjectToEntity(edto);
		Optional<Employee> op = Optional.of(emp);

		when(repo.findById(100)).thenReturn(op);

		assertNotNull(service.getEmployee(100));
	}

	@Test
	void testAllEmployee() {
		List<Employee> list = new ArrayList<>();
		Employee edto = new Employee("Shreya", LocalDate.of(2003, 03, 01), 34568.0);
		list.add(edto);
		when(repo.findAll()).thenReturn(list);
		List<EmployeeDTO> result = service.getAllEmployee();
		assertNotNull(result);
		assertFalse(result.isEmpty());
	}

	@Test
	void testAllEmployeeByName() {
		EmployeeDTO edto = new EmployeeDTO("Raghav",
				LocalDate.of(2003, 02, 01), 23000.00);
		edto.setEmployeeId(100);

		Employee emp = EntityMapper.convertObjectToEntity(edto);

		when(repo.findByName("Raghav"))
				.thenReturn(List.of(emp));

		List<EmployeeDTO> result = service.getEmployeeByName("Raghav");

		assertNotNull(result);
		assertFalse(result.isEmpty());

	}

	//remove
	@Test
	void testRemoveEmployee() {
		EmployeeDTO edto = new EmployeeDTO("Raghav",
				LocalDate.of(2003, 02, 01), 23000.00);

		edto.setEmployeeId(100);
		Employee emp = EntityMapper.convertObjectToEntity(edto);
		when(repo.findById(100)).thenReturn(Optional.of(emp));
		String result = service.removeEmployee(100);
		assertEquals("Employee Deleted", result);
		verify(repo).deleteById(100);

	}

	//create
	@Test
	void testCreateEmployeeId() {
		EmployeeDTO edto = new EmployeeDTO("Raghav",
				LocalDate.of(2003, 02, 01), 23000.00);

		//edto.setEmployeeId(100);
		Employee emp = EntityMapper.convertObjectToEntity(edto);
		when(repo.saveAndFlush(any(Employee.class))).thenReturn(emp);
		EmployeeDTO result = service.createEmployee(edto);
		assertEquals(edto.getEmployeeId(), result.getEmployeeId());
		assertEquals(edto.getFullName(), result.getFullName());
	}

	//update
	@Test
	void testUpdateEmployee() {
		EmployeeDTO edto = new EmployeeDTO("Raghav",
				LocalDate.of(2003, 02, 01), 23000.00);
		edto.setEmployeeId(100);
		Employee employee = new Employee("Rama", LocalDate.of(2003, 10, 02), 20000.0);
		employee.setEmpid(100);
		Optional<Employee> op = Optional.of(employee);
		when(repo.findById(100)).thenReturn(op);
		when(repo.saveAndFlush(any(Employee.class))).thenReturn(employee);
		EmployeeDTO update = service.updateEmployee(edto);
		assertNotNull(update);
		assertEquals("Raghav", update.getFullName());
	}



}