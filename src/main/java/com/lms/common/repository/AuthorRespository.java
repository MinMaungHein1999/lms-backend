package com.lms.common.repository;

import com.lms.common.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRespository extends JpaRepository<Author, Long> {
}
