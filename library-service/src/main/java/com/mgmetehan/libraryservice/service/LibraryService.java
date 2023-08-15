package com.mgmetehan.libraryservice.service;

import com.mgmetehan.libraryservice.dto.LibraryDto;

import java.util.List;

public interface LibraryService {

    LibraryDto getAllBooksInLibraryById();

    List<String> getAllLibraries();

    LibraryDto createLibrary();
}
