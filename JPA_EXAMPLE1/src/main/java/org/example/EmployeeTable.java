package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="employee_table")
public class EmployeeTable {
    @Id
    private int eid;
    private String name;
    private String dept ;

}
