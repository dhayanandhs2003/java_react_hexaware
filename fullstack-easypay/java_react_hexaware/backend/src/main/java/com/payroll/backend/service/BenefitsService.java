package com.payroll.backend.service;

import com.payroll.backend.dto.BenefitsDTO;
import com.payroll.backend.dto.request.BenefitsRequestDTO;

import java.util.List;

public interface BenefitsService {
    List<BenefitsDTO> getAllBenefits();
    BenefitsDTO getBenefitById(Long benefitId);
    BenefitsDTO createBenefit(BenefitsRequestDTO requestDTO);
    BenefitsDTO updateBenefit(Long benefitId, BenefitsRequestDTO requestDTO);
    void deleteBenefit(Long benefitId);
}

