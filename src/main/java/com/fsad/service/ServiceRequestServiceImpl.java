package com.fsad.service;

import com.fsad.entity.ServiceRequest;
import com.fsad.repository.ServiceRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceRequestServiceImpl implements ServiceRequestService {

    @Autowired
    private ServiceRequestRepository repository;

    @Override
    public ServiceRequest createRequest(ServiceRequest request) {
        return repository.save(request);
    }

    @Override
    public List<ServiceRequest> getRequestsForProfessional(String professionalName) {
        return repository.findByProfessionalName(professionalName);
    }

    @Override
    public List<ServiceRequest> getRequestsForUser(String userName) {
        return repository.findByUserName(userName);
    }

    @Override
    public ServiceRequest updateStatus(Long id, String status) {
        ServiceRequest req = repository.findById(id).orElse(null);
        if (req != null) {
            req.setStatus(status);
            return repository.save(req);
        }
        return null;
    }
}