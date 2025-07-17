package com.payroll.backend;

import com.payroll.backend.entity.Employees;
import com.payroll.backend.entity.TimeSheets;
import com.payroll.backend.enums.TimeSheetsStatus;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TimeSheetsTest {

    @Test
    public void testSettersAndGetters() {
        TimeSheets timeSheet = new TimeSheets();

        Employees employee = new Employees();
        LocalDate date = LocalDate.of(2025, 7, 1);

        timeSheet.setTimeSheetId(1L);
        timeSheet.setEmployees(employee);
        timeSheet.setDate(date);
        timeSheet.setHoursWorked(8.5);
        timeSheet.setStatus(TimeSheetsStatus.APPROVED);

        assertEquals(1L, timeSheet.getTimeSheetId());
        assertEquals(employee, timeSheet.getEmployees());
        assertEquals(date, timeSheet.getDate());
        assertEquals(8.5, timeSheet.getHoursWorked());
        assertEquals(TimeSheetsStatus.APPROVED, timeSheet.getStatus());
    }

    @Test
    public void testConstructor() {
        Employees emp = new Employees();
        LocalDate date = LocalDate.of(2025, 6, 30);

        TimeSheets ts = new TimeSheets(10L, emp, date, 7.25, TimeSheetsStatus.PENDING);

        assertEquals(10L, ts.getTimeSheetId());
        assertEquals(emp, ts.getEmployees());
        assertEquals(date, ts.getDate());
        assertEquals(7.25, ts.getHoursWorked());
        assertEquals(TimeSheetsStatus.PENDING, ts.getStatus());
    }

    @Test
    public void testToStringIncludesKeyFields() {
        TimeSheets timeSheet = new TimeSheets();
        timeSheet.setTimeSheetId(5L);
        timeSheet.setDate(LocalDate.of(2025, 7, 15));
        timeSheet.setHoursWorked(9.0);
        timeSheet.setStatus(TimeSheetsStatus.REJECTED);

        String result = timeSheet.toString();

        assertTrue(result.contains("5"));
        assertTrue(result.contains("2025-07-15"));
        assertTrue(result.contains("9.0"));
        assertTrue(result.contains("REJECTED"));
    }
}
