package com.example.leavemanagement.service;

import com.example.leavemanagement.model.LeaveRequest;
import com.example.leavemanagement.repository.LeaveRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveRequestService {

    @Autowired
    private LeaveRequestRepository repository;

    public LeaveRequest applyLeave(LeaveRequest request) {
        return repository.save(request);
    }

    public List<LeaveRequest> getAllRequests() {
        return repository.findAll();
    }

    public LeaveRequest updateStatus(Long id, String status) {
        LeaveRequest request = repository.findById(id).orElseThrow();
        request.setStatus(status.toUpperCase());
        return repository.save(request);
    }
}