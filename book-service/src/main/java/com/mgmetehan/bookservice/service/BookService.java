package com.mgmetehan.bookservice.service;

import com.mgmetehan.bookservice.dto.BookDto;
import com.mgmetehan.bookservice.dto.BookIdDto;

import java.util.List;

public interface BookService {
    List<BookDto> getAllBooks();

    BookIdDto findByIsbn(String isbn);

    BookDto findBookDetailsById(String id);
}
