package com.payroll.backend.controller;

import com.payroll.backend.dto.TimeSheetsDTO;
import com.payroll.backend.dto.request.TimeSheetsRequestDTO;
import com.payroll.backend.service.TimeSheetsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/timesheets")
public class TimeSheetsController {

    @Autowired
    private TimeSheetsService timeSheetsService;

    @GetMapping
    public ResponseEntity<List<TimeSheetsDTO>> getAllTimeSheets() {
        return ResponseEntity.ok(timeSheetsService.getAllTimeSheets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimeSheetsDTO> getTimeSheetById(@PathVariable Long id) {
        return ResponseEntity.ok(timeSheetsService.getTimeSheetById(id));
    }

    @PostMapping
    public ResponseEntity<TimeSheetsDTO> createTimeSheet(@RequestBody TimeSheetsRequestDTO dto) {
        return ResponseEntity.ok(timeSheetsService.createTimeSheet(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TimeSheetsDTO> updateTimeSheet(@PathVariable Long id,
                                                         @RequestBody TimeSheetsRequestDTO dto) {
        return ResponseEntity.ok(timeSheetsService.updateTimeSheet(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTimeSheet(@PathVariable Long id) {
        timeSheetsService.deleteTimeSheet(id);
        return ResponseEntity.noContent().build();
    }
}

