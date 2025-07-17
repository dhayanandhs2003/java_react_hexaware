package com.payroll.backend;

import org.junit.jupiter.api.Test;

import com.payroll.backend.entity.PayrollPolicy;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class PayrollPolicyTest {

    @Test
    public void testSettersAndGetters() {
        PayrollPolicy policy = new PayrollPolicy();

        policy.setPolicyId(1L);
        policy.setPolicyName("Standard Policy");
        policy.setTaxRate(new BigDecimal("10.5"));
        policy.setBonusPercentage(new BigDecimal("5.0"));
        policy.setBenefitPercentage(new BigDecimal("7.5"));
        policy.setEffectiveFrom(LocalDate.of(2023, 1, 1));
        policy.setEffectiveTo(LocalDate.of(2023, 12, 31));

        assertEquals(1L, policy.getPolicyId());
        assertEquals("Standard Policy", policy.getPolicyName());
        assertEquals(new BigDecimal("10.5"), policy.getTaxRate());
        assertEquals(new BigDecimal("5.0"), policy.getBonusPercentage());
        assertEquals(new BigDecimal("7.5"), policy.getBenefitPercentage());
        assertEquals(LocalDate.of(2023, 1, 1), policy.getEffectiveFrom());
        assertEquals(LocalDate.of(2023, 12, 31), policy.getEffectiveTo());
    }

    @Test
    public void testConstructor() {
        PayrollPolicy policy = new PayrollPolicy(
                2L,
                "New Policy",
                new BigDecimal("12.0"),
                new BigDecimal("4.0"),
                new BigDecimal("6.0"),
                LocalDate.of(2024, 1, 1),
                LocalDate.of(2024, 12, 31)
        );

        assertEquals(2L, policy.getPolicyId());
        assertEquals("New Policy", policy.getPolicyName());
        assertEquals(new BigDecimal("12.0"), policy.getTaxRate());
        assertEquals(new BigDecimal("4.0"), policy.getBonusPercentage());
        assertEquals(new BigDecimal("6.0"), policy.getBenefitPercentage());
        assertEquals(LocalDate.of(2024, 1, 1), policy.getEffectiveFrom());
        assertEquals(LocalDate.of(2024, 12, 31), policy.getEffectiveTo());
    }

    @Test
    public void testToStringIncludesFields() {
        PayrollPolicy policy = new PayrollPolicy();
        policy.setPolicyId(5L);
        policy.setPolicyName("Flexible Plan");
        policy.setTaxRate(new BigDecimal("15.0"));

        String result = policy.toString();

        assertTrue(result.contains("Flexible Plan"));
        assertTrue(result.contains("15.0"));
        assertTrue(result.contains("policyId=5"));
    }
}
