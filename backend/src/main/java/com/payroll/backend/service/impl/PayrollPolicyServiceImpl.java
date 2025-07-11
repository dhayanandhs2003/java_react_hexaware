package com.payroll.backend.service.impl;

import com.payroll.backend.dto.PayrollPolicyDTO;
import com.payroll.backend.dto.request.PayrollPolicyRequestDTO;
import com.payroll.backend.entity.PayrollPolicy;
import com.payroll.backend.repository.PayrollPolicyRepository;
import com.payroll.backend.service.PayrollPolicyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PayrollPolicyServiceImpl implements PayrollPolicyService {

    @Autowired
    private PayrollPolicyRepository policyRepository;

    private PayrollPolicyDTO convertToDTO(PayrollPolicy policy) {
        return new PayrollPolicyDTO(
                policy.getPolicyId(),
                policy.getPolicyName(),
                policy.getTaxRate(),
                policy.getBonusPercentage(),
                policy.getBenefitPercentage(),
                policy.getEffectiveFrom(),
                policy.getEffectiveTo()
        );
    }

    @Override
    public List<PayrollPolicyDTO> getAllPolicies() {
        return policyRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PayrollPolicyDTO getPolicyById(Long policyId) {
        PayrollPolicy policy = policyRepository.findById(policyId)
                .orElseThrow(() -> new RuntimeException("Policy not found with ID: " + policyId));
        return convertToDTO(policy);
    }

    @Override
    public PayrollPolicyDTO createPolicy(PayrollPolicyRequestDTO dto) {
        PayrollPolicy policy = new PayrollPolicy();
        policy.setPolicyName(dto.getPolicyName());
        policy.setTaxRate(dto.getTaxRate());
        policy.setBonusPercentage(dto.getBonusPercentage());
        policy.setBenefitPercentage(dto.getBenefitPercentage());
        policy.setEffectiveFrom(dto.getEffectiveFrom());
        policy.setEffectiveTo(dto.getEffectiveTo());

        return convertToDTO(policyRepository.save(policy));
    }

    @Override
    public PayrollPolicyDTO updatePolicy(Long policyId, PayrollPolicyRequestDTO dto) {
        PayrollPolicy policy = policyRepository.findById(policyId)
                .orElseThrow(() -> new RuntimeException("Policy not found with ID: " + policyId));

        policy.setPolicyName(dto.getPolicyName());
        policy.setTaxRate(dto.getTaxRate());
        policy.setBonusPercentage(dto.getBonusPercentage());
        policy.setBenefitPercentage(dto.getBenefitPercentage());
        policy.setEffectiveFrom(dto.getEffectiveFrom());
        policy.setEffectiveTo(dto.getEffectiveTo());

        return convertToDTO(policyRepository.save(policy));
    }

    @Override
    public void deletePolicy(Long policyId) {
        PayrollPolicy policy = policyRepository.findById(policyId)
                .orElseThrow(() -> new RuntimeException("Policy not found with ID: " + policyId));
        policyRepository.delete(policy);
    }
}

