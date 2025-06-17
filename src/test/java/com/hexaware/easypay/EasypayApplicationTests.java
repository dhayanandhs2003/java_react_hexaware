package com.hexaware.easypay;

import com.hexaware.easypay.entity.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class EasypayApplicationTests {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private EmployeesRepository employeesRepository;
    
    @Autowired
    private PayrollRepository payrollRepository;

    @Test
    void testInsertUser() {
        Users user = new Users();
        user.setUsername("Dhaya");
        user.setEmail("dhaya@easypay.com");
        user.setPassword("12345");
        user.setRole("user");

        usersRepository.save(user);
        assertThat(usersRepository.findAll()).isNotEmpty();
    }

    @Test
    void testInsertEmployee() {
        Employees emp = new Employees();
        emp.setFirstName("Nandita");
        emp.setLastName("S");
        emp.setEmail("nan@easypay.com");
        emp.setPhone("1234567890");
        emp.setHireDate(LocalDate.now());
        emp.setDepartment("employee");

        employeesRepository.save(emp);
        assertThat(employeesRepository.findAll()).isNotEmpty();
    }
    
    @Test
    void testInsertPayroll() {
        Payroll payroll = new Payroll();
        payroll.setEmployeeId(2); // Must match an existing employee_id in your DB
        payroll.setMonth("June");
        payroll.setYear(2025);
        payroll.setBaseSalary(new BigDecimal("30000.00"));
        payroll.setBenefits(new BigDecimal("5000.00"));
        payroll.setTax(new BigDecimal("2000.00"));
        payroll.setNetPay(new BigDecimal("33000.00")); // base + benefits - tax
        payroll.setGeneratedOn(LocalDate.now());

        payrollRepository.save(payroll);

        assertThat(payrollRepository.findAll()).isNotEmpty();
    }
}

