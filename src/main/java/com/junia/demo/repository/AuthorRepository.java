package com.junia.demo.repository;

import com.junia.demo.repository.entity.Author;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface AuthorRepository extends CrudRepository<Author, Long> {
    Author findByEmail(String email);

}
