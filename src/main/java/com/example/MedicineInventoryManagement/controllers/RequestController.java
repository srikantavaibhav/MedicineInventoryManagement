package com.example.MedicineInventoryManagement.controllers;


import com.example.MedicineInventoryManagement.dto.RequestRequestDto;
import com.example.MedicineInventoryManagement.dto.RequestResponseDto;
import com.example.MedicineInventoryManagement.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/request")
public class RequestController {

    @Autowired
    private RequestService requestService;

    //POST - /request/createRequest
    @CrossOrigin
    @PostMapping("/createRequest")
    public RequestResponseDto createRequest(@RequestBody RequestRequestDto requestRequestDto){
        return requestService.createRequest(requestRequestDto);
    }

    //GET - /request/viewRequestList
    @CrossOrigin
    @GetMapping("/viewRequestList")
    public List<RequestResponseDto> getRequestList(){
        return requestService.getRequestList();
    }

    //PUT - /request/updateRequest/{requestId}
    @CrossOrigin
    @PutMapping("/updateRequest/{requestId}")
    public RequestResponseDto updateRequest(@PathVariable("requestId") Integer requestId, @RequestBody RequestRequestDto requestRequestDto){
        return requestService.updateRequest(requestId, requestRequestDto);
    }

    //DELETE - /request/deleteRequest/{requestId}
    @CrossOrigin
    @DeleteMapping("/deleteRequest/{requestId}")
    public RequestResponseDto deleteRequest(@PathVariable("requestId") Integer requestId){
        return requestService.deleteRequest(requestId);
    }

}
