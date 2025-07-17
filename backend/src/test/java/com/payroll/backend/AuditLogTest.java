package com.payroll.backend;

import org.junit.jupiter.api.Test;

import com.payroll.backend.entity.AuditLog;
import com.payroll.backend.entity.Users;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class AuditLogTest {

    @Test
    public void testSettersAndGetters() {
        AuditLog log = new AuditLog();

        Users user = new Users();
        LocalDateTime timestamp = LocalDateTime.of(2025, 7, 16, 10, 45);

        log.setLogId(100L);
        log.setUser(user);
        log.setAction("LOGIN");
        log.setTimestamp(timestamp);
        log.setDetails("User logged into the system.");

        assertEquals(100L, log.getLogId());
        assertEquals(user, log.getUser());
        assertEquals("LOGIN", log.getAction());
        assertEquals(timestamp, log.getTimestamp());
        assertEquals("User logged into the system.", log.getDetails());
    }

    @Test
    public void testConstructor() {
        Users user = new Users();
        LocalDateTime timestamp = LocalDateTime.of(2025, 7, 15, 22, 30);

        AuditLog log = new AuditLog(
                200L,
                user,
                "UPDATE",
                timestamp,
                "User updated payroll info."
        );

        assertEquals(200L, log.getLogId());
        assertEquals(user, log.getUser());
        assertEquals("UPDATE", log.getAction());
        assertEquals(timestamp, log.getTimestamp());
        assertEquals("User updated payroll info.", log.getDetails());
    }

    @Test
    public void testToStringIncludesKeyFields() {
        AuditLog log = new AuditLog();
        log.setLogId(300L);
        log.setAction("DELETE");
        log.setTimestamp(LocalDateTime.of(2025, 7, 10, 9, 0));
        log.setDetails("User deleted employee record.");

        String str = log.toString();

        assertTrue(str.contains("DELETE"));
        assertTrue(str.contains("employee record"));
        assertTrue(str.contains("300"));
        assertTrue(str.contains("2025-07-10"));
    }
}
