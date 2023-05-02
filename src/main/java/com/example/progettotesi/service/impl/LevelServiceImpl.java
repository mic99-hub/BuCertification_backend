package com.example.progettotesi.service.impl;

import com.example.progettotesi.exception.ResourceNotFoundException;
import com.example.progettotesi.model.Level;
import com.example.progettotesi.repository.LevelRepository;
import com.example.progettotesi.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class LevelServiceImpl implements LevelService {

    private LevelRepository levelRepository;

    @Autowired
    public LevelServiceImpl(LevelRepository levelRepository){
        super();
        this.levelRepository=levelRepository;
    }

    @Override
    public Level saveLevel(Level level) {
        return levelRepository.save(level);
    }

    @Override
    public Level getLevelById(long levelId) {
        return levelRepository.findById(levelId).orElseThrow(() ->
                new ResourceNotFoundException("Level","Id",levelId));
    }
}
