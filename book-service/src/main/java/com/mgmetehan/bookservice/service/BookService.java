package com.mgmetehan.bookservice.service;

import com.mgmetehan.bookservice.dto.BookDto;

import java.util.List;

public interface BookService {
    List<BookDto> getAllBooks();
}
