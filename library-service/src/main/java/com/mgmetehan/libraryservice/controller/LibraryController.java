package com.mgmetehan.libraryservice.controller;

import com.mgmetehan.libraryservice.client.BookServiceClient;
import com.mgmetehan.libraryservice.dto.AddBookRequest;
import com.mgmetehan.libraryservice.dto.LibraryDto;
import com.mgmetehan.libraryservice.service.LibraryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/library")
@RequiredArgsConstructor
@Slf4j
public class LibraryController {
    private final LibraryService libraryService;
    private final Environment environment;


    private final BookServiceClient bookServiceClient;

    @GetMapping("/{id}")
    public ResponseEntity<LibraryDto> getLibraryById(@PathVariable String id) {
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(libraryService.getAllBooksInLibraryById(id));
    }

    @PostMapping
    public ResponseEntity<LibraryDto> createLibrary() {
        // log.info("Library created on port number " + environment.getProperty("local.server.port"));
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(libraryService.createLibrary());
    }


    @GetMapping
    public ResponseEntity<List<String>> getAllLibraries() {
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(libraryService.getAllLibraries());
    }

    @PutMapping("/add-book")
    public ResponseEntity<Void> addBookToLibrary(@RequestBody AddBookRequest request) {
        libraryService.addBookToLibrary(request);
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).build();
    }


}
