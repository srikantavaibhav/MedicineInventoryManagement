package com.example.MedicineInventoryManagement.service;

import com.example.MedicineInventoryManagement.dto.RequestRequestDto;
import com.example.MedicineInventoryManagement.dto.RequestResponseDto;
import com.example.MedicineInventoryManagement.entity.Request;

import java.util.List;

public interface RequestService {
    RequestResponseDto createRequest(RequestRequestDto requestRequestDto);

    List<RequestResponseDto> getRequestList();

    RequestResponseDto updateRequest(Integer requestId, RequestRequestDto requestRequestDto);

    RequestResponseDto deleteRequest(Integer requestId);

}
