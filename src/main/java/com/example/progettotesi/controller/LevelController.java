package com.example.progettotesi.controller;

import com.example.progettotesi.model.Level;
import com.example.progettotesi.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/level")
public class LevelController {
    @Autowired
    private LevelService levelService;


    @PostMapping()
    public ResponseEntity<Level> saveLevel(@RequestBody Level level){
        return new ResponseEntity<Level>(levelService.saveLevel(level), HttpStatus.CREATED);
    }

    @GetMapping("/{level_id}")
    public ResponseEntity<Level> getLevelById(@PathVariable("level_id") Long levelId){
        return new ResponseEntity<Level>(levelService.getLevelById(levelId),HttpStatus.OK);
    }


}
