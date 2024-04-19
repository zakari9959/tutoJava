package com.junia.demo.service;

import com.junia.demo.repository.TutorialRepository;
import com.junia.demo.repository.entity.Author;
import com.junia.demo.repository.entity.Tutorial;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TutorialService {
    private final TutorialRepository tutorialRepository;

    public TutorialService(TutorialRepository tutorialRepository, HttpSession httpSession) {
        this.tutorialRepository = tutorialRepository;
    }


    public List<Tutorial> getAllTutorials() {
        return (List<Tutorial>) tutorialRepository.findAll();
    }

    public Tutorial getTutorialById(long id) {
        tutorialRepository.findById(id);
        return null;
    }
    public Optional<Tutorial> fetchById(long id) {
        return tutorialRepository.findById(id);
    }

    public void addTutorial(Tutorial tutorial) {
            tutorial.setCreateDate(LocalDate.now());
            tutorialRepository.save(tutorial);
    }
   public Tutorial updateTutorial(long id, Tutorial updatedTutorial) {
        tutorialRepository.findById(id);
        tutorialRepository.save(updatedTutorial);
        return null;
    }

    public boolean deleteTutorial(long id) {
        tutorialRepository.deleteById(id);
        return true;
    }
}
