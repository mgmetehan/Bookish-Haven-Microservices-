package com.mgmetehan.bookservice.respository;

import com.mgmetehan.bookservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {
}
