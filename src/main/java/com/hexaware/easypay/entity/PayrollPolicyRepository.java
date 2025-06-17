package com.hexaware.easypay.entity;

import com.hexaware.easypay.entity.PayrollPolicies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayrollPolicyRepository extends JpaRepository<PayrollPolicies, Integer> {
}

