package com.example.progettotesi.controller;

import com.example.progettotesi.model.Certification;
import com.example.progettotesi.service.CertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@ControllerAdvice
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/certification")
public class CertificationController {

    @Autowired
    private CertificationService certificationService;


    @PostMapping("/save")
    public ResponseEntity<Certification> saveCertification(@RequestBody Certification certification){
        return new ResponseEntity<Certification>(certificationService.saveCertification(certification) , HttpStatus.CREATED);
    }

    @GetMapping()
    List<Certification> getAllCertification(){
        return certificationService.getAllCertification();
    }

    @GetMapping("/{certificationId}")
    public ResponseEntity<Certification> getCertificationById(@PathVariable("certificationId") Long certificationId){
        return new ResponseEntity<Certification>(certificationService.getCertificationById(certificationId),HttpStatus.OK);
    }

    @PutMapping("/{certificationId}")
    public ResponseEntity<Certification> updateCertification(@PathVariable("certificationId") Long certificationId
            ,@RequestBody Certification certification){
        return new ResponseEntity<Certification>(certificationService.updateCertification(certification,certificationId),HttpStatus.OK);
    }

    @DeleteMapping("/{certificationId}")
    public ResponseEntity<String> deleteCertification(@PathVariable("certificationId") Long certificationId){

        certificationService.deleteCertification(certificationId);

        return new ResponseEntity<String>("certification deleted successfully !",HttpStatus.OK);
    }








}
