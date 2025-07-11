package com.payroll.backend.service;

import com.payroll.backend.dto.PayrollPolicyDTO;
import com.payroll.backend.dto.request.PayrollPolicyRequestDTO;

import java.util.List;

public interface PayrollPolicyService {
    List<PayrollPolicyDTO> getAllPolicies();
    PayrollPolicyDTO getPolicyById(Long policyId);
    PayrollPolicyDTO createPolicy(PayrollPolicyRequestDTO requestDTO);
    PayrollPolicyDTO updatePolicy(Long policyId, PayrollPolicyRequestDTO requestDTO);
    void deletePolicy(Long policyId);
}

