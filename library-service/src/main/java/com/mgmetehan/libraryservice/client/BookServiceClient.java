package com.mgmetehan.libraryservice.client;

import com.mgmetehan.libraryservice.dto.BookDto;
import com.mgmetehan.libraryservice.dto.BookIdDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "book-service", path = "/v1/books")
public interface BookServiceClient {

    @GetMapping("/isbn/{isbn}")
    ResponseEntity<BookIdDto> getBookByIsbn(@PathVariable(value = "isbn") String isbn);

    @GetMapping("/book/{bookId}")
    ResponseEntity<BookDto> getBookById(@PathVariable(value = "bookId") String bookId);


}
