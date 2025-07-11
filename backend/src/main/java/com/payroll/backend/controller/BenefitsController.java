package com.payroll.backend.controller;

import com.payroll.backend.dto.BenefitsDTO;
import com.payroll.backend.dto.request.BenefitsRequestDTO;
import com.payroll.backend.service.BenefitsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/benefits")
public class BenefitsController {

    @Autowired
    private BenefitsService benefitsService;

    @GetMapping
    public ResponseEntity<List<BenefitsDTO>> getAllBenefits() {
        return ResponseEntity.ok(benefitsService.getAllBenefits());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BenefitsDTO> getBenefitById(@PathVariable Long id) {
        return ResponseEntity.ok(benefitsService.getBenefitById(id));
    }

    @PostMapping
    public ResponseEntity<BenefitsDTO> createBenefit(@RequestBody BenefitsRequestDTO dto) {
        return ResponseEntity.ok(benefitsService.createBenefit(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BenefitsDTO> updateBenefit(@PathVariable Long id,
                                                     @RequestBody BenefitsRequestDTO dto) {
        return ResponseEntity.ok(benefitsService.updateBenefit(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBenefit(@PathVariable Long id) {
        benefitsService.deleteBenefit(id);
        return ResponseEntity.noContent().build();
    }
}
