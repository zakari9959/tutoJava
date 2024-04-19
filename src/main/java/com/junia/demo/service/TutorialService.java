package com.junia.demo.service;

import com.fasterxml.jackson.databind.DatabindContext;
import com.junia.demo.repository.TutorialRepository;
import com.junia.demo.repository.entity.Author;
import com.junia.demo.repository.entity.Tutorial;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TutorialService {
    private final TutorialRepository tutorialRepository;
    private final AuthorService authorService;

    public TutorialService(TutorialRepository tutorialRepository, HttpSession httpSession, AuthorService authorService) {
        this.tutorialRepository = tutorialRepository;
        this.authorService = authorService;
    }


    public List<Tutorial> getAllTutorials() {
        return (List<Tutorial>) tutorialRepository.findAll();
    }

    public Tutorial getTutorialById(long id) {
        tutorialRepository.findById(id);
        return null;
    }

    public void addTutorial(Tutorial tutorial, HttpSession session) {
        if (session.getAttribute("author") != null) {
            tutorial.setAuthor((Author) session.getAttribute("author"));
            tutorial.setCreateDate(LocalDate.now());
            tutorialRepository.save(tutorial);
        } else {
            throw new RuntimeException("L'ID de l'auteur n'est pas présent dans la session.");
        }
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
