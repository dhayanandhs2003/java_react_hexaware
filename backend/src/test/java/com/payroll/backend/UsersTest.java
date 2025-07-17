package com.payroll.backend;

import com.payroll.backend.entity.Employees;
import com.payroll.backend.entity.Users;
import com.payroll.backend.enums.UserRole;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class UsersTest {

    @Test
    public void testUserEntity_SettersAndGetters() {
        Users user = new Users();
        Long userId = 1L;
        String userName = "John Doe";
        String email = "john@example.com";
        String password = "secret123";
        UserRole role = UserRole.EMPLOYEE;
        Date createdAt = new Date();
        Employees employee = new Employees();

        user.setUserId(userId);
        user.setUserName(userName);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);
        user.setCreatedAt(createdAt);
        user.setEmployees(employee);

        assertEquals(userId, user.getUserId());
        assertEquals(userName, user.getUserName());
        assertEquals(email, user.getEmail());
        assertEquals(password, user.getPassword());
        assertEquals(role, user.getRole());
        assertEquals(createdAt, user.getCreatedAt());
        assertEquals(employee, user.getEmployees());
    }

    @Test
    public void testUserEntity_Constructor() {
        Date now = new Date();
        Employees employee = new Employees();

        Users user = new Users(2L, "Jane", "jane@example.com", "pass456", UserRole.ADMIN_HR, now, employee);

        assertEquals(2L, user.getUserId());
        assertEquals("Jane", user.getUserName());
        assertEquals("jane@example.com", user.getEmail());
        assertEquals("pass456", user.getPassword());
        assertEquals(UserRole.ADMIN_HR, user.getRole());
        assertEquals(now, user.getCreatedAt());
        assertEquals(employee, user.getEmployees());
    }

    @Test
    public void testToStringContainsFields() {
        Users user = new Users();
        user.setUserId(5L);
        user.setUserName("Alice");
        user.setEmail("alice@payroll.com");
        user.setRole(UserRole.EMPLOYEE);
        user.setCreatedAt(new Date());

        String toString = user.toString();
        assertTrue(toString.contains("Alice"));
        assertTrue(toString.contains("alice@payroll.com"));
        assertTrue(toString.contains("EMPLOYEE"));
    }
}


