package com.example.progettotesi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id")
    private Long statusId;

    @Enumerated(EnumType.STRING)
    @Column(name = "phase")
    private Phase phase;

    @Column(name = "date")
    private Date date;

}
