package com.example.progettotesi.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "level_id")
    private Long levelId;

    @Column(name = "level_definition")
    private String levelDefinition;




}
