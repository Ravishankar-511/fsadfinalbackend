package com.fsad.repository;

import com.fsad.entity.ServiceRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRequestRepository extends JpaRepository<ServiceRequest, Long> {

    List<ServiceRequest> findByProfessionalName(String professionalName);

    List<ServiceRequest> findByUserName(String userName);
}