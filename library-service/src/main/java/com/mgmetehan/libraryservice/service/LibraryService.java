package com.mgmetehan.libraryservice.service;

import com.mgmetehan.libraryservice.dto.AddBookRequest;
import com.mgmetehan.libraryservice.dto.LibraryDto;

import java.util.List;

public interface LibraryService {

    LibraryDto getAllBooksInLibraryById(String id);

    List<String> getAllLibraries();

    LibraryDto createLibrary();

    void addBookToLibrary(AddBookRequest request);
}
