package com.example.MedicineInventoryManagement.service;

import com.example.MedicineInventoryManagement.dto.RequestRequestDto;
import com.example.MedicineInventoryManagement.dto.RequestResponseDto;
import com.example.MedicineInventoryManagement.entity.Request;

public interface RequestService {
    RequestResponseDto createRequest(RequestRequestDto requestRequestDto);
    RequestResponseDto getRequestById(Long requestId);
    RequestResponseDto deleteRequestById(Long requestId);
}