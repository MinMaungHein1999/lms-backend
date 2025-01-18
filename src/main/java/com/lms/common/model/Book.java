package com.lms.common.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;
import java.util.HashSet;

@Data
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private String isbn;
    @Column
    private double price;

    @ManyToMany(mappedBy = "books")
    private Set<Author> authors = new HashSet<>();
}
