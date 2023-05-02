package com.example.progettotesi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table
public class Certification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long certificationId;

    @Column(name ="certification_name" , nullable = false )
    private String certificationName;

    @Column(name = "type")
    private String type;

    @Column(name = "scope")
    private String scope;

    @Column(name = "duration")
    private String duration;

    @OneToOne
    @JoinColumn(name = "assignment_id")
    private Assignment assignment;

    @OneToMany(cascade = CascadeType.ALL )
    @JoinColumn(name = "certification_fkid")
    private List<Status> status;


}
