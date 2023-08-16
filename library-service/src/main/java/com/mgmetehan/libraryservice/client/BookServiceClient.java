package com.mgmetehan.libraryservice.client;

import com.mgmetehan.libraryservice.dto.BookDto;
import com.mgmetehan.libraryservice.dto.BookIdDto;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "book-service", path = "/v1/books")
public interface BookServiceClient {
    @GetMapping
    ResponseEntity<List<BookDto>> getAllBook();

    @GetMapping("/isbn/{isbn}")
    ResponseEntity<BookIdDto> getBookByIsbn(@PathVariable @NotEmpty String isbn);

    @GetMapping("/book/{id}")
    ResponseEntity<BookDto> getBookById(@PathVariable @NotEmpty String id);
}
