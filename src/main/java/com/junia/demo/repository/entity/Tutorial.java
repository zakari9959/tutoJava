package com.junia.demo.repository.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
public class Tutorial {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @Size(min = 2, max = 50)
    private String name;
    private LocalDate createDate;
    @NotNull
    @Size(min = 10, max = 500)
    private String description;
    @NotNull
    @ManyToOne
    private Author author;

    public Tutorial(Long id, String name, LocalDate createDate, String description, Author author) {
        this.id = id;
        this.name = name;
        this.createDate = createDate;
        this.description = description;
        this.author = author;
    }

    public Tutorial() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}