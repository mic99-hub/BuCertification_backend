package com.example.progettotesi.service.impl;

import com.example.progettotesi.model.Status;
import com.example.progettotesi.repository.StatusRepository;
import com.example.progettotesi.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusServiceImpl implements StatusService {

    private StatusRepository statusRepository;

    @Autowired
    public StatusServiceImpl(StatusRepository statusRepository){
        super();
        this.statusRepository = statusRepository;
    }


    @Override
    public Status saveStatus(Status status) {
        return statusRepository.save(status);
    }
}
