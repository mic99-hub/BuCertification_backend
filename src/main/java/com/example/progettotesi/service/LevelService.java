package com.example.progettotesi.service;

import com.example.progettotesi.model.Level;

import java.util.Optional;

public interface LevelService {

    Level saveLevel(Level level);
    Level getLevelById(long levelId);
}
