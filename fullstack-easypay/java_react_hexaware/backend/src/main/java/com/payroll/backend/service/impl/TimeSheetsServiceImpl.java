package com.payroll.backend.service.impl;

import com.payroll.backend.dto.TimeSheetsDTO;
import com.payroll.backend.dto.request.TimeSheetsRequestDTO;
import com.payroll.backend.entity.Employees;
import com.payroll.backend.entity.TimeSheets;
import com.payroll.backend.repository.EmployeesRepository;
import com.payroll.backend.repository.TimeSheetRepository;
import com.payroll.backend.service.TimeSheetsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TimeSheetsServiceImpl implements TimeSheetsService {

    @Autowired
    private TimeSheetRepository timeSheetRepository;

    @Autowired
    private EmployeesRepository employeeRepository;

    private TimeSheetsDTO convertToDTO(TimeSheets timeSheet) {
        return new TimeSheetsDTO(
                timeSheet.getTimeSheetId(),
                timeSheet.getEmployees().getEmployeeId(),
                timeSheet.getDate(),
                timeSheet.getHoursWorked(),
                timeSheet.getStatus()
        );
    }

    @Override
    public List<TimeSheetsDTO> getAllTimeSheets() {
        return timeSheetRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TimeSheetsDTO getTimeSheetById(Long id) {
        TimeSheets timeSheet = timeSheetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Timesheet not found with ID: " + id));
        return convertToDTO(timeSheet);
    }

    @Override
    public TimeSheetsDTO createTimeSheet(TimeSheetsRequestDTO dto) {
        Employees employee = employeeRepository.findById(dto.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + dto.getEmployeeId()));

        TimeSheets timeSheet = new TimeSheets();
        timeSheet.setEmployees(employee);
        timeSheet.setDate(dto.getDate());
        timeSheet.setHoursWorked(dto.getHoursWorked());
        timeSheet.setStatus(dto.getStatus());

        return convertToDTO(timeSheetRepository.save(timeSheet));
    }

    @Override
    public TimeSheetsDTO updateTimeSheet(Long id, TimeSheetsRequestDTO dto) {
        TimeSheets timeSheet = timeSheetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Timesheet not found with ID: " + id));

        Employees employee = employeeRepository.findById(dto.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + dto.getEmployeeId()));

        timeSheet.setEmployees(employee);
        timeSheet.setDate(dto.getDate());
        timeSheet.setHoursWorked(dto.getHoursWorked());
        timeSheet.setStatus(dto.getStatus());

        return convertToDTO(timeSheetRepository.save(timeSheet));
    }

    @Override
    public void deleteTimeSheet(Long id) {
        TimeSheets timeSheet = timeSheetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Timesheet not found with ID: " + id));
        timeSheetRepository.delete(timeSheet);
    }
}

