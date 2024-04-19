package com.junia.demo.controller;

import com.junia.demo.repository.entity.Tutorial;
import com.junia.demo.service.TutorialService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TutorialController {

    private final TutorialService tutorialService;

    public TutorialController(TutorialService tutorialService) {
        this.tutorialService = tutorialService;
    }
    @GetMapping("/tutorials/add")
    public String addTutorial(Model model) {
        model.addAttribute("newTuto", new Tutorial());
        return "addTutorial";
    }

    @GetMapping("/tutorials")
    public String displayTutorialList(Model model, HttpSession session) {
        List<Tutorial> tutorialList = tutorialService.getAllTutorials();
        model.addAttribute("tutos", tutorialList);

        Object author = session.getAttribute("author");
        if (author != null) {
            model.addAttribute("author", author);
        }

        return "tutoList";
    }


    @PostMapping("/tutorials")
    public String addTutorial(@ModelAttribute Tutorial tutorial, HttpSession session) {
        tutorialService.addTutorial(tutorial, session);
        return "redirect:/tutorials";
    }
}
