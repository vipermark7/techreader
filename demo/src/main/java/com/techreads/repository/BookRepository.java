package com.techreads.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.techreads.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
