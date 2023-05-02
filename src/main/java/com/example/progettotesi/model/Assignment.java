package com.example.progettotesi.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assignment_id")
    private Long assignmentId;


}
