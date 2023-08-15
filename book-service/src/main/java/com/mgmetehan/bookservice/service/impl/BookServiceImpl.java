package com.mgmetehan.bookservice.service.impl;

import com.mgmetehan.bookservice.converter.BookDtoConverter;
import com.mgmetehan.bookservice.dto.BookDto;
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
    /*    List<Book> books = repository.findAll();
        List<BookDto> bookDtos = new ArrayList<>();

        for (Book book : books) {
            BookDto bookDto = BookDtoConverter.convert(book);
            bookDtos.add(bookDto);
        }

        return bookDtos;*/

        return repository.findAll()
                .stream()
                .map(BookDtoConverter::convert)
                .collect(Collectors.toList());
    }

}
