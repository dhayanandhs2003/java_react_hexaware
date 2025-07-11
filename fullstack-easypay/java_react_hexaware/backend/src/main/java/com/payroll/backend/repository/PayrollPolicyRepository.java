package com.payroll.backend.repository;

import com.payroll.backend.entity.PayrollPolicy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayrollPolicyRepository extends JpaRepository<PayrollPolicy, Long> {

//    // Optional: If you want to fetch by name
//    PayrollPolicy findByPolicyName(String policyName);
}

