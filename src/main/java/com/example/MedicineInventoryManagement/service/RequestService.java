package com.example.MedicineInventoryManagement.service;

import com.example.MedicineInventoryManagement.dto.RequestRequestDto;
import com.example.MedicineInventoryManagement.dto.RequestResponseDto;
import com.example.MedicineInventoryManagement.entity.Request;

import java.util.List;

public interface RequestService {
    RequestResponseDto createRequest(RequestRequestDto requestRequestDto);

    List<RequestResponseDto> getRequestList();

    RequestResponseDto updateRequest(Long requestId, RequestRequestDto requestRequestDto);

    RequestResponseDto deleteRequest(Long requestId);
//    RequestResponseDto getRequestById(Long requestId);
//    RequestResponseDto deleteRequestById(Long requestId);
}
