package com.lms.common.service;

import com.lms.common.model.Book;
import com.lms.common.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks(){
        return this.bookRepository.findAll();
    }

    public Book create(Book book){
       return this.bookRepository.save(book);
    }

    public  Book update(Book book){
        return this.bookRepository.save(book);
    }

    public Optional<Book> findById(Long id){
        return this.bookRepository.findById(id);
    }

    public void delete(Long id){
        this.bookRepository.deleteById(id);
    }


}
