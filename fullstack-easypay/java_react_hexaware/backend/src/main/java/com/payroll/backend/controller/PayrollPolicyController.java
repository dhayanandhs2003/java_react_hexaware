package com.payroll.backend.controller;

import com.payroll.backend.dto.PayrollPolicyDTO;
import com.payroll.backend.dto.request.PayrollPolicyRequestDTO;
import com.payroll.backend.service.PayrollPolicyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policies")
public class PayrollPolicyController {

    @Autowired
    private PayrollPolicyService policyService;

    @GetMapping
    public ResponseEntity<List<PayrollPolicyDTO>> getAllPolicies() {
        return ResponseEntity.ok(policyService.getAllPolicies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PayrollPolicyDTO> getPolicyById(@PathVariable Long id) {
        return ResponseEntity.ok(policyService.getPolicyById(id));
    }

    @PostMapping
    public ResponseEntity<PayrollPolicyDTO> createPolicy(@RequestBody PayrollPolicyRequestDTO dto) {
        return ResponseEntity.ok(policyService.createPolicy(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PayrollPolicyDTO> updatePolicy(@PathVariable Long id,
                                                         @RequestBody PayrollPolicyRequestDTO dto) {
        return ResponseEntity.ok(policyService.updatePolicy(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePolicy(@PathVariable Long id) {
        policyService.deletePolicy(id);
        return ResponseEntity.noContent().build();
    }
}
