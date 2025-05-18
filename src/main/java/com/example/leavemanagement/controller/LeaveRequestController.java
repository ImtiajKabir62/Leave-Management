package com.example.leavemanagement.controller;

import com.example.leavemanagement.model.LeaveRequest;
import com.example.leavemanagement.service.LeaveRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leaves")
public class LeaveRequestController {

    @Autowired
    private LeaveRequestService service;

    @PostMapping("/apply")
    public ResponseEntity<LeaveRequest> applyLeave(@RequestBody LeaveRequest request) {
        return ResponseEntity.ok(service.applyLeave(request));
    }

    @GetMapping("/all")
    public ResponseEntity<List<LeaveRequest>> getAll() {
        return ResponseEntity.ok(service.getAllRequests());
    }

    @PutMapping("/status/{id}")
    public ResponseEntity<LeaveRequest> updateStatus(@PathVariable Long id, @RequestParam String status) {
        return ResponseEntity.ok(service.updateStatus(id, status));
    }
}