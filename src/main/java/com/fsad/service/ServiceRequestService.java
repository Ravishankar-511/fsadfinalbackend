package com.fsad.service;

import com.fsad.entity.ServiceRequest;
import java.util.List;

public interface ServiceRequestService {

    ServiceRequest createRequest(ServiceRequest request);

    List<ServiceRequest> getRequestsForProfessional(String professionalName);

    List<ServiceRequest> getRequestsForUser(String userName);

    ServiceRequest updateStatus(Long id, String status);
}