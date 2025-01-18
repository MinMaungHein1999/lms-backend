package com.lms.common.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column
    private String name;
    @Column
    private String email;

    @ManyToMany
    @JoinTable(
            name="author_book",
            joinColumns = @JoinColumn(name= "author_id"),
            inverseJoinColumns = @JoinColumn(name= "book_id"))
    private  Set<Book> books = new HashSet<>();

}
