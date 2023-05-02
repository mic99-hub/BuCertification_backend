package com.example.progettotesi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name",nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;
    @OneToOne
    @JoinColumn(name = "level_id")
    private Level level;

    @Column(name = "company_residence")
    private String companyResidence;

    @Column( name = "assumption_date")
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date asssumptionDate;

    @OneToOne
    @JoinColumn(name = "assignment_id")
    private Assignment assignment;











}
