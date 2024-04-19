package com.junia.demo.controller;

import com.junia.demo.repository.entity.Author;
import com.junia.demo.service.AuthorService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
    @GetMapping("/author/login")
    public String showLoginForm(Model model) {
        model.addAttribute("author", new Author());
        return "login";
    }
    @GetMapping("/author/signin")
    public String showSignInForm(Model model) {
        model.addAttribute("author", new Author());
        return "signin";
    }
    @PostMapping("/author/signin")
    public String addAuthor(@ModelAttribute Author author, HttpSession session) {
        if(author != null) {
            authorService.addAuthor(author);
            session.setAttribute("author", author);
        }
        return "redirect:/tutorials";
    }

    public String login(@ModelAttribute Author author, HttpSession session, Model model) {
        // Vérifiez si l'auteur existe dans la base de données avec le bon email et mot de passe
        Author authenticatedAuthor = authorService.authenticate(author.getEmail(), author.getPassword());
        if(authenticatedAuthor != null) {
            session.setAttribute("author", authenticatedAuthor);
            return "redirect:/tutorials";
        } else {
            // Si l'authentification échoue, vous pouvez retourner à la page de connexion avec un message d'erreur
            model.addAttribute("error", "Email ou mot de passe incorrect");
            return "loginPage"; // Assurez-vous d'avoir une vue nommée "loginPage"
        }
    }
}
