package com.mgmetehan.libraryservice.service.impl;

import com.mgmetehan.libraryservice.client.BookServiceClient;
import com.mgmetehan.libraryservice.dto.AddBookRequest;
import com.mgmetehan.libraryservice.dto.BookDto;
import com.mgmetehan.libraryservice.dto.LibraryDto;
import com.mgmetehan.libraryservice.exception.LibraryNotFoundException;
import com.mgmetehan.libraryservice.model.Library;
import com.mgmetehan.libraryservice.repository.LibraryRepository;
import com.mgmetehan.libraryservice.service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LibraryServiceImpl implements LibraryService {
    private final LibraryRepository repository;
    private final BookServiceClient bookServiceClient;

    @Override
    public List<String> getAllLibraries() {
        return repository.findAll()
                .stream()
                .map(n -> n.getId())
                .collect(Collectors.toList());
    }

    @Override
    public LibraryDto createLibrary() {
        Library newLibrary = repository.save(new Library());
        return LibraryDto.builder()
                .id(newLibrary.getId())
                .build();
    }

    @Override
    public void addBookToLibrary(AddBookRequest request) {
        String bookId = bookServiceClient.getBookByIsbn(request.getIsbn()).getBody().getBookId();

        Library library = repository.findById(request.getId())
                .orElseThrow(() -> new LibraryNotFoundException("Library could not found by id: " + request.getId()));

        library.getUserBook()
                .add(bookId);

        repository.save(library);
    }

    @Override
    public LibraryDto getAllBooksInLibraryById(String id) {
        Library library = repository.findById(id)
                .orElseThrow(() -> new LibraryNotFoundException("Library could not found by id: " + id));

        List<BookDto> bookDtos = library.getUserBook()
                .stream()
                .map(book -> bookServiceClient.getBookById(book).getBody())
                .collect(Collectors.toList());

        LibraryDto libraryDto = LibraryDto.builder()
                .id(library.getId())
                .userBook(bookDtos).build();

        return libraryDto;
    }
}
