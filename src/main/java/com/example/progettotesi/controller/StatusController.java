package com.example.progettotesi.controller;

import com.example.progettotesi.model.Status;
import com.example.progettotesi.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @PostMapping()
    public ResponseEntity<Status> saveStatus(@RequestBody Status status){
        return new ResponseEntity<Status>(statusService.saveStatus(status), HttpStatus.CREATED);
    }

}
