package com.example.progettotesi.service;

import com.example.progettotesi.model.Certification;

import java.util.List;

public interface CertificationService {

    Certification saveCertification(Certification certification);
    List<Certification> getAllCertification();
    Certification getCertificationById(long certificationId );
    Certification updateCertification(Certification certification , Long certificationId );
    void deleteCertification(long certificationId);


}
