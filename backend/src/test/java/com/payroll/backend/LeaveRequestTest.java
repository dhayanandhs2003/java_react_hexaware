package com.payroll.backend;

import com.payroll.backend.entity.Employees;
import com.payroll.backend.entity.LeaveRequest;
import com.payroll.backend.enums.LeaveStatus;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class LeaveRequestTest {

    @Test
    public void testSettersAndGetters() {
        LeaveRequest leave = new LeaveRequest();

        Employees employee = new Employees();
        Employees manager = new Employees();

        LocalDate from = LocalDate.of(2025, 7, 20);
        LocalDate to = LocalDate.of(2025, 7, 25);
        LocalDate submitted = LocalDate.of(2025, 7, 15);

        leave.setLeaveId(1L);
        leave.setEmployee(employee);
        leave.setFromDate(from);
        leave.setToDate(to);
        leave.setReason("Medical leave");
        leave.setStatus(LeaveStatus.APPROVED);
        leave.setSubmittedOn(submitted);
        leave.setApprovedBy(manager);

        assertEquals(1L, leave.getLeaveId());
        assertEquals(employee, leave.getEmployee());
        assertEquals(from, leave.getFromDate());
        assertEquals(to, leave.getToDate());
        assertEquals("Medical leave", leave.getReason());
        assertEquals(LeaveStatus.APPROVED, leave.getStatus());
        assertEquals(submitted, leave.getSubmittedOn());
        assertEquals(manager, leave.getApprovedBy());
    }

    @Test
    public void testConstructor() {
        Employees emp = new Employees();
        Employees mgr = new Employees();

        LocalDate from = LocalDate.of(2025, 8, 10);
        LocalDate to = LocalDate.of(2025, 8, 12);
        LocalDate submitted = LocalDate.of(2025, 8, 5);

        LeaveRequest leave = new LeaveRequest(
                2L,
                emp,
                from,
                to,
                "Vacation",
                LeaveStatus.REJECTED,
                submitted,
                mgr
        );

        assertEquals(2L, leave.getLeaveId());
        assertEquals(emp, leave.getEmployee());
        assertEquals(from, leave.getFromDate());
        assertEquals(to, leave.getToDate());
        assertEquals("Vacation", leave.getReason());
        assertEquals(LeaveStatus.REJECTED, leave.getStatus());
        assertEquals(submitted, leave.getSubmittedOn());
        assertEquals(mgr, leave.getApprovedBy());
    }

    @Test
    public void testToStringIncludesKeyFields() {
        LeaveRequest leave = new LeaveRequest();
        leave.setLeaveId(3L);
        leave.setFromDate(LocalDate.of(2025, 9, 1));
        leave.setToDate(LocalDate.of(2025, 9, 5));
        leave.setReason("Conference");
        leave.setStatus(LeaveStatus.PENDING);
        leave.setSubmittedOn(LocalDate.of(2025, 8, 25));

        String output = leave.toString();

        assertTrue(output.contains("3"));
        assertTrue(output.contains("Conference"));
        assertTrue(output.contains("PENDING"));
        assertTrue(output.contains("2025-09-01"));
        assertTrue(output.contains("2025-09-05"));
    }
}