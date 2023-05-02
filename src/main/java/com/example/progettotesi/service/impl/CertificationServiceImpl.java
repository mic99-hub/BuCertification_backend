package com.example.progettotesi.service.impl;

import com.example.progettotesi.exception.ResourceNotFoundException;
import com.example.progettotesi.model.Certification;
import com.example.progettotesi.repository.CertificationRepository;
import com.example.progettotesi.service.CertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificationServiceImpl implements CertificationService {

    private CertificationRepository certificationRepository;

    @Autowired
    public CertificationServiceImpl(CertificationRepository certificationRepository){
        super();
        this.certificationRepository=certificationRepository;
    }

    @Override
    public Certification saveCertification(Certification certification) {
        return certificationRepository.save(certification);
    }

    @Override
    public List<Certification> getAllCertification() {
        return certificationRepository.findAll();
    }

    @Override
    public Certification getCertificationById(long certificationId){
        return certificationRepository.findById(certificationId).orElseThrow(() ->
                new ResourceNotFoundException("Certification","Id",certificationId));
    }

    @Override
    public Certification updateCertification(Certification certification, Long certificationId) {
        Certification existingCertification = certificationRepository.findById(certificationId).orElseThrow(
                ()-> new ResourceNotFoundException("Certification","Id",certificationId));
        existingCertification.setCertificationName(certification.getCertificationName());
        existingCertification.setType(certification.getType());
        existingCertification.setScope(certification.getScope());
        existingCertification.setDuration(certification.getDuration());

        certificationRepository.save(existingCertification);

        return existingCertification ;
    }

    @Override
    public void deleteCertification(long certificationId) {
        certificationRepository.findById(certificationId).orElseThrow(()
                -> new ResourceNotFoundException("Certification","Id",certificationId));

        certificationRepository.deleteById(certificationId);

    }


}
