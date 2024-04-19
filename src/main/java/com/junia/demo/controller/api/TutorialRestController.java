package com.junia.demo.controller.api;

import com.junia.demo.repository.entity.Tutorial;
import com.junia.demo.service.TutorialService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tutorials")
public class TutorialRestController {
    @Autowired
    private TutorialService tutorialService;

    @GetMapping
    public ResponseEntity<List<Tutorial>> getTutorials() {
        List<Tutorial> tutorials = tutorialService.getAllTutorials();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tutorials);
    }
    @PostMapping
    public ResponseEntity<Void> addTutorial(@Valid @RequestBody Tutorial tutorial) {
        tutorialService.addTutorial(tutorial);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tutorial> getTutorialById(@PathVariable Long id) {
        Optional<Tutorial> optTutorial = (tutorialService.fetchById(id));
        return optTutorial.map(tutorial -> ResponseEntity.status(HttpStatus.OK).body(tutorial)).orElse(null);
    }

}
