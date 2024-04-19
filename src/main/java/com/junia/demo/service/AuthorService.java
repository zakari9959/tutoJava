package com.junia.demo.service;

import com.junia.demo.repository.AuthorRepository;
import com.junia.demo.repository.entity.Author;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void addAuthor(Author author) {
        authorRepository.save(author);
    }
    public Author authenticate(String email, String password) {
        // Recherchez l'auteur dans la base de données par email
        Author author = authorRepository.findByEmail(email);
        if(author != null && author.getPassword().equals(password)) {
            return author; // Si trouvé et mot de passe correspondant, retournez l'auteur
        }
        return null; // Sinon, retournez null
    }
}
