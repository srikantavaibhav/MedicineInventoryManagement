package com.example.MedicineInventoryManagement.service.Impl;

import com.example.MedicineInventoryManagement.dto.RequestRequestDto;
import com.example.MedicineInventoryManagement.dto.RequestResponseDto;
import com.example.MedicineInventoryManagement.entity.Request;
import com.example.MedicineInventoryManagement.repository.RequestRepository;
import com.example.MedicineInventoryManagement.service.RequestService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestRepository requestRepository;

    @Override
    public RequestResponseDto createRequest(RequestRequestDto requestRequestDto){
        Request request = new Request();

        BeanUtils.copyProperties(requestRequestDto, request);

        Request savedRequest = requestRepository.save(request);

        RequestResponseDto requestResponseDto = new RequestResponseDto();
        BeanUtils.copyProperties(savedRequest, requestResponseDto);

        return requestResponseDto;
    }

    @Override
    public List<RequestResponseDto> getRequestList(){
        List<Request> requestList = (List<Request>) requestRepository.findAll();
        List<RequestResponseDto>  requestResponseDtoList = new ArrayList<>();
        for(Request request: requestList)
        {
            RequestResponseDto requestResponseDto = new RequestResponseDto();
            BeanUtils.copyProperties(request, requestResponseDto);
            requestResponseDtoList.add(requestResponseDto);
        }
        return requestResponseDtoList;
    }

    @Override
    public RequestResponseDto updateRequest(Integer requestId, RequestRequestDto requestRequestDto){
        Optional<Request> requestOptionalFromDb = requestRepository.findById(requestId);
        if(requestOptionalFromDb.isPresent())
        {
            BeanUtils.copyProperties(requestRequestDto, requestOptionalFromDb.get());
            Request savedRequest = requestRepository.save(requestOptionalFromDb.get());
            RequestResponseDto requestResponseDto = new RequestResponseDto();
            BeanUtils.copyProperties(savedRequest, requestResponseDto);

            return requestResponseDto;
        }
        return null;
    }

    @Override
    public RequestResponseDto deleteRequest(Integer requestId){
        Optional<Request> requestOptionalFromDb = requestRepository.findById(requestId);
        if(requestOptionalFromDb.isPresent())
        {
            RequestResponseDto requestResponseDto = new RequestResponseDto();
            BeanUtils.copyProperties(requestOptionalFromDb.get(), requestResponseDto);
            requestRepository.deleteById(requestId);
            return requestResponseDto;
        }
        return null;
    }

}
