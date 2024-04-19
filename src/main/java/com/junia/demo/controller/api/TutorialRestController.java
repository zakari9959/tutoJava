package com.junia.demo.controller.api;

import com.junia.demo.repository.entity.Tutorial;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@RestController
public class TutorialRestController {
    @GetMapping("/api/tutorials")
    public ResponseEntity<List<Tutorial>> getTutorials() {
        List<Tutorial> tutorialList = new ArrayList<>();
        return ResponseEntity.status(HttpStatus.OK)
                .body(tutorialList);
    }
}
