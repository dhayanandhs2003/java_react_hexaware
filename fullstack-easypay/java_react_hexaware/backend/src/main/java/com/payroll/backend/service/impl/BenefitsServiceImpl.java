package com.payroll.backend.service.impl;

import com.payroll.backend.dto.BenefitsDTO;
import com.payroll.backend.dto.request.BenefitsRequestDTO;
import com.payroll.backend.entity.Benefits;
import com.payroll.backend.entity.Employees;
import com.payroll.backend.repository.BenefitRepository;
import com.payroll.backend.repository.EmployeesRepository;
import com.payroll.backend.service.BenefitsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BenefitsServiceImpl implements BenefitsService {

    @Autowired
    private BenefitRepository benefitRepository;

    @Autowired
    private EmployeesRepository employeeRepository;

    private BenefitsDTO convertToDTO(Benefits benefit) {
        return new BenefitsDTO(
                benefit.getBenefitId(),
                benefit.getEmployee().getEmployeeId(),
                benefit.getType(),
                benefit.getBenefit(),
                benefit.getEffectiveDate()
        );
    }

    @Override
    public List<BenefitsDTO> getAllBenefits() {
        return benefitRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BenefitsDTO getBenefitById(Long benefitId) {
        Benefits benefit = benefitRepository.findById(benefitId)
                .orElseThrow(() -> new RuntimeException("Benefit not found with ID: " + benefitId));
        return convertToDTO(benefit);
    }

    @Override
    public BenefitsDTO createBenefit(BenefitsRequestDTO requestDTO) {
        Employees employee = employeeRepository.findById(requestDTO.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + requestDTO.getEmployeeId()));

        Benefits benefit = new Benefits();
        benefit.setEmployee(employee);
        benefit.setType(requestDTO.getType());
        benefit.setBenefit(requestDTO.getBenefit());
        benefit.setEffectiveDate(requestDTO.getEffectiveDate());

        return convertToDTO(benefitRepository.save(benefit));
    }

    @Override
    public BenefitsDTO updateBenefit(Long benefitId, BenefitsRequestDTO requestDTO) {
        Benefits benefit = benefitRepository.findById(benefitId)
                .orElseThrow(() -> new RuntimeException("Benefit not found with ID: " + benefitId));

        Employees employee = employeeRepository.findById(requestDTO.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + requestDTO.getEmployeeId()));

        benefit.setEmployee(employee);
        benefit.setType(requestDTO.getType());
        benefit.setBenefit(requestDTO.getBenefit());
        benefit.setEffectiveDate(requestDTO.getEffectiveDate());

        return convertToDTO(benefitRepository.save(benefit));
    }

    @Override
    public void deleteBenefit(Long benefitId) {
        Benefits benefit = benefitRepository.findById(benefitId)
                .orElseThrow(() -> new RuntimeException("Benefit not found with ID: " + benefitId));
        benefitRepository.delete(benefit);
    }
}

