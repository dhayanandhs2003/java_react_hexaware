package com.payroll.backend;

import com.payroll.backend.entity.Employees;
import com.payroll.backend.entity.Users;
import com.payroll.backend.enums.EmployeeStatus;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeesTest {

    @Test
    public void testEmployees_SettersAndGetters() {
        Employees employee = new Employees();
        Users user = new Users();
        Employees manager = new Employees();
        LocalDate dob = LocalDate.of(1995, 6, 15);
        LocalDate hireDate = LocalDate.of(2023, 1, 1);

        employee.setEmployeeId(1L);
        employee.setUser(user);
        employee.setFirstName("John");
        employee.setLastName("Doe");
        employee.setEmail("john.doe@example.com");
        employee.setPhone("1234567890");
        employee.setDepartment("HR");
        employee.setHireDate(hireDate);
        employee.setDob(dob);
        employee.setDesignation("Manager");
        employee.setStatus(EmployeeStatus.ACTIVE);
        employee.setManager(manager);

        assertEquals(1L, employee.getEmployeeId());
        assertEquals(user, employee.getUser());
        assertEquals("John", employee.getFirstName());
        assertEquals("Doe", employee.getLastName());
        assertEquals("john.doe@example.com", employee.getEmail());
        assertEquals("1234567890", employee.getPhone());
        assertEquals("HR", employee.getDepartment());
        assertEquals(hireDate, employee.getHireDate());
        assertEquals(dob, employee.getDob());
        assertEquals("Manager", employee.getDesignation());
        assertEquals(EmployeeStatus.ACTIVE, employee.getStatus());
        assertEquals(manager, employee.getManager());
    }

    @Test
    public void testEmployees_Constructor() {
        Users user = new Users();
        Employees manager = new Employees();
        LocalDate dob = LocalDate.of(1990, 5, 20);
        LocalDate hireDate = LocalDate.of(2022, 9, 1);

        Employees emp = new Employees(10L, user, "Alice", "Smith", "alice@example.com", "9876543210",
                "Finance", hireDate, dob, "Analyst", EmployeeStatus.INACTIVE, manager);

        assertEquals(10L, emp.getEmployeeId());
        assertEquals(user, emp.getUser());
        assertEquals("Alice", emp.getFirstName());
        assertEquals("Smith", emp.getLastName());
        assertEquals("alice@example.com", emp.getEmail());
        assertEquals("9876543210", emp.getPhone());
        assertEquals("Finance", emp.getDepartment());
        assertEquals(hireDate, emp.getHireDate());
        assertEquals(dob, emp.getDob());
        assertEquals("Analyst", emp.getDesignation());
        assertEquals(EmployeeStatus.INACTIVE, emp.getStatus());
        assertEquals(manager, emp.getManager());
    }

    @Test
    public void testToStringContainsKeyFields() {
        Employees emp = new Employees();
        emp.setFirstName("Bob");
        emp.setLastName("Brown");
        emp.setEmail("bob@company.com");
        emp.setStatus(EmployeeStatus.ACTIVE);

        String str = emp.toString();

        assertTrue(str.contains("Bob"));
        assertTrue(str.contains("Brown"));
        assertTrue(str.contains("bob@company.com"));
        assertTrue(str.contains("ACTIVE"));
    }
}
