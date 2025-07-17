package com.payroll.backend;

import com.payroll.backend.entity.Benefits;
import com.payroll.backend.entity.Employees;
import com.payroll.backend.enums.BenefitType;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class BenefitsTest {

    @Test
    public void testSettersAndGetters() {
        Benefits benefit = new Benefits();

        Employees employee = new Employees();
        LocalDate date = LocalDate.of(2025, 8, 1);

        benefit.setBenefitId(10L);
        benefit.setEmployee(employee);
        benefit.setType("Health");
        benefit.setBenefit(BenefitType.HEALTH);
        benefit.setEffectiveDate(date);

        assertEquals(10L, benefit.getBenefitId());
        assertEquals(employee, benefit.getEmployee());
        assertEquals("Health", benefit.getType());
        assertEquals(BenefitType.HEALTH, benefit.getBenefit());
        assertEquals(date, benefit.getEffectiveDate());
    }

    @Test
    public void testConstructor() {
        Employees emp = new Employees();
        LocalDate date = LocalDate.of(2025, 9, 15);

        Benefits b = new Benefits(20L, emp, "Travel", BenefitType.TRAVEL, date);

        assertEquals(20L, b.getBenefitId());
        assertEquals(emp, b.getEmployee());
        assertEquals("Travel", b.getType());
        assertEquals(BenefitType.TRAVEL, b.getBenefit());
        assertEquals(date, b.getEffectiveDate());
    }

    @Test
    public void testToStringIncludesFields() {
        Benefits benefit = new Benefits();
        benefit.setBenefitId(5L);
        benefit.setType("Food");
        benefit.setBenefit(BenefitType.MEAL);
        benefit.setEffectiveDate(LocalDate.of(2025, 7, 20));

        String result = benefit.toString();

        assertTrue(result.contains("Food"));
        assertTrue(result.contains("MEAL"));
        assertTrue(result.contains("2025-07-20"));
        assertTrue(result.contains("5"));
    }
}
