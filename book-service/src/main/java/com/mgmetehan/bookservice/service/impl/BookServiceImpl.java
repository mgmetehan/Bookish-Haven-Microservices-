package com.mgmetehan.bookservice.service.impl;

import com.mgmetehan.bookservice.converter.BookDtoConverter;
import com.mgmetehan.bookservice.dto.BookDto;
import com.mgmetehan.bookservice.dto.BookIdDto;
import com.mgmetehan.bookservice.exception.BookNotFoundException;
import com.mgmetehan.bookservice.model.Book;
import com.mgmetehan.bookservice.respository.BookRepository;
import com.mgmetehan.bookservice.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository repository;
    private final BookDtoConverter BookDtoConverter;

    @Override
    public List<BookDto> getAllBooks() {
        return repository.findAll()
                .stream()
                .map(BookDtoConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public BookIdDto findByIsbn(String isbn) {
        return repository.findByIsbn(isbn)
                .map(book -> new BookIdDto(book.getId(), book.getIsbn()))
                .orElseThrow(() -> new BookNotFoundException("Book could not found by isbn: " + isbn));
    }

    @Override
    public BookDto findBookDetailsById(String id) {
        return repository.findById(id)
                .map(BookDtoConverter::convert)
                .orElseThrow(() -> new BookNotFoundException("Book could not found by id:" + id));
    }
}
