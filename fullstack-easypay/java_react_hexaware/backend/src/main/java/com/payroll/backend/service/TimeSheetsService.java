package com.payroll.backend.service;

import com.payroll.backend.dto.TimeSheetsDTO;
import com.payroll.backend.dto.request.TimeSheetsRequestDTO;

import java.util.List;

public interface TimeSheetsService {
    List<TimeSheetsDTO> getAllTimeSheets();
    TimeSheetsDTO getTimeSheetById(Long timeSheetId);
    TimeSheetsDTO createTimeSheet(TimeSheetsRequestDTO requestDTO);
    TimeSheetsDTO updateTimeSheet(Long timeSheetId, TimeSheetsRequestDTO requestDTO);
    void deleteTimeSheet(Long timeSheetId);
}

