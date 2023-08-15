package com.mgmetehan.bookservice.controller;

import com.mgmetehan.bookservice.dto.BookDto;
import com.mgmetehan.bookservice.dto.BookIdDto;
import com.mgmetehan.bookservice.service.BookService;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/books")
@Validated
@Slf4j
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBook() {
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(bookService.getAllBooks());
    }

    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<BookIdDto> getBookByIsbn(@PathVariable @NotEmpty String isbn) {
        log.info("Book requested by isbn: " + isbn );
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(bookService.findByIsbn(isbn));
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable @NotEmpty String id) {
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(bookService.findBookDetailsById(id));
    }
}
